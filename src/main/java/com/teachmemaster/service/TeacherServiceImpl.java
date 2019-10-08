package com.teachmemaster.service;

import com.teachmemaster.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teachmemaster.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {



    TeacherRepository teacherRepository;


    @Autowired
    public  TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }


    @Override public List<Optional<Teacher>> getTeacherById(int id) {
        return teacherRepository.selectTeacherById(id);
    }
}
