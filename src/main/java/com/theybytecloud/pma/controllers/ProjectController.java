package com.theybytecloud.pma.controllers;

import com.theybytecloud.pma.dao.EmployeeRepository;
import com.theybytecloud.pma.dao.ProjectRepository;
import com.theybytecloud.pma.entities.Employee;
import com.theybytecloud.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping
	public String diplayProjects(Model model) {
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {

		Project project = new Project();
		model.addAttribute("project", project);

		List<Employee> employees = employeeRepository.findAll();

		model.addAttribute("allEmployees", employees);

		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(@ModelAttribute Project project, Model model) {

		projectRepository.save(project);

		return "redirect:/projects";
	}
}
