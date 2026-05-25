package com.ashu.springSecDemo.service;

import com.ashu.springSecDemo.dao.UserRepo;
import com.ashu.springSecDemo.model.UserPrincipal;
import com.ashu.springSecDemo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if(user==null)
            throw new UsernameNotFoundException("ERROR 404: USER NOT FOUND");
        return new UserPrincipal(user);

    }

}
