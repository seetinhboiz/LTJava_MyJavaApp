/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.repository.impl;

import com.ttn.pojo.Class;
import com.ttn.repository.ClassRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class ClassRepositoryImpl implements ClassRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Class> getClass(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Class");
        if (!param.isEmpty()) {
            query = session.createQuery("FROM Class WHERE idSubject.name LIKE :subjectName");
            query.setParameter("subjectName", "%" + param.get("kw") + "%");
        }
        
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateClass(Class _class) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (_class.getId() == null) {
                session.save(_class);
            } else {
                session.update(_class);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Class getClassById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Class.class, id);
    }

    @Override
    public boolean deleteClass(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Class _class = this.getClassById(id);

        try {
            session.delete(_class);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
