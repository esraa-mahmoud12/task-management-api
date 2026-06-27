package com.demo.TaskManagementAPI.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.TaskManagementAPI.Entities.Project;
import com.demo.TaskManagementAPI.Entities.Task;
import com.demo.TaskManagementAPI.Entities.User;
import com.demo.TaskManagementAPI.Enums.TaskStatus;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByAssignee(User owner);
	
	List<Task> findByProject(Project project);
	
	List<Task> findByStatus(TaskStatus  taskStatus);
	
	List<Task> findByProjectAndStatus(Project project, TaskStatus status);
	
	
}
