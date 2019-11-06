package com.teachmemaster.repository;

import com.teachmemaster.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    JdbcTemplate jdbcTemplate;

    private static final String INSERT_STUDENT="insert into STUDENTS(name,create_date,appointment_id)"
        + "VALUES(?,?,?)";

    private static final String GET_STUDENT_BY_ID="select * from STUDENTS where student_id = ?";


    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storeStudent(Student student){
        jdbcTemplate.update(INSERT_STUDENT,student.getName(),student.getCreateDate(),null);
    }

    public Optional<Student> getStudentById(int id){
        List<Student> studentList=new ArrayList<>();
        jdbcTemplate.query(GET_STUDENT_BY_ID,new Object[] { id },rs->{
            while(rs.next()){
            studentList.add( Student.builder().name(rs.getString("name"))
                .createDate(rs.getTimestamp("create_date").toInstant())
                .build());
            }
            return studentList;
        });
        return studentList.stream().findFirst();
    }
}
