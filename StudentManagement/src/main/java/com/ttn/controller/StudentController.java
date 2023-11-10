/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Student;
import com.ttn.service.StudentService;
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
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("student", this.studentService.getStudents(params));

        return "student";
    }

    @GetMapping("/student/studentManagement")
    public String list2(Model model) {
        model.addAttribute("student", new Student());

        return "studentManagement";
    }
    
    @GetMapping("/student/studentManagement/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Student student = this.studentService.getStudentById(id);
        model.addAttribute("student", student);
        
        return "studentManagement";
    }

    @PostMapping("/student/studentManagement")
    public String add(@ModelAttribute(value = "student") @Valid Student student, BindingResult result) throws ParseException {
        if (!result.hasErrors()) {
            if (this.studentService.addOrUpdateStudent(student) == true) {
                return "redirect:/student";
            }
        }
        return "studentManagement";
    }
}
