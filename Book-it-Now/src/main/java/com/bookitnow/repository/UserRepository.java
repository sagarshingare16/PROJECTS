package com.bookitnow.repository;

import com.bookitnow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserEmailId(String userEmailId);;
}
