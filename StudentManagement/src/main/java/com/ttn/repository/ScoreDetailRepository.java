/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttn.repository;

import com.ttn.pojo.Scoredetail;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ScoreDetailRepository {
    List<Scoredetail> getScoreDetails(Map<String, String> param);
}
