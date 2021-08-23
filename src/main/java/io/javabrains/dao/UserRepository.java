package io.javabrains.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.model.User;

public interface UserRepository extends JpaRepository< User, Long > {

	Optional< User > findByUserName( String userName );
}
