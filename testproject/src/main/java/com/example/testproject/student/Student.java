package com.example.testproject.student;

import java.time.LocalDate;

public class Student {
    private long id;
    private String name;
    private Integer age;
    private String email;
    private LocalDate dob;

    public Student() {
    }

    public Student(long id, String name, Integer age, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, Integer age, String email, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", dob=" + dob + "]";
    }

}
