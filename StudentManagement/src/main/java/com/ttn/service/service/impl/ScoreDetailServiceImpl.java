/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.ttn.pojo.Scoredetail;
import com.ttn.service.ClassService;
import com.ttn.service.ScoreDetailService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ScoreDetailServiceImpl implements ScoreDetailService{
    @Autowired
    private ScoreDetailService scoreDetail;

    @Override
    public List<Scoredetail> getScoreDetails(Map<String, String> param) {
        return this.scoreDetail.getScoreDetails(param);
    }
}
