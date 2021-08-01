package com.example.namedquery.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.namedquery.model.Publisher;
@Repository
public interface PublishDAO extends CrudRepository<Publisher, Integer>{

}
