package com.ip.OOM.hr;

import java.util.*;

public class Department {
    private static int employeeCount = 0;
    private String name;
    private Map<Integer, Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new HashMap<>();
    }

    public String getName() {
        return name;
    }


    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {

        if (employee != null && employeeCount < 100) {
            employees.put(employeeCount, employee);
            employeeCount++;
            System.out.println(employeeCount);

        } else {
            while (true) {
                employees.put(employeeCount, employee);
                employeeCount++;
            }

        }

    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

}