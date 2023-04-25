package HomeWork;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {

    private final String name;

    private final String surname;

    private final int salary;

    private final int department;


    public Employee(String name, String surname, int salary, int department) {
        //this.name = name;
        //this.surname = surname;
        this.name = StringUtils.capitalize(name);
        this.surname = StringUtils.capitalize(surname);


        this.salary = salary;
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        //return name + " " + surname;
        return name + " " + surname;
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }

}