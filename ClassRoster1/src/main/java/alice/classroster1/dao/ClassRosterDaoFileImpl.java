/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.dao;

import alice.classroster1.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
// hold all data in memory only

/**
 *
 * @author ankang150
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    private Map<String, Student> students = new HashMap<>();

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    // loadRoster is a method 
    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;

        try {
            // Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));

        } catch (FileNotFoundException ex) {
            throw new ClassRosterDaoException("Could not load roster data into memory", ex);
        }

        String currentLine;
        // currentLine holds the most recent line read from the file
        String[] currentTokens;
        // currentTokens holds each of the parts of the currentLine after it has been split on our DELIMITER
        // it goes through ROSTER_FIle line by line, decoding each line into a Student object. 

        while (scanner.hasNextLine()) {
            // get the next line in the file with... 
            currentLine = scanner.nextLine();
            // break up the line into token like..
            currentTokens = currentLine.split(DELIMITER);

            // Create a new Student object and put it in the map of student
            // our map key is the student id which is currentTokens[0] as the map key for our student object
            // we also have to pass the student id into the Student constructor 
            Student currentStudent = new Student(currentTokens[0]);
            // set the remaining values on currentStudent manually 
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setStudentId(currentTokens[3]);

            // put currentStudent into the map using studentID as the key 
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        // close scanner 
        scanner.close();
    }

    private void writeRoster() throws ClassRosterDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException ex) {
            throw new ClassRosterDaoException(
                    "Could not save student data.", ex);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            // write the Student object to the file
            out.println(currentStudent.getStudentId() + DELIMITER
                    + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterDaoException {
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList<Student>(students.values());
        //This method reads all the Student objects from the file, gets them out of the map, 
        //and then returns an ArrayList of the Student objects to the caller.
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentId);
//        This method removes the specified Student object from our map, 
//        writes the updated students map to the file, 
//        and returns the removed Student object to the caller
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterDaoException {
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
//        This method removes the specified Student object from our map, 
//        writes the updated students map to the file, 
//        and returns the removed Student object to the caller
    }
}
