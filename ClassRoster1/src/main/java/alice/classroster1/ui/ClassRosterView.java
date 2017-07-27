/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.ui;

import alice.classroster1.dto.Student;
import java.util.List;

/**
 *
 * @author ankang150
 */
public class ClassRosterView {

//    UserIO io = new UserIOConsoleImpl();
    private UserIO io;
    
    public ClassRosterView(UserIO io) {
        this.io = io;
    }
//    ClassRosterView should not be responsible for instantiating a new UserIOConsoleImpl object

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");
        
        return io.readInt("Please select from the above choices.", 1,5);
    }
    
    public Student getNewStudentInfo() {
        String studentId = io.readString("Enter Student ID: ");
        String firstName = io.readString("Enter first name: ");
        String lastName = io.readString("Enter last name: ");
        String cohort = io.readString("Enter cohort: ");
        
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }
    
    public void displayCreateStudentBanner() {
        io.print("==== Create Student ====");
    }
    
    public void displayCreateSuccessBanner() {
        io.print("Student successfully created. Please hit enter to continue");
    }
    
    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.print(currentStudent.getStudentId() + " - " 
            + currentStudent.getFirstName() + " " 
            + currentStudent.getLastName());
        } io.readString("Please hit enter to continue");
    }
    
    public void displayAllStudentsBanner() {
        io.print("==== Students ====");
    }
    
    public void displaySearchedStudentBanner() {
        io.print("==== Informatoin on Searched Student ====");
    }
    
    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID");
    }
    
    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student exists");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveStudentBanner(){
        io.print("==== Remove Student ====");
    }

    public void displaySuccessfullyRemovedBanner(){
        io.readString("Student succesfully removed. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.readString("Goodybe!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown command");
    }
}
