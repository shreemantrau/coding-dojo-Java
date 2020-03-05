package com.codingdojo.test.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.test.models.Message;

public interface messageRepository extends CrudRepository<Message,Long>{
	
}