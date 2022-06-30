package com.navneet.learning.bms.bmsapi.service;

import com.navneet.learning.bms.bmsapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
