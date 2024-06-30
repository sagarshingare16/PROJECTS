package com.studentManagement.service;

import com.studentManagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudentInfo(Student student);
    Student updateStudentInfo(Student student);
    Student getStudentInfoById(Long studentId);
    void deleteStudentById(Long studentId);
}
