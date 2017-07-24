/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.controller;

import alice.classroster1.dao.ClassRosterDao;
import alice.classroster1.dao.ClassRosterDaoFileImpl;
import alice.classroster1.dto.Student;
import alice.classroster1.ui.ClassRosterView;
import java.util.List;

/**
 *
 * @author ankang150
 */
public class ClassRosterController {

    ClassRosterView view = new ClassRosterView();
    ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
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
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() {
        view.displayAllStudentsBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void searchStudent() {
        view.displaySearchedStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() {
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
