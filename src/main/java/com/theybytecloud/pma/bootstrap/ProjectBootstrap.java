package com.theybytecloud.pma.bootstrap;

import com.theybytecloud.pma.dao.EmployeeRepository;
import com.theybytecloud.pma.dao.ProjectRepository;
import com.theybytecloud.pma.entities.Employee;
import com.theybytecloud.pma.entities.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
@Slf4j
public class ProjectBootstrap implements CommandLineRunner {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
		//loadData();

	}

	private void loadData() {
		Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
		Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
		Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");

		Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
		Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
		Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");

		Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
		Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
		Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");


		Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
				+ "the final deployment of the software into production");
		Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
				+ "for the year and figureout who will be promoted");
		Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
				+ "been damaged due to hurricane in the region. This needs to be reconstructed");
		Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
				+ "security needs to be improved and proper security team needs to be hired for "
				+ "implementation");


		// need to set both sides of the relationship manually

		pro1.addEmployee(emp1);
		pro1.addEmployee(emp2);
		pro2.addEmployee(emp3);
		pro3.addEmployee(emp1);
		pro4.addEmployee(emp1);
		pro4.addEmployee(emp3);


		// need to set both sides of the relationship manually

		emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
		emp2.setProjects(Arrays.asList(pro1));
		emp3.setProjects(Arrays.asList(pro2, pro4));

		// save employees in database

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);
		employeeRepository.save(emp4);
		employeeRepository.save(emp5);
		employeeRepository.save(emp6);
		employeeRepository.save(emp7);
		employeeRepository.save(emp8);
		employeeRepository.save(emp9);


		// save projects in database

		projectRepository.save(pro1);
		projectRepository.save(pro2);
		projectRepository.save(pro3);
		projectRepository.save(pro4);
	}

	private void loadProjects() {
        log.info("Loading projects......");
        projectRepository.save(Project.builder()
                .name("Project1")
                .stage("NOTSTARTED")
                .description("Project1 Desc")
                .build());

        projectRepository.save(Project.builder()
                .name("Project2")
                .stage("INPROGRESS")
                .description("Project2 Desc")
                .build());

        projectRepository.save(Project.builder()
                .name("Project3")
                .stage("COMPLETED")
                .description("Project3 Desc")
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
