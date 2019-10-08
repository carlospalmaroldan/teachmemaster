package com.teachmemaster.domain;

import java.time.Instant;

public class Teacher {

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

    public static class Builder{
       private  String name;
       private Instant createDate;
       private Instant updateDate;
       private Long studentId;

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

        public  Teacher build(){
            Teacher  teacher= new Teacher();
            teacher.name=this.name;
            teacher.createDate=this.createDate;
            teacher.studentId=this.studentId;
            teacher.updateDate=this.updateDate;
            return teacher;
        }
    }


    public String toString() {
        return "Teacher [name=" + this.name + "]";
    }
}
