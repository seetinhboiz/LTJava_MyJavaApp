/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.formatter;

import com.ttn.pojo.Lecture;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class LectureFormatter implements Formatter<Lecture>{

    @Override
    public String print(Lecture idLecture, Locale locale) {
        return String.valueOf(idLecture.getId());
    }

    @Override
    public Lecture parse(String idLecture, Locale locale) throws ParseException {
        return new Lecture(Integer.parseInt(idLecture));
    }
}
