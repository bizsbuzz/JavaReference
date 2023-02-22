package com.ip.OOM.hr;

import java.util.*;

public class Main_copy {

    private static Runtime rt;
    private static Random rand;

    public static void main(String[] args) {

        rt = Runtime.getRuntime();
        rand = new Random();

//        tooManySkills();
        largeByteArray();
    }


    private static void tooManySkills() {

//        try {
        Runtime rt = Runtime.getRuntime();
        Random rand = new Random();
        System.out.printf("Max heap memory: %s%n", rt.maxMemory());
        System.out.printf("Total heap memory: %s%n", rt.totalMemory());


        int index = 1;

        Department department = new Department("IT");
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

            System.out.printf("[%3s] Available heap memory: %s%n", index++, rt.freeMemory());
        }


        // Add the employees to departments
        for (int i = 0; i < employees.size(); i++) {

            department.addEmployee(employees.get(i));

        }


        // Display the department
        System.out.println("Department:" + department);


    }
//        catch (OutOfMemoryError e) {
//            System.out.println("Out of memory error occurred! " + e.getMessage());
//
//        }

    private static void largeByteArray() {
        List<byte[]> list = new LinkedList<>();
        int index = 1;

        while (true) {
            byte[] b = new byte[10 * 1024 * 1024]; // 10MB byte object
            list.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.printf("[%3s] Available heap memory: %s%n", index++, rt.freeMemory());
        }
    }

    private static void largeMap() {


        Map m = new HashMap();
        m = System.getProperties();
        Random r = new Random();

        while (true) {
            m.put(r.nextInt(), "randomValue");
        }
    }

}

