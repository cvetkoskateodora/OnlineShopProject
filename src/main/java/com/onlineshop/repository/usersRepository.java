package com.onlineshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.model.users;

public interface usersRepository extends JpaRepository<users, Integer> {

	Optional<users> findByEmailAndPassword(String email, String password);
}
