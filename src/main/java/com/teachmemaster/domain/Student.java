package com.teachmemaster.domain;

import java.time.Instant;

public class Student {

    private String name;
    private Instant createDate;

    public static Builder builder(){
        return new Builder();}

    public static class Builder{
        private  String name;
        private Instant createDate;


        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder createDate(Instant createDate){
            this.createDate=createDate;
            return this;
        }

        public  Student build(){
            Student  student= new Student();
            student.name=this.name;
            student.createDate=this.createDate;
            return student;
        }
    }

    public String getName(){
        return this.name;
    }

    public Instant getCreateDate(){
        return this.createDate;
    }
}
