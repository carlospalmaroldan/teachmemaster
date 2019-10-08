package com.teachmemaster.repository;

import com.teachmemaster.domain.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {

    List<Optional<Teacher>> selectTeacherById(int id);
}
