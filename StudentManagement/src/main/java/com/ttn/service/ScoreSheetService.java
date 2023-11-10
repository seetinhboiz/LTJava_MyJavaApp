/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttn.service;

import com.ttn.pojo.Scoresheet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ScoreSheetService {
    List<Scoresheet> getScoreSheets(Map<String, String> param);
    List<Scoresheet> getScoreSheetByClassId(int id);
}
