package com.teachmemaster.repository;

import com.teachmemaster.domain.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
public class TeacherRepositoryImpl implements TeacherRepository{

    JdbcTemplate jdbcTemplate;

    private static String SELECT_TEACHER_BY_ID ="select * from TEACHERS WHERE teacher_id = ?";

    private static String SELECT_TEACHER_BY_NAME="select * from TEACHERS WHERE name = ?";

    private static String INSERT_TEACHER = "insert into TEACHERS(name,create_date,student_id) VALUES (?,?,?)";

    public TeacherRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<Optional<Teacher>> selectTeacherById(int id){
        return jdbcTemplate.query(SELECT_TEACHER_BY_ID,new Object[]{id},(rs, rowNum) ->
            Optional.of(Teacher.builder().name(
                rs.getString("name")
            ).build()));
    }

    @Override public void storeTeacher(Teacher teacher) {
        jdbcTemplate.update(INSERT_TEACHER,teacher.getName(), Instant.now(),null);
    }

    @Override public List<Teacher> selectTeacherByName(String name) {
       return jdbcTemplate.query(SELECT_TEACHER_BY_NAME,new Object[]{name}, new TeacherRowMapper());
    }

}
