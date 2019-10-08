package com.teachmemaster.domain;


public class Teacher {

    String name;

    public Teacher(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String toString() {
        return "Teacher [name=" + this.name + "]";
    }
}
