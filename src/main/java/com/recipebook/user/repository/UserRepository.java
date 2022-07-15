package com.recipebook.user.repository;

import com.recipebook.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface UserRepository extends JpaRepository<Users, UUID> {
}
