package com.ip.OOM.hr;


import java.util.*;

public class EmployeeAssignment {

    private static Runtime runtime;
    private static Random rand;

    private Department department;


    public EmployeeAssignment() {
    	department = new Department("IT");
	}
    
    public void setupEmployee() {
        runtime = Runtime.getRuntime();
        rand = new Random();

//        tooManySkills();
        tooManyEmployees();

    }

    private void tooManySkills() {

        try {

            Random rand = new Random();


            int index = 1;

            department = new Department("IT");
            List<Employee> employees = new ArrayList<>();


            // Create a large number of Employee objects with large amounts of data
            for (int i = 0; i < 1000; i++) {
                List<String> skills = new ArrayList<>();
                Map<String, Double> salaries = new HashMap<>();

                salaries.put("2023", rand.nextDouble() * 1000.0);

                int innerArrayLength = rand.nextInt(100000) + 1;

                for (int j = 0; j < innerArrayLength; j++) {
                    skills.add((i + 1) + " - Skill " + j + ": " + rand.nextInt(100000));
                }


                Employee employee = new Employee("John Doe", "johndoe@example.com", String.valueOf(rand.nextInt(1000000000)), i + 1);
                employee.setSkills(skills);

                employees.add(employee);

//                displayMemoryStats();
            }


            // Add the employees to departments
            for (int i = 0; i < employees.size(); i++) {

                department.addEmployee(employees.get(i));
                displayMemoryStats();

            }


            // Display the department
            // System.out.println("Department:" + department);


        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory error occurred! " + e.getMessage());

        }
    }

    private void tooManyEmployees() {


        int index = 1;

        //Department department = new Department("IT");
        List<Employee> employees = new ArrayList<>();


        int outerArrayLength = rand.nextInt(10000) + 1;
        // Create a large number of Employee objects with large amounts of data
        for (int i = 0; i < outerArrayLength; i++) {
            List<String> skills = new ArrayList<>();
            Map<String, Double> salaries = new HashMap<>();

            salaries.put("2023", rand.nextDouble() * 1000.0);

            int innerArrayLength = rand.nextInt(10) + 1;

            for (int j = 0; j < innerArrayLength; j++) {
                skills.add((i + 1) + " - Skill " + j + ": " + rand.nextInt(100000));
            }


            Employee employee = new Employee("John Doe", "johndoe@example.com", String.valueOf(rand.nextInt(1000000000)), i + 1);
            employee.setSkills(skills);

            employees.add(employee);

        }


        System.out.println("Total employees: " + employees.size());
        // Add the employees to departments
        for (int i = 0; i < employees.size(); i++) {

            //System.out.println("Employee " + i + 1 + " added to department" + department.getName());
            //displayMemoryStats();
            department.addEmployee(employees.get(i));


        }


        // Display the department
        //System.out.println("Department:" + department);


    }

    private void displayMemoryStats() {


        // Calculate memory statistics
        long maxMemory = runtime.maxMemory() / (1024 * 1024);
        long freeMemory = runtime.freeMemory() / (1024 * 1024);
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;

        // Display memory statistics
//        System.out.println("Max heap memory: " + maxMemory + " MB");
        System.out.println("Memory used: " + usedMemory + " MB");
        System.out.println("Memory left: " + freeMemory + " MB");
    }

}
