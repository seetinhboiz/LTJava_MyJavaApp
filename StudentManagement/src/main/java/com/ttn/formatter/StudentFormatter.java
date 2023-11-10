/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.formatter;

import com.ttn.pojo.Lecture;
import com.ttn.pojo.Student;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class StudentFormatter implements Formatter<Student>{

    @Override
    public String print(Student idStudent, Locale locale) {
        return String.valueOf(idStudent.getId());
    }

    @Override
    public Student parse(String idStudent, Locale locale) throws ParseException {
        return new Student(Integer.parseInt(idStudent));
    }
    
}
