package com.demo.TaskManagementAPI.Entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;

@Data// create getter, setter, equals, hashcode, toString methods
@MappedSuperclass // shere fiels with cildren but dont create table for my own
@EntityListeners(AuditingEntityListener.class) //listen to what happens to this entity and automatically fil
@Entity
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@CreatedDate
	@Column(name="createdAt", nullable=false)
	public LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name="updatedAt", nullable=false)
	public LocalDateTime updatedAt;
	
}
