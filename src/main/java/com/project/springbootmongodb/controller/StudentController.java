package com.project.springbootmongodb.controller;

import com.project.springbootmongodb.model.Student;
import com.project.springbootmongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> createStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") String studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
       return studentService.createNewStudent(student);
    }

    @PutMapping("/{id}")
    public Optional<Student> updateStudentById(@PathVariable("id") String studentId, @RequestBody Student student) {
        return studentService.updateStudenById(studentId, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable("id") String studentId) {
        boolean deleted = studentService.deleteStudenById(studentId);
        if (deleted) return "Student Deleted";
        return "Could not delete the student";
    }
}
