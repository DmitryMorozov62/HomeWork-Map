package HomeWork.service;

import HomeWork.Employee;
import HomeWork.exception.EmployeeAlreadyAddedException;
import HomeWork.exception.EmployeeBadRequestException;
import HomeWork.exception.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int SIZE = 5;

    private final Map<String,Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>(SIZE);
    }
    public Map<String, Employee> getEmployees() {
        return Collections.unmodifiableMap(employees);
    }

    @PostConstruct
    public void init() {
        employees.put("Вася Петров",new Employee("Вася", "Петров", 35_000, 1));
        employees.put("Иван Иванов",new Employee("Иван", "Иванов", 40_000, 2));
        employees.put("Виктор Сидоров",new Employee("Виктор", "Сидоров", 66_000, 3));
        employees.put("Владимир Быстров",new Employee("Владимир", "Быстров", 90_000, 3));

    }
    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        testEmployee(firstName,lastName);

        employees.put(employee.getFullName(),employee);
            return employee;


    }
    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        testEmployee(firstName,lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        testEmployee(firstName,lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }
    @Override
    public Collection<Employee> list() {
        return Collections.unmodifiableCollection(employees.values());
    }
    public void testEmployee(String firstName, String lastName) {
        if (!isAlpha(firstName) || !isAlpha(lastName)) {
            throw new EmployeeBadRequestException();
        }
    }
}
