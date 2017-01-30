package net.boot.spring.starter.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import net.boot.spring.starter.domain.Employee;
import net.boot.spring.starter.repository.EmployeeRepository;

@Service
@Validated
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository repository;
    
    @Inject
    public EmployeeServiceImpl (final EmployeeRepository repository){
        this.repository = repository;
    }
    
    @Override
    @Transactional
    public Employee save(Employee employee) {
        LOGGER.debug("Creating {}", employee);
        return repository.save(employee);
    }

    @Override
    @Transactional (readOnly = true)
    public List<Employee> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

}
