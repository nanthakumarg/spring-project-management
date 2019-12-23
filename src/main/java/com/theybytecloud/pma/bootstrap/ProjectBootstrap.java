package com.theybytecloud.pma.bootstrap;

import com.theybytecloud.pma.dao.EmployeeRepository;
import com.theybytecloud.pma.dao.ProjectRepository;
import com.theybytecloud.pma.entities.Employee;
import com.theybytecloud.pma.entities.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class ProjectBootstrap implements CommandLineRunner {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        loadProjects();

        loadEmployees();

    }

    private void loadProjects() {
        log.info("Loading projects......");
        projectRepository.save(Project.builder()
                .name("Project1")
                .stage("NOTSTARTED")
                .build());

        projectRepository.save(Project.builder()
                .name("Project2")
                .stage("INPROGRESS")
                .build());

        projectRepository.save(Project.builder()
                .name("Project3")
                .stage("COMPLETED")
                .build());
    }

    private void loadEmployees() {
        log.info("Loading employees.....");
        employeeRepository.save(Employee.builder()
                .firstName("Nantha")
                .lastName("Kumar")
                .email("nantha@test.com")
                .build());

        employeeRepository.save(Employee.builder()
                .firstName("John")
                .lastName("Bob")
                .email("john@test.com")
                .build());

        employeeRepository.save(Employee.builder()
                .firstName("Bala")
                .lastName("Kumar")
                .email("bala@test.com")
                .build());
    }
}
