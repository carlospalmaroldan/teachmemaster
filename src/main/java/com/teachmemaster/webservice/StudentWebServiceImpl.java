package com.teachmemaster.webservice;

import com.teachmemaster.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.teachmemaster.service.StudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentWebServiceImpl {

    @Autowired
    StudentService studentService;

    public StudentWebServiceImpl(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/student")
    public void storeTeacher(@RequestBody Student student){
        studentService.storeStudent(student);
    }
}
