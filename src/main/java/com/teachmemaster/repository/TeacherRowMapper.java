package com.teachmemaster.repository;

import com.teachmemaster.domain.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRowMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet resultSet, int rowNum) throws SQLException {
      return Teacher.builder()
           .createDate(resultSet.getTimestamp("create_date").toInstant())
           .updateDate(resultSet.getTimestamp("update_date").toInstant())
           .name(resultSet.getString("name"))
           .build();
    }
}
