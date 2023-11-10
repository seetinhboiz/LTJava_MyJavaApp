/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Lecture;
import com.ttn.pojo.Subject;
import com.ttn.service.ClassService;
import com.ttn.service.LectureService;
import com.ttn.service.ScoreSheetService;
import com.ttn.service.SubjectService;
import java.text.ParseException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class ClassController {
    @Autowired
    private ClassService classService;
    
    @Autowired
    private LectureService lectureService;

    @Autowired
    private SubjectService subjectService; 
    
    @Autowired
    private ScoreSheetService scoreSheetService; 
    
    @GetMapping("/class")
    public String list(Model model, @RequestParam Map<String, String> param) {
        model.addAttribute("_class", this.classService.getClass(param));
                
        return "class";
    }
    
    @GetMapping("/class/classManagement")
    public String list2(Model model) {
        model.addAttribute("_class", new com.ttn.pojo.Class());
        model.addAttribute("lectures", this.lectureService.getLectures(null));
        model.addAttribute("subjects", this.subjectService.getSubjects(null));
        
        return "classManagement";
    }
    
    @GetMapping("/class/classManagement/{id}") 
    public String update(Model model, @PathVariable(value = "id") int id) {
        com.ttn.pojo.Class _class = this.classService.getClassById(id);
        model.addAttribute("_class", _class);
        model.addAttribute("lectures", this.lectureService.getLectures(null));
        model.addAttribute("subjects", this.subjectService.getSubjects(null));
        
        return "classManagement";
    }
    
    @PostMapping("/class/classManagement")
    public String add(@ModelAttribute(value = "_class") @Valid com.ttn.pojo.Class _class, BindingResult result) throws ParseException {
        if (!result.hasErrors()) {
            if (this.classService.addOrUpdateClass(_class));
            return "redirect:/class";
        }
        return "classManagement";
    }
    
    @GetMapping("/class/classDetail/{id}")
    public String list3(Model model, @PathVariable(value = "id") int id) {
        com.ttn.pojo.Class _class = this.classService.getClassById(id);
        model.addAttribute("_class", _class);
        model.addAttribute("scoreSheets", this.scoreSheetService.getScoreSheetByClassId(_class.getId()));
        
        return "classDetail";
    }
}