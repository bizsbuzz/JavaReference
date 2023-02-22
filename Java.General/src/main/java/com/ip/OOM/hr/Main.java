package com.ip.OOM.hr;

/*
https://www.geeksforgeeks.org/understanding-outofmemoryerror-exception-java/
https://codeahoy.com/java/How-To-Simulate-OOM/#:~:text=The%20Java%20Garbage%20Collection%20becomes,memory%20and%20throws%20this%20error.
 */

public class Main {



    public static void main(String[] args) {

        EmployeeAssignment employeeAssignment = new EmployeeAssignment();

        employeeAssignment.setupEmployee();

    }

}

