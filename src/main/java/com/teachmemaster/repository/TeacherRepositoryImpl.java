package com.teachmemaster.repository;

import com.teachmemaster.domain.Student;
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

    private static String INSERT_TEACHER = "insert into TEACHERS(name,create_date) VALUES (?,?)";

    private static String GET_STUDENTS_BY_TEACHER_ID = "select s.create_date,s.name "
        + "from students s inner join teachers_students ts "
        + "ON s.student_id = ts.student_id "
        + "INNER JOIN teachers t "
        + "ON t.teacher_id = ts.teacher_id "
        + "WHERE t.teacher_id = ?";

    private static String GET_STUDENTS_BY_TEACHER_NAME = "select s.create_date,s.name "
        + "from students s inner join teachers_students ts "
        + "ON s.student_id = ts.student_id "
        + "INNER JOIN teachers t "
        + "ON t.teacher_id = ts.teacher_id "
        + "WHERE t.name= ?";


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
        jdbcTemplate.update(INSERT_TEACHER,teacher.getName(), Instant.now());
    }

    @Override public List<Teacher> selectTeacherByName(String name) {
       return jdbcTemplate.query(SELECT_TEACHER_BY_NAME,new Object[]{name}, new TeacherRowMapper());
    }

    @Override
    public List<Student> getStudentsByTeacherId(int teacherId){
        return jdbcTemplate.query(GET_STUDENTS_BY_TEACHER_ID,new Object[]{teacherId},new StudentRowMapper());
    }

    @Override public List<Student> getStudentsByTeacherName(String teacherName) {
        return jdbcTemplate.query(GET_STUDENTS_BY_TEACHER_NAME,new Object[]{teacherName},new StudentRowMapper());
    }

}
