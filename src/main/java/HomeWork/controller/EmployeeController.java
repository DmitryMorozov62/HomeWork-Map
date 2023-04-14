package HomeWork.controller;

import HomeWork.Employee;
import HomeWork.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> list() {
        return employeeService.list();
    }

}
