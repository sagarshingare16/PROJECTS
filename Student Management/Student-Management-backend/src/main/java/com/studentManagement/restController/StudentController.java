package com.studentManagement.restController;

import com.studentManagement.model.Student;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get-all-students")
    public ResponseEntity<List<Student>> getAllStudentInfo(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @PostMapping("/save-student")
    public ResponseEntity<Student> saveStudentInfo(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudentInfo(student), HttpStatus.CREATED);
    }

    @PostMapping("/update-student")
    public ResponseEntity<Student> updateStudentInfo(@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudentInfo(student),HttpStatus.CREATED);
    }

    @GetMapping("/get-student-details/{studentId}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.getStudentInfoById(studentId),HttpStatus.OK);
    }

    @DeleteMapping("/delete-student/{studentId}")
    public ResponseEntity<Student> deleteStudentInfo(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return ResponseEntity.noContent().build();
    }

}
