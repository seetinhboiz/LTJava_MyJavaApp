/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ttn.repository;

import com.ttn.pojo.Lecture;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface LectureRepository {
    List<Lecture> getLectures(Map<String, String> param);
    
    List<Integer> getLectureRole(Map<String, String> param);
    
    List<Integer> getLectureByRole(Map<String, String> param);
    
    boolean addOrUpdateLecture(Lecture lecture);
    
    Lecture getLectureById(int id);
    
    boolean deleteLecture(int id);
}
