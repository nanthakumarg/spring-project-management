package com.theybytecloud.pma.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long projectId;
	
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
