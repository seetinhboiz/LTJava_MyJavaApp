/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.ttn.pojo.Class;
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
    private ClassService classService;

    @Override
    public List<Class> getClass(Map<String, String> param) {
        return this.classService.getClass(param);
    }
}
