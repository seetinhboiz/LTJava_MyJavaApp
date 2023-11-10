/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.ttn.pojo.Scoresheet;
import com.ttn.repository.ScoreSheetRepository;
import com.ttn.service.ScoreDetailService;
import com.ttn.service.ScoreSheetService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ScoreSheetServiceImpl implements ScoreSheetService{
    @Autowired
    private ScoreSheetRepository scoreSheet;

    @Override
    public List<Scoresheet> getScoreSheets(Map<String, String> param) {
        return this.scoreSheet.getScoreSheet(param);
    }

    @Override
    public List<Scoresheet> getScoreSheetByClassId(int id) {
        return this.scoreSheet.getScoreSheetByClassId(id);
    }
}
