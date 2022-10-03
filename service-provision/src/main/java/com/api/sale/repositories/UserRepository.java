package com.api.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sale.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
