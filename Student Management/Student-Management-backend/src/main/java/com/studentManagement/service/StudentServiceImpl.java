package com.studentManagement.service;

import com.studentManagement.model.Student;
import com.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudentInfo(Student student) {
            return studentRepository.save(student);
        }

    @Override
    public Student updateStudentInfo(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentInfoById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new RuntimeException("No such student is present.."));
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

