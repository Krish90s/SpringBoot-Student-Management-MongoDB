package com.project.springbootmongodb.service;

import com.project.springbootmongodb.model.Student;
import com.project.springbootmongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public String createNewStudent(Student student) {
        return studentRepository.save(student).getId();
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(String studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Optional<Student> updateStudenById(String studentId, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isPresent()){
            Student existingStudent = studentOptional.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setDob(student.getDob());
            existingStudent.setUpdatedAt(student.getUpdatedAt());
            Student updatedStudent = studentRepository.save(existingStudent);
            return Optional.of(updatedStudent);
        }

        return  null;
    }

    @Override
    public boolean deleteStudenById(String studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isPresent()){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
}
