package com.theybytecloud.pma.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long projectId;
	
	private String name;
	
	private String stage; //NOTSTARTED, COMPLETED, INPROGRESS, STARTED
	
	private String description;

	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	} 
	
	
	
	
}
