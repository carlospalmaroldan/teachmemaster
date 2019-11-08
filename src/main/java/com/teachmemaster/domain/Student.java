package com.teachmemaster.domain;

import java.time.Instant;

public class Student {
    private Long studentId;
    private String name;
    private Instant createDate;

    public static Builder builder(){
        return new Builder();}

    public static class Builder{
        private  String name;
        private Instant createDate;
        private Long studentId;


        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder createDate(Instant createDate){
            this.createDate=createDate;
            return this;
        }

        public Builder studentId(Long studentId){
            this.studentId=studentId;
            return this;
        }

        public  Student build(){
            Student  student= new Student();
            student.name=this.name;
            student.createDate=this.createDate;
            student.studentId=this.studentId;
            return student;
        }
    }

    public String getName(){
        return this.name;
    }

    public Long getStudentId(){
        return this.studentId;
    }

    public Instant getCreateDate(){
        return this.createDate;
    }
}
