package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ApplicationForm;
import com.example.model.User;
@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationForm,Integer> {
	Optional<ApplicationForm> findByUser(User user);
}
