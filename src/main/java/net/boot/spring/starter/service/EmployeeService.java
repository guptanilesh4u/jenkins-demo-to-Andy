package net.boot.spring.starter.service;

import java.util.List;

import net.boot.spring.starter.domain.Employee;

public interface EmployeeService {

    Employee save(Employee employee);
    
    List<Employee> getList();
}
