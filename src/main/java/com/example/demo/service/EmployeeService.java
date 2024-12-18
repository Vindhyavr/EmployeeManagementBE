package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRep;
    public Employee registerEmployee(Employee employee)
 {
     Employee employee1=employeeRep.save(employee);
	 return employee1;
 }
    public List<Employee> getAllEmployee()
    {
    	List<Employee> allEmployees=employeeRep.findAll();
    	return allEmployees;
    }
    public Employee getEmployeeId(long id)
    {
    	Employee employee=employeeRep.getById(id);
    	return employee;
    }
    public String deleteEmployeeById(long id)
    {
    	try
    	{
    		employeeRep.deleteById(id);
    		return "Employee data deleted";
    	}
    	catch(Exception e)
    	{
    		return "Employee data not deleted";
    	}
    }
    public Employee updateEmployeeById(Employee employee)
    {
    	Employee employee1=employeeRep.getById(employee.getId());
    	employee1.setFirstName(employee.getFirstName());
    	employee1.setEmailID(employee.getEmailID());
    	employee1.setLastName(employee.getLastName());
    	Employee employee2=employeeRep.save(employee);
    	return employee2;
    }
}
