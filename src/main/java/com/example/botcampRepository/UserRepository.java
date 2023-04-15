package com.example.botcampRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botcampEntites.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	 User findByEmail(String email);

}
