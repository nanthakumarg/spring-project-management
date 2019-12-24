package com.theybytecloud.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theybytecloud.pma.dao.EmployeeRepository;
import com.theybytecloud.pma.dao.ProjectRepository;
import com.theybytecloud.pma.dto.ChartData;
import com.theybytecloud.pma.dto.EmployeeProject;
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
    public String displayHome(Model model) throws JsonProcessingException {

        List<Project> projects = projectRepository.findAll();
        //List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("projects", projects);
        //model.addAttribute("employees", employees);

        List<EmployeeProject> employeeProjects = employeeRepository.employeeProjects();
        model.addAttribute("employeeProjects", employeeProjects);

        List<ChartData> chartDataList = projectRepository.getProjectStatus();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(chartDataList);
        model.addAttribute("projectStatusCount", jsonString);

        return "main/home";
    }
}
