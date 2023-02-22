package com.ip.OOM.fintech;

public class FinancialTransaction4 {
    private String transactionId;
    private double amount;
    private String description;


    public FinancialTransaction4(String transactionId, double amount, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;

    }

    // Getters and setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}