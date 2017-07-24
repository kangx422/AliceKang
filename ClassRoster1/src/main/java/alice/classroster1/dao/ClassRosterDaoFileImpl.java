/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.dao;

import alice.classroster1.dto.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// hold all data in memory only
/**
 *
 * @author ankang150
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {
    
    private Map<String,Student> students = new HashMap<>();
    
    @Override
    public Student addStudent(String studentId, Student student) {
        Student newStudent = students.put(studentId, student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values()); 
        /* this code get all of the Student objects out of the students map as a collection 
        by calling the values() method.
        */ 
    }

    @Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) {
        Student removedStudent = students.remove(studentId);
        return removedStudent;
    }



}
