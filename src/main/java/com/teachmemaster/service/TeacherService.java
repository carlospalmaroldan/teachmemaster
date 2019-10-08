package com.teachmemaster.service;

import com.teachmemaster.domain.Teacher;

import java.util.List;
import java.util.Optional;


public interface TeacherService {
    public List<Optional<Teacher>> getTeacherById(int id);
}
