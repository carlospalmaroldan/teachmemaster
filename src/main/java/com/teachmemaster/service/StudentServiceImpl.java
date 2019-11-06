package com.teachmemaster.service;

import com.teachmemaster.domain.Student;
import com.teachmemaster.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void storeStudent(Student student) {
        studentRepository.storeStudent(student);
    }
}
