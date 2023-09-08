/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttn.service;

import com.ttn.pojo.Subject;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface SubjectService {
    List<Subject> getSubjects(Map<String, String> param);
    boolean addOrUpdateSubject(Subject s);
    Subject getSubjectById(int id);
    boolean deleteSubject(int id);
}
