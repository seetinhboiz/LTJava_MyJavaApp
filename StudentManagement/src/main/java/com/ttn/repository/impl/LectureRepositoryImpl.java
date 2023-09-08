/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.repository.impl;

import com.ttn.pojo.Lecture;
import com.ttn.repository.LectureRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class LectureRepositoryImpl implements LectureRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Lecture> getLectures(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Lecture");

        return query.getResultList();
    }

    public List<Integer> getLectureRole(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("select Lecture.role from Lecture group by role");

        return query.getResultList();
    }
    
    public List<Integer> getLectureByRole(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("select Lecture.role from Lecture where role = 0");

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateLecture(Lecture lctr) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (lctr.getId() == null) {
                session.save(lctr);
            } else {
                session.update(lctr);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Lecture getLectureById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Lecture.class, id);
    }

    @Override
    public boolean deleteLecture(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Lecture lecture = this.getLectureById(id);
        
        try {
            session.delete(lecture);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
