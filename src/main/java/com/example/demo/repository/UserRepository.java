package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //đánh dấu là 1 repository
public interface UserRepository extends JpaRepository<User, String> {
    //kiểm tra sự tồn tại của username
    boolean existsByUsername(String username);
}
