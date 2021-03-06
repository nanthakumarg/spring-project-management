package com.theybytecloud.pma.controllers;

import com.theybytecloud.pma.dao.EmployeeRepository;
import com.theybytecloud.pma.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
     public String displayEmployeeFrom(Model model) {

         Employee employee = Employee.builder().build();
         model.addAttribute("employee", employee);

         return "employees/new-employee";

     }

     @PostMapping("/save")
     public String createEmployee(Employee employee, Model model) {

        employeeRepository.save(employee);

        return  "redirect:/employees";
     }



}
