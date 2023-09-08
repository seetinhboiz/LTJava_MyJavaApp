/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.service.AccountService;
import com.ttn.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Nghianek
 */
@Controller
@ControllerAdvice
public class IndexController {
    @Autowired
    private LectureService lectureService;
       
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("lecture", this.lectureService.getLectures(null));
        
        return "index";
    }
}
