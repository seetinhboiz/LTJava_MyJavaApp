/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Lecture;
import com.ttn.service.AccountService;
import com.ttn.service.LectureService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class LectureController {
    @Autowired
    private LectureService lectureService;
    
    @Autowired
    private AccountService accountService;

    @GetMapping("/lectures")
    public String list(Model model) {
        model.addAttribute("lecture", new Lecture());
        model.addAttribute("account", this.accountService.getAccountsAvailable());

        return "lectures";
    }

    @GetMapping("/lectures/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        Lecture l = this.lectureService.getLectureById(id);
        model.addAttribute("lecture", l);
        model.addAttribute("account", this.accountService.getAccountsAvailable());
        model.addAttribute("currentAccount", this.accountService.getAccountById(l.getIdAccount()));

        return "lectures";
    }

    @PostMapping("/lectures")
    public String add(@ModelAttribute(value = "lecture") @Valid Lecture lecture, BindingResult result) throws ParseException {
        if (!result.hasErrors()) {
            if (this.lectureService.addOrUpdateLecture(lecture) == true) {
                return "redirect:/";
            }
        }
        return "lectures";
    }
}
