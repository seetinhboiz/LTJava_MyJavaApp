/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ttn.pojo.Account;
import com.ttn.pojo.Lecture;
import com.ttn.repository.AccountRepository;
import com.ttn.repository.LectureRepository;
import com.ttn.service.LectureService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Lecture> getLectures(Map<String, String> param) {
        return this.lectureRepository.getLectures(param);
    }

    @Override
    public List<Integer> getLecureRole(Map<String, String> map) {
        return this.lectureRepository.getLectureRole(null);
    }

    @Override
    public boolean addOrUpdateLecture(Lecture lctr) {
        Account account = this.accountRepository.getAccountById(lctr.getIdAccount());
        account.setAvailable(1);
        if (!lctr.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(lctr.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                lctr.setAvata(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(LectureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.lectureRepository.addOrUpdateLecture(lctr);
        this.accountRepository.addOrUpdateAccount(account);
        return true;
    }

    @Override
    public List<Integer> getLectureByRole(Map<String, String> map
    ) {
        return this.lectureRepository.getLectureByRole(map);
    }

    @Override
    public Lecture getLectureById(int id) {
        return this.lectureRepository.getLectureById(id);
    }

    @Override
    public boolean deleteLecture(int id) {
        return this.lectureRepository.deleteLecture(id);
    }
}
