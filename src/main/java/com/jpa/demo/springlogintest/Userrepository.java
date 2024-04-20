package com.jpa.demo.springlogintest;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<Userinfo,Integer> 
{

	Optional<Userinfo> findByUsername(String username);

	

	
}
