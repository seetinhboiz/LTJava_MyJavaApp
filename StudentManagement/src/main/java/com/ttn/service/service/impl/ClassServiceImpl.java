/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.ttn.pojo.Class;
import com.ttn.repository.ClassRepository;
import com.ttn.service.ClassService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Class> getClass(Map<String, String> param) {
        return this.classRepository.getClass(param);
    }

    @Override
    public boolean addOrUpdateClass(Class _class) {
        return this.classRepository.addOrUpdateClass(_class);
    }

    @Override
    public Class getClassById(int id) {
        return this.classRepository.getClassById(id);
    }

    @Override
    public boolean deleteClass(int id) {
        return this.classRepository.deleteClass(id);
    }
}
