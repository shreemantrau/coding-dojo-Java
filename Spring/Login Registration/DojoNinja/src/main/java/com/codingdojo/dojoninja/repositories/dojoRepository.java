package com.codingdojo.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;

public interface dojoRepository extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();

	
}
