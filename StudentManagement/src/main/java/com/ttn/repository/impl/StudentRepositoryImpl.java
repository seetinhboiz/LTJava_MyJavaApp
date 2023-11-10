/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.repository.impl;

import com.ttn.pojo.Student;
import com.ttn.repository.StudentRepository;
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
public class StudentRepositoryImpl implements StudentRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Student> getStudents(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Student> q = b.createQuery(Student.class);
        Root root = q.from(Student.class);
        q.select(root);

        if (param != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = param.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }

            Predicate[] predicateArray = new Predicate[predicates.size()];

            predicates.toArray(predicateArray);

            q.where(predicateArray);
        }

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateStudent(Student student) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (student.getId() == null) {
                session.save(student);
            } else {
                session.update(student);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public boolean deleteStudent(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Student student = this.getStudentById(id);
        
        try {
            session.delete(student);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
