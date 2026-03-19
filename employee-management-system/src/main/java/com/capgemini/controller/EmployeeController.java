package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.model.entity.Employee;
import com.capgemini.model.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return "Employee saved successfully";
	}

	@PostMapping("/saveAll")
	public String saveAllEmployees(@RequestBody List<Employee> employees) {
		employeeService.saveAllEmployees(employees);
		return "All employees saved successfully";
	}

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "Employee updated successfully";
	}

	@PatchMapping("/update/{id}")
	public String patchEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		employeeService.patchEmployee(id, employee);
		return "Employee partially updated";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully";
	}
}