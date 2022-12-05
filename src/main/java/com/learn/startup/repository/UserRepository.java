package com.learn.startup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.startup.model.SpringUser;

@Repository
public interface UserRepository extends CrudRepository<SpringUser, Long> {

	SpringUser findByUsername(String username);

}
