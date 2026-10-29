package com.kuisma.showlist.repository;

import org.springframework.data.repository.CrudRepository;

import com.kuisma.showlist.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long>{
    AppUser findByUsername(String username);
}
