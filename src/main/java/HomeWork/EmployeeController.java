package HomeWork;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam (required = false) String firstName, @RequestParam (required = false) String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam (required = false) String firstName, @RequestParam (required = false) String lastName) {
        return employeeService.delEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam (required = false) String firstName, @RequestParam (required = false) String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public List<Employee> list() {
        return employeeService.list();
    }

}
