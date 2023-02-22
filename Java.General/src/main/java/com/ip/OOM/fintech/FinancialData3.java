package com.ip.OOM.fintech;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FinancialData3 {

    private static int counter = 0;
    private String securityName;
    private double price;
    private double volume;

    private Map<String, FinancialTransaction4> financialTransaction4Map;
    private LocalDate date;


    // constructor
    public FinancialData3(String securityName, double price, double volume, LocalDate date) {
        this.securityName = securityName;
        this.price = price;
        this.volume = volume;
        this.date = date;
        this.financialTransaction4Map = new HashMap<>();
        counter++;
    }

    // getters and setters
    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void processTransactions() {

        System.out.println("Processing transactions...");

        this.financialTransaction4Map.put("key-" + counter, new FinancialTransaction4("value-" + counter, price * volume, "Transaction" + counter));
        System.out.println("Transaction " + counter + " added");

        if (counter > 1001) {

            while(true){
                this.financialTransaction4Map.put("key-" + counter, new FinancialTransaction4("value-" + counter, price * volume, "Transaction" + counter));
                System.out.println("Transaction " + counter + " overflow");
                counter++;
            }


        }
        //displayMemoryStats();



    }

    private void displayMemoryStats() {
        // Get the runtime object
        Runtime runtime = Runtime.getRuntime();

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
