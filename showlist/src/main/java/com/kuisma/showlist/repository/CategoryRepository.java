package com.kuisma.showlist.repository;

import org.springframework.data.repository.CrudRepository;

import com.kuisma.showlist.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
