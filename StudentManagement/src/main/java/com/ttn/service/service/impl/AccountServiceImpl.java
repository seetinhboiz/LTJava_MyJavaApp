/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.service.service.impl;

import com.ttn.pojo.Account;
import com.ttn.repository.AccountRepository;
import com.ttn.service.AccountService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepo;

    @Override
    public List<Account> getAccounts(Map<String, String> map) {
        return this.accountRepo.getAccounts(map);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountRepo.getAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Username không hợp lệ");
        }
        

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(Integer.toString(account.getRole())));
        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), authorities);
    }

    @Override
    public boolean addOrUpdateAccount(Account account) {
        return this.accountRepo.addOrUpdateAccount(account);
    }
}
