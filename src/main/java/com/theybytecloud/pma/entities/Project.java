package com.theybytecloud.pma.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
	@SequenceGenerator(name="project_seq", sequenceName = "project_seq", allocationSize = 1)
	private Long projectId;
	
	private String name;
	
	private String stage; //NOTSTARTED, COMPLETED, INPROGRESS, STARTED
	
	private String description;

	//@OneToMany(mappedBy = "project")
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",
				joinColumns = @JoinColumn(name = "project_id"),
				inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private List<Employee> employees;

	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}


	public void addEmployee(Employee employee) {
		if(employees == null)
			employees = new ArrayList<>(10);

		employees.add(employee);

	}
}
