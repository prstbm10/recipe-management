package com.lets.cook.demo.repository;

import com.lets.cook.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
}
