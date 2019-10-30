package com.teachmemaster.repository;

import com.teachmemaster.domain.Student;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        return Student.builder().
            createDate(resultSet.getTimestamp("create_date").toInstant())
            .name(resultSet.getString("name"))
            .build();
    }
}
