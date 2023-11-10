/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.formatter;

import com.ttn.pojo.Subject;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class SubjectFormatter implements Formatter<Subject> {

    @Override
    public String print(Subject idSubject, Locale locale) {
        return String.valueOf(idSubject.getId());
    }

    @Override
    public Subject parse(String idSubject, Locale locale) throws ParseException {
        return new Subject(Integer.parseInt(idSubject));    
    }
}
