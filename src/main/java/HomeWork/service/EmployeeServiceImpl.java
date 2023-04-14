package HomeWork.service;

import HomeWork.Employee;
import HomeWork.exception.EmployeeAlreadyAddedException;
import HomeWork.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int SIZE = 5;

    private final Map<String,Employee> employees;

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = new HashMap<>(SIZE);
    }

    @PostConstruct
    public void init() {
        employees.put("Вася Петров",new Employee("Вася", "Петров"));
        employees.put("Иван Иванов",new Employee("Иван", "Иванов"));
        employees.put("Виктор Сидоров",new Employee("Виктор", "Сидоров"));

    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getNameKey())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getNameKey(),employee);
            return employee;


    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getNameKey())) {
            return employees.get(employee.getNameKey());
        }
        throw new EmployeeNotFoundException();
    }
@Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getNameKey())) {
            return employees.remove(employee.getNameKey());
        }
        throw new EmployeeNotFoundException();
    }
@Override
    public Collection<Employee> list() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
