package com.ApacheCamel.EIP.Controller;

import com.ApacheCamel.EIP.Entity.Student;
import com.ApacheCamel.EIP.Service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicController {


    @Autowired
    StudentService studentService;
    @GetMapping("/JustAString")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("this is from a rest service");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.initStudentModel());
    }
    @GetMapping("/students/1")
    public ResponseEntity<Student> getStudentById(){
        Student student =new Student(1,"mahmoud","grade 1");

        return ResponseEntity.ok(student);
    }
}
