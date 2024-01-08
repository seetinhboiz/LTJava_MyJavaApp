/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Lecture;
import com.ttn.service.LectureService;
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
@RequestMapping("/api/lectures")
public class ApiLecctureController {
    @Autowired
    private LectureService lectureService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLecture(@PathVariable(value = "id") int id) {
        this.lectureService.deleteLecture(id);
    }
    
    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<List<Lecture>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.lectureService.getLectures(params), HttpStatus.OK);
    }
}
