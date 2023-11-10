/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ttn.pojo.Student;
import com.ttn.repository.StudentRepository;
import com.ttn.repository.impl.StudentRepositoryImpl;
import com.ttn.service.StudentService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Student> getStudents(Map<String, String> param) {
        return this.studentRepository.getStudents(param);
    }

    @Override
    public boolean addOrUpdateStudent(Student student) {
        if (!student.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(student.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                student.setAvata(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(StudentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.studentRepository.addOrUpdateStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return this.studentRepository.getStudentById(id);
    }

    @Override
    public boolean deleteStudent(int id) {
        return this.studentRepository.deleteStudent(id);
    }
}
