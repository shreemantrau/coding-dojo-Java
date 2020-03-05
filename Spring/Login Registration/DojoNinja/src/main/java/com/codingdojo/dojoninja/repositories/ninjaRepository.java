package com.codingdojo.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojoninja.models.Ninja;

public interface ninjaRepository extends CrudRepository<Ninja,Long> {
	List<Ninja> findAll();
}
