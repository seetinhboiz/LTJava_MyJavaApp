/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.controller;

import com.ttn.pojo.Account;
import com.ttn.pojo.Lecture;
import com.ttn.service.AccountService;
import java.text.ParseException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public String list(Model model) {
        model.addAttribute("account", this.accountService.getAccounts(null));

        return "account";
    }

    @GetMapping("/account/accountManagement")
    public String list2(Model model) {
        model.addAttribute("account", new Account());

        return "accountManagement";
    }

    @PostMapping("/account/accountManagement")
    public String add(@ModelAttribute(value = "account") @Valid Account account, BindingResult result) throws ParseException {
        if (this.accountService.addOrUpdateAccount(account) == true) {
            return "redirect:/";
        }
        return "accountManagement";
    }
}
