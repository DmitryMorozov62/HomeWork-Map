package HomeWork;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeService {

    private static final int SIZE = 5;

    private final List<Employee> employees = new ArrayList<>(SIZE);


    @PostConstruct
    public void init() {
        employees.add(new Employee("Вася", "Петров"));
        employees.add(new Employee("Иван", "Иванов"));
        employees.add(new Employee("Дмитрий", "Морозов"));

    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            for (Employee emp : employees) {
                if (emp.equals(employee)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee delEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }

    public boolean nullPointerException(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            return true;
        }return false;
    }
}
