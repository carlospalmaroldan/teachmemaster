package com.teachmemaster.domain;
import com.teachmemaster.domain.Student;

import java.time.Instant;

public class Appointment {
    Teacher teacher;
    Student student;
    Instant appointedTime;

    public Appointment(Teacher teacher, Student student, Instant appointedTime){
        this.teacher = teacher;
        this.student = student;
        this.appointedTime = appointedTime;
    }


}
