/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.repository.impl;

import com.ttn.pojo.Scoredetail;
import com.ttn.repository.ScoreDetailRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ScoreDetailRepositoryImpl implements ScoreDetailRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Scoredetail> getScoreDetails(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM ScoreDetail");
        
        return query.getResultList();
    }
}
