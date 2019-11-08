package com.teachmemaster.domain;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    Teacher teacher;
    List<Student> student;
    Instant startTime;
    Instant endTime;


    public Appointment(Teacher teacher, List<Student> student, Instant startTime,Instant endTime){
        this.teacher = teacher;
        this.student = student;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Builder builder(){
        return new Builder();}

    public static class Builder{
        Teacher teacher;
        List<Student> students= new ArrayList<>();
        Instant startTime;
        Instant endTime;


        public Builder teacher(Teacher teacher){
            this.teacher=teacher;
            return this;
        }

        public Builder withStudent(Student student){
            this.students.add(student);
            return this;
        }

        public Builder withAllTheseStudents(List<Student> students){
            this.students.addAll(students);
            return this;
        }

        public Builder startTime(Instant startTime){
            this.startTime=startTime;
            return this;
        }

        public Builder endTime(Instant endTime){
            this.endTime=endTime;
            return this;
        }

        public  Appointment build(){
            Appointment  appointment= new Appointment(teacher,students,startTime,endTime);
            return appointment;
        }
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime(){
        return endTime;
    }

    public Teacher getTeacher(){
        return teacher;
    }
}
