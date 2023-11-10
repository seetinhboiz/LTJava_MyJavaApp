/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.formatter;

import com.ttn.pojo.Class;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class ClassFormatter implements Formatter<com.ttn.pojo.Class>{
    @Override
    public Class parse(String idClass, Locale locale) throws ParseException {
        return new com.ttn.pojo.Class(Integer.parseInt(idClass));
    }

    @Override
    public String print(Class object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
