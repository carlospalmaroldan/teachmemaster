package com.teachmemaster.repository;

import com.teachmemaster.domain.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherRepositoryImpl implements TeacherRepository{

    JdbcTemplate jdbcTemplate;

    private static String SELECT_TEACHER_BY_NAME="select * from TEACHERS WHERE teacher_id = ?";

    public TeacherRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<Optional<Teacher>> selectTeacherById(int id){
        return jdbcTemplate.query(SELECT_TEACHER_BY_NAME,new Object[]{id},(rs, rowNum) ->
            Optional.of(new Teacher(
                rs.getString("name")
            )));
    }

}
