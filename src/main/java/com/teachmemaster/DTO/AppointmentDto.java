package com.teachmemaster.DTO;

import com.teachmemaster.domain.Student;
import com.teachmemaster.domain.Teacher;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDto {
    Teacher teacher;
    List<Student> students;
    Instant startTime;
    Instant endTime;


    private AppointmentDto(Teacher teacher, List<Student> students, Instant startTime, Instant endTime){
        this.teacher = teacher;
        this.students = students;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        Teacher teacher;
        List<Student> students= new ArrayList<>();
        Instant startTime;
        Instant endTime;

        public Builder teacher(Teacher teacher){
            this.teacher=teacher;
            return  this;
        }

        public Builder students(List<Student> students) {
            this.students.addAll(students);
            return this;
        }

        public Builder startTime(Instant startTime){
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Instant endTime){
            this.endTime = endTime;
            return this;
        }

        public AppointmentDto build(){
            return new AppointmentDto(teacher,students,startTime,endTime);
        }
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
