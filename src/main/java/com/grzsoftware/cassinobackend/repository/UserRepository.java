package com.grzsoftware.cassinobackend.repository;

import com.grzsoftware.cassinobackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
