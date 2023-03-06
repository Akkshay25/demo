package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	@Query("FROM User u where u.username = :username")
	User findByUsername(@Param("username") String username);
	
	@Query("FROM User u where u.email = :email")
	User findByEmailId(@Param("email") String email );
	
	@Query("FROM User u where u.username like :username")
	List<User> findUsersByUsername(@Param("username") String username);
	
	@Transactional
	@Modifying
	 @Query( "UPDATE User u set u.password = :password WHERE u.username= :username")
    void updatePwd(@Param("password")String password, @Param("username") String username);

}
