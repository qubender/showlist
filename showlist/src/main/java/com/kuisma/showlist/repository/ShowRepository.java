package com.kuisma.showlist.repository;

import org.springframework.data.repository.CrudRepository;

import com.kuisma.showlist.domain.Show;

public interface  ShowRepository extends CrudRepository<Show, Long> {

}
