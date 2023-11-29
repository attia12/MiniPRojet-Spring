package com.codewithattia.MiniProject.repository;

import com.codewithattia.MiniProject.model.Role;
import com.codewithattia.MiniProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Integer> {
    UserDetails findByEmail(String username);
    User findByRole(Role role);
}
