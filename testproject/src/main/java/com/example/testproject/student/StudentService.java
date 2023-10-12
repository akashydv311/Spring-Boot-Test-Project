package com.example.testproject.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentService {

    public List<Student> getStudent() {
        return List.of(
                new Student(101L,
                        "Tiriyan",
                        21,
                        "terian.lay087@gmail.com",
                        LocalDate.of(2001, Month.JANUARY, 05)));
    }

}
