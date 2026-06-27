package com.demo.TaskManagementAPI.Entities;

import java.time.LocalDateTime;

import com.demo.TaskManagementAPI.Enums.TaskPriority;
import com.demo.TaskManagementAPI.Enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class Task {

	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="description", columnDefinition ="Text")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status",nullable=false)
	public TaskStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(name="priority", nullable=false)
	public TaskPriority priority;
	
	@Column(name="dueDate")
	public LocalDateTime dueDate;
	
	@Column(name="assigne")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignee_id")
	public User assigne;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)//JPA needs to create a foreign key column in the tasks table to link to projects table.
    private Project project;

}

