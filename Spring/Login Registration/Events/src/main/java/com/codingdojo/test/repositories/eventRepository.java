package com.codingdojo.test.repositories;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.test.models.Event;

public interface eventRepository extends CrudRepository<Event,Long> {

	

}
