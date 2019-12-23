package com.theybytecloud.pma.controllers;

import com.theybytecloud.pma.dao.EmployeeRepository;
import com.theybytecloud.pma.dao.ProjectRepository;
import com.theybytecloud.pma.entities.Employee;
import com.theybytecloud.pma.entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {

        List<Project> projects = projectRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "main/home";
    }
}
