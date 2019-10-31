package com.teachmemaster.service;

import com.teachmemaster.domain.Student;
import com.teachmemaster.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teachmemaster.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository;


    @Autowired
    public  TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }


    @Override
    public List<Optional<Teacher>> getTeacherById(int id) {
        return teacherRepository.selectTeacherById(id);
    }


    @Override
    public void storeTeacher(Teacher teacher) {
        teacherRepository.storeTeacher(teacher);
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
       return teacherRepository.selectTeacherByName(name);
    }

    @Override public Set<Student> getStudentsByTeacherId(int teacherId) {
        return teacherRepository.getStudentsByTeacherId(teacherId).stream().collect(Collectors.toSet());
    }

    @Override public Set<Student> getStudentsByTeacherName(String teacherName) {
        return teacherRepository.getStudentsByTeacherName(teacherName).stream().collect(Collectors.toSet());
    }
}
