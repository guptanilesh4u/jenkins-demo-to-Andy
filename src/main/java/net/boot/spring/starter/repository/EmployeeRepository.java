package net.boot.spring.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.boot.spring.starter.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
