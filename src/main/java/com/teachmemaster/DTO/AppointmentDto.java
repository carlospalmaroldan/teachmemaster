package com.teachmemaster.DTO;

import com.teachmemaster.domain.Student;
import com.teachmemaster.domain.Teacher;

import java.time.Instant;
import java.util.List;

public class AppointmentDto {
    Teacher teacher;
    List<Student> students;
    Instant startTime;
    Instant endTime;


    public AppointmentDto(Teacher teacher, List<Student> students, Instant appointedTime){
        this.teacher = teacher;
        this.students = students;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime(){
        return endTime;
    }

    public List<Student> getStudents(){
        return this.students;
    }

    public Teacher getTeacher(){
        return teacher;
    }
}
