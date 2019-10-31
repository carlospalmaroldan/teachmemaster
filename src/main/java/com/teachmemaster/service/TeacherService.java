package com.teachmemaster.service;

import com.teachmemaster.domain.Student;
import com.teachmemaster.domain.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TeacherService {
     List<Optional<Teacher>> getTeacherById(int id);

     List<Teacher> getTeacherByName(String name);

     void storeTeacher(Teacher teacher);

     Set<Student> getStudentsByTeacherId(int teacherId);

     Set<Student> getStudentsByTeacherName(String teacherName);
}
