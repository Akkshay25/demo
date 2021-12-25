package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> findAllEmployee() {
		logger.info("EmployeeService : findAllEmployee()");
		return repository.findAll();
	}

	public Employee saveEmployee(Employee newEmployee) {
		logger.info("EmployeeService : saveEmployee()");
		return repository.save(newEmployee);
	}

	public Employee findEmploueeById(Long id) {
		logger.info("EmployeeService : findEmploueeById()");
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	public Employee updateEmployee(Employee newEmployee, Long id) {
		logger.info("EmployeeService : updateEmployee()");
		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repository.save(newEmployee);
		});
	}

	public void deleteEmployee(Long id) {
		logger.info("EmployeeService : deleteEmployee()");
		repository.deleteById(id);

	}

}
