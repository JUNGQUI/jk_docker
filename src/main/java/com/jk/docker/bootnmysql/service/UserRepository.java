package com.jk.docker.bootnmysql.service;

import com.jk.docker.bootnmysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
