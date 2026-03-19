package com.capgemini.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Employee;
import com.capgemini.model.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void saveAllEmployees(List<Employee> employees) {
		employeeRepository.saveAll(employees);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public void updateEmployee(Integer id, Employee employee) {
		Employee existing = employeeRepository.findById(id).orElse(null);

		if (existing != null) {
			existing.setName(employee.getName());
			existing.setMailId(employee.getMailId());
			existing.setContactNumber(employee.getContactNumber());
			employeeRepository.save(existing);
		}
	}

	public void patchEmployee(Integer id, Employee employee) {
		Employee existing = employeeRepository.findById(id).orElse(null);

		if (existing != null) {
			if (employee.getName() != null) {
				existing.setName(employee.getName());
			}
			if (employee.getMailId() != null) {
				existing.setMailId(employee.getMailId());
			}
			if (employee.getContactNumber() != null) {
				existing.setContactNumber(employee.getContactNumber());
			}
			employeeRepository.save(existing);
		}
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
}