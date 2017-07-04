package com.josephee.cs462.user.repository;

import com.josephee.cs462.common.model.user.Role;
import com.josephee.cs462.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findUsersByRole(Role role, Pageable pageable);
}
