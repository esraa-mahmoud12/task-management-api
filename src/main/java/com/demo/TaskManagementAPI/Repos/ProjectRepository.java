package com.demo.TaskManagementAPI.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.TaskManagementAPI.Entities.Project;
import com.demo.TaskManagementAPI.Entities.User;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	// Using User directly vs Long userId in method params — both work but using the entity object is cleaner with JPA
	List<Project> findByOwner(User owner);

}
