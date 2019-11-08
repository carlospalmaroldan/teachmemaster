package com.teachmemaster.service;

import com.teachmemaster.domain.Student;
import com.teachmemaster.domain.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
     List<Optional<Teacher>> getTeacherById(int id);

     List<Teacher> getTeacherByName(String name);

     void storeTeacher(Teacher teacher);

     List<Student> getStudentsByTeacherId(int teacherId);

     List<Student> getStudentsByTeacherName(String teacherName);
}
