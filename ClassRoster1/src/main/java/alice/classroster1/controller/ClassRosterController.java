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
import alice.classroster1.ui.UserIO;
import alice.classroster1.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author ankang150
 */
public class ClassRosterController {

    private final UserIO io = new UserIOConsoleImpl();
    ClassRosterView view = new ClassRosterView();
    ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        
        while (keepGoing) {
           
            int menuSelection = 0;
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4: 
                    io.print("REMOVE STUDENT");
                    break; 
                case 5:
                    keepGoing = false;
                    break;
                default: 
                    io.print("UNKNOWN COMMAND");
                    
            }
        }
        io.print("GOOD BYE");
    }
    private int getMenuSelection() {
        return view.printMenuAndGeteSelection();
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
}
