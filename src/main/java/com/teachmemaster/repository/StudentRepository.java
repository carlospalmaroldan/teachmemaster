package com.teachmemaster.repository;

import com.teachmemaster.domain.Student;

import java.util.Optional;

public interface StudentRepository {

    void storeStudent(Student student);

    Optional<Student> getStudentById(int id);
}
