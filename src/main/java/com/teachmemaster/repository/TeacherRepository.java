package com.teachmemaster.repository;

import com.teachmemaster.domain.Student;
import com.teachmemaster.domain.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TeacherRepository {

    List<Optional<Teacher>> selectTeacherById(int id);

    void storeTeacher(Teacher teacher);

    List<Teacher> selectTeacherByName(String name);

    public List<Student> getStudentsByTeacherId(int teacherId);
}
