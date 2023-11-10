/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Subject;
import com.ttn.service.SubjectService;
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
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subject")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("subject", this.subjectService.getSubjects(params));

        return "subject";
    }

    @GetMapping("/subject/subjectManagement")
    public String list2(Model model) {
        model.addAttribute("subject", new Subject());

        return "subjectManagement";
    }
    
    @GetMapping("/subject/subjectManagement/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Subject subject = this.subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);

        return "subjectManagement";
    }

    @PostMapping("/subject/subjectManagement")
    public String add(@ModelAttribute(value = "subject") @Valid Subject subject, BindingResult result) {
        if (!result.hasErrors()) {
            if (this.subjectService.addOrUpdateSubject(subject) == true) {
                return "redirect:/subject";
            }   
        }

        return "subjectManagement";
    }
}
