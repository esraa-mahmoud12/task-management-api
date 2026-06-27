package com.demo.TaskManagementAPI.Entities;

import java.util.List;

import com.demo.TaskManagementAPI.Enums.TaskPriority;
import com.demo.TaskManagementAPI.Enums.TaskStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Project")
@Builder
@EqualsAndHashCode(callSuper=true)
public class Project {


	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="owner")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id", nullable=false)
	private User owner;
	
	@OneToMany(mappedBy="project", cascade = CascadeType.ALL)
	private List<Task> tasks;
	

}
