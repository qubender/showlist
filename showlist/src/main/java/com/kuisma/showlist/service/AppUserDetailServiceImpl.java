package com.kuisma.showlist.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kuisma.showlist.domain.AppUser;
import com.kuisma.showlist.repository.AppUserRepository;

@Service 
public class AppUserDetailServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public AppUserDetailServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = appUserRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,currentUser
            .getPasswordHash(),AuthorityUtils.createAuthorityList(currentUser.getRole())
        );
        return user;
    }
    
}
