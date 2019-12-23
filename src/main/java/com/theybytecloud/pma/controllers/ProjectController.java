package com.theybytecloud.pma.controllers;

import com.theybytecloud.pma.dao.ProjectRepository;
import com.theybytecloud.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;

	@GetMapping("/new")
	public String displayProjectForm(Model model) {

		Project project = new Project();
		model.addAttribute("project", project);

		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(@ModelAttribute Project project, Model model) {

		projectRepository.save(project);

		return "redirect:/projects/new";
	}
}
