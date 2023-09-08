/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttn.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ClassRepository {
    List<com.ttn.pojo.Class> getClass(Map<String, String> param);
}
