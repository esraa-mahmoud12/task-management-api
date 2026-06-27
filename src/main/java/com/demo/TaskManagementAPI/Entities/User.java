package com.demo.TaskManagementAPI.Entities;

import java.util.List;

import com.demo.TaskManagementAPI.Enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data	
@Entity
@Table(name="User")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // When comparing two objects, also include the fields from the parent class (id, createdAt, updatedAt)
public class User extends BaseEntity{

	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="password") // nullable because OAuth2 users won't have a password
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable=false)
	private Role  role;
	
	// OAuth2 provider (google, github) — null if registered normally
    @Column
    private String provider;
    
    @OneToMany(mappedBy="assigne", cascade= CascadeType.ALL) 
    //Don't create a new join column here — the relationship is already managed by the assignee field inside Task
    //Whatever happens to the User, apply the same operation to their Tasks
    private List<Task> assignedTasks;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Project> ownedProjects;
}
