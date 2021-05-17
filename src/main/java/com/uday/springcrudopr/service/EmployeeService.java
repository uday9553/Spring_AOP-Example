package com.uday.springcrudopr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uday.springcrudopr.model.Employee;
import com.uday.springcrudopr.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
		
	}
	
	public ResponseEntity<List<Employee>> fetchAll(){
		
		List<Employee> eEmployees= employeeRepository.findAll();
		Optional<List<Employee>> employees=Optional.ofNullable(eEmployees);				
		return ResponseEntity.ok(eEmployees);
		
	}
	
	public Employee postEmployee(Employee employee) {
		System.out.println("hit putEmployee()");
		return employeeRepository.save(employee);
	}

	public Employee getEmpName(Long id) {
		 System.out.println("hit getEmpName()");
		Optional<Employee> employee= employeeRepository.findById(id);
		if(employee.isEmpty()) {
			return null;
		}else {
			Employee emp=employee.get();
			return emp;
		}
				
		
	}
	
	public Employee putEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
    public void  remove(Employee employee) {
        employeeRepository.delete(employee);;
    }
    
   

}
