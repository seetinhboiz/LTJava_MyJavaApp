/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.repository.impl;

import com.ttn.pojo.Account;
import com.ttn.repository.AccountRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Transactional
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Account> getAccounts(Map<String, String> param) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Account");

        return query.getResultList();
    }

    @Override
    public Account getAccountByUsername(String username) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Account WHERE username = :un");
        query.setParameter("un", username);

        return (Account) query.getSingleResult();
    }

    @Override
    public boolean addOrUpdateAccount(Account account) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (account.getId() == null) {
                account.setPassword(passwordEncoder.encode(account.getPassword()));
                session.save(account);
            } else {
                account.setPassword(passwordEncoder.encode(account.getPassword()));
                session.update(account);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Account getAccountById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Account.class, id);
    }

    @Override
    public boolean deleteAccount(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Account account = this.getAccountById(id);
        
        try {
            session.delete(account);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Account> getAccountsAvailable() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Account WHERE available = 0");
        
        return query.getResultList();
    }

    @Override
    public boolean isExistsByUsername(String username) {
        Account account = this.getAccountByUsername(username);
        
        if (account.getId() == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean authUser(String username, String password) {
        Account account = this.getAccountByUsername(username);
        
        return this.passwordEncoder.matches(password, account.getPassword());
    }
}
