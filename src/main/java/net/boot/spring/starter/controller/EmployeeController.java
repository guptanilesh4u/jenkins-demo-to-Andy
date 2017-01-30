package net.boot.spring.starter.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.boot.spring.starter.domain.Employee;
import net.boot.spring.starter.service.EmployeeService;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);  
    private final EmployeeService employeeService;

    @Inject
    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void logMessages() {
        LOGGER.debug("This is debug message");
        LOGGER.info("This is info message");
        LOGGER.warn("This is warn message");
        LOGGER.error("This is error message");
    }
    
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getList() {
        List<Employee> employees = employeeService.getList();
        return employees;
    }
    
    @RequestMapping (value="/addEmployee", method=RequestMethod.POST)
    public void addEmployee(@RequestParam(value="employeeName", required=false) String employeeName,
                                @RequestParam(value="employeeId", required=false) String employeeID,
                                @RequestParam(value="employeeCity", required=false) String employeeCity){
        Employee employee = new Employee(employeeID, employeeName, employeeCity);
        employeeService.save(employee);
    }
    
}
