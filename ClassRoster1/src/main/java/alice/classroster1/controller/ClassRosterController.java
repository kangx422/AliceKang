/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.controller;

import alice.classroster1.dao.ClassRosterDao;
import alice.classroster1.dao.ClassRosterDaoException;
import alice.classroster1.dao.ClassRosterDaoFileImpl;
import alice.classroster1.dto.Student;
import alice.classroster1.ui.ClassRosterView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ankang150
 */
public class ClassRosterController {

//    ClassRosterView view = new ClassRosterView();
    ClassRosterView view;
//    ClassRosterController should not be responsible for instantiating a new ClassRosterDaoFileImpl object
//    ClassRosterDao dao = new ClassRosterDaoFileImpl();
    ClassRosterDao dao;

//Now we must implement a constructor that initializes these members. 
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        
        try {
            while (keepGoing) {
                int menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (ClassRosterDaoException ex) {
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent() throws ClassRosterDaoException { //the changes in the DAO broke the controller. The methods in our controller that call DAO methods now have compile errors because they don't have any code to handle the new ClassRosterDaoExceptions that DAO is throwing
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterDaoException {
        view.displayAllStudentsBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void searchStudent() throws ClassRosterDaoException {
        view.displaySearchedStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        dao.removeStudent(studentId);
        view.displaySuccessfullyRemovedBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
