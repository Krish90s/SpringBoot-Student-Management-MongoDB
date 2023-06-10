package com.project.springbootmongodb.service;

import com.project.springbootmongodb.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    String createNewStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(String studentId);

    Optional<Student> updateStudenById(String studentId, Student student);

    boolean deleteStudenById(String studentId);
}
