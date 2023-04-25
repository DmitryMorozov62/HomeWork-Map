package HomeWork.service;

import HomeWork.Employee;

import java.util.Collection;


public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee findEmployee(String firstName, String lastName, int salary, int department);

    Employee removeEmployee(String firstName, String lastName, int salary, int department);

    Collection<Employee> list();

}
