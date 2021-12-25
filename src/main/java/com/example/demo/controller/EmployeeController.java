package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> all() {
		return new ResponseEntity<>(employeeService.findAllEmployee() , HttpStatus.OK) ;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {
		return new ResponseEntity<>(employeeService.saveEmployee(newEmployee), HttpStatus.CREATED);
	}

	// Single item

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> one(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.findEmploueeById(id), HttpStatus.OK);

	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return new ResponseEntity<>(employeeService.updateEmployee(newEmployee, id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
	}
}