package com.teachmemaster.domain;

import java.time.Instant;

public class Teacher {

    private Long teacherId;
    private String name;
    private Instant updateDate;
    private Instant createDate;
    private Long studentId;


    public static Builder builder(){
        return new Builder();
    }

    public String getName(){
        return this.name;
    }

    public Long getTeacherId(){
        return this.teacherId;
    }

    public static class Builder{
       private  String name;
       private Instant createDate;
       private Instant updateDate;
       private Long studentId;
       private Long teacherId;

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder createDate(Instant createDate){
            this.createDate=createDate;
            return this;
        }

        public Builder updateDate(Instant updateDate){
            this.updateDate=updateDate;
            return this;
        }

        public Builder studentId(Long studentId){
            this.studentId=studentId;
            return this;
        }

        public  Builder teacherId(Long teacherId){
            this.teacherId=teacherId;
            return this;
        }

        public  Teacher build(){
            Teacher  teacher= new Teacher();
            teacher.name=this.name;
            teacher.createDate=this.createDate;
            teacher.studentId=this.studentId;
            teacher.updateDate=this.updateDate;
            teacher.teacherId=this.teacherId;
            return teacher;
        }
    }


    public String toString() {
        return "Teacher [name=" + this.name + "]";
    }
}
