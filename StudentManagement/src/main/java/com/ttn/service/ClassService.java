/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttn.service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ClassService {
    List<com.ttn.pojo.Class> getClass(Map<String, String> param);
}
