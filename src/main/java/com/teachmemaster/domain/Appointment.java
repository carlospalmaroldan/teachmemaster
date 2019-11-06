package com.teachmemaster.domain;
import com.teachmemaster.domain.Student;

import java.time.Instant;
import java.util.List;

public class Appointment {
    Teacher teacher;
    List<Student> student;
    Instant startTime;
    Instant endTime;


    public Appointment(Teacher teacher, List<Student> student, Instant appointedTime){
        this.teacher = teacher;
        this.student = student;
        this.startTime = startTime;
        this.endTime = endTime;
    }




}
