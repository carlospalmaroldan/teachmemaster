package com.teachmemaster.repository;

import com.teachmemaster.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    JdbcTemplate jdbcTemplate;

    private static final String INSERT_STUDENT="insert into STUDENTS(name,create_date,appointment_id)"
        + "VALUES(?,?,?)";


    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storeStudent(Student student){
        jdbcTemplate.update(INSERT_STUDENT,student.getName(),student.getCreateDate(),null);
    }

}
