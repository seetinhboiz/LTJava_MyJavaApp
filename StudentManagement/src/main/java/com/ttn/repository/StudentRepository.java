/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttn.repository;

import com.ttn.pojo.Student;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface StudentRepository {
    List<Student> getStudents(Map<String, String> param);
    boolean addOrUpdateStudent(Student student);
    Student getStudentById (int id);
    boolean deleteStudent(int id);
}
