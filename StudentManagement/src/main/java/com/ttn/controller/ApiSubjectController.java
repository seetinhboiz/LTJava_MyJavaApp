/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Subject;
import com.ttn.service.SubjectService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api") 
public class ApiSubjectController {
    @Autowired
    private SubjectService subjectService;
    
    @DeleteMapping("/subject/subjectManagement/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLecture(@PathVariable(value = "id") int id) {
        this.subjectService.deleteSubject(id);
    }
    
    @GetMapping("/subjects")
    @CrossOrigin
    public ResponseEntity<List<Subject>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.subjectService.getSubjects(params), HttpStatus.OK);
    }
}
