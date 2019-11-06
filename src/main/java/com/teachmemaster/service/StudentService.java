package com.teachmemaster.service;

import com.teachmemaster.domain.Student;

import java.util.Optional;

public interface StudentService {

    void storeStudent(Student student);

    Optional<Student> getStudentById(int id);
}
