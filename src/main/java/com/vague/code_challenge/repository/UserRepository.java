package com.vague.code_challenge.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vague.code_challenge.model.entity.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	List<User> findByName(@Param("name") String name);
	
	List<User> findByRole(@Param("role") String role);
	
}
