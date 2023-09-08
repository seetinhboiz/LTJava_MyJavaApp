/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.ttn.pojo.Student;
import com.ttn.service.ScoreSheetService;
import com.ttn.service.StudentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentService studentService;

    @Override
    public List<Student> getStudents(Map<String, String> param) {
        return this.studentService.getStudents(param);
    }
}
