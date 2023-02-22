package com.ip.OOM.hr;

import java.util.List;
import java.util.Map;

public class Employee extends Person {
    private int id;
    private List<String> skills;
    private Map<String, Double> salaries;

    public Employee(String name, String email, String phone, int id) {
        super(name, email, phone);
        this.id = id;
    }

    public Employee(String name, String email, String phone, int id, List<String> skills, Map<String, Double> salaries) {
        super(name, email, phone);
        this.id = id;
        this.skills = skills;
        this.salaries = salaries;
    }

    public int getId() {
        return id;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String, Double> getSalaries() {
        return salaries;
    }


    public void setSalaries(Map<String, Double> salaries) {
        this.salaries = salaries;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + getId() +
                ", Name=" + getName() +
                ", Email=" + getEmail() +
                ", Phone=" + getPhone() +
                ", skills=" + getSkills() +
                ", salaryByYear=" + getSalaries() +
                "} ";
    }
}