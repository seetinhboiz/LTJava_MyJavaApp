/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.ttn.pojo.Subject;
import com.ttn.repository.SubjectRepository;
import com.ttn.service.SubjectService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getSubjects(Map<String, String> param) {
        return this.subjectRepository.getSubject(param);
    }

    @Override
    public boolean addOrUpdateSubject(Subject sbjct) {
        return this.subjectRepository.addOrUpdateSubject(sbjct);
    }

    @Override
    public Subject getSubjectById(int id) {
        return this.subjectRepository.getSubjectById(id);
    }

    @Override
    public boolean deleteSubject(int id) {
        return this.subjectRepository.deleteSubject(id);
    }
}
