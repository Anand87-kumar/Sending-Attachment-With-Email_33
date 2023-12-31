package com.anand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anand.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}

