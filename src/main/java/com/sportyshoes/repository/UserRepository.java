package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entries.User;

/**
public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByName(String name);

}**/


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByName(String name);
	
}