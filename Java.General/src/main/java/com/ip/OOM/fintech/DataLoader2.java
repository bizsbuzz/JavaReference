package com.ip.OOM.fintech;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLoader2 {

    FinancialData3 financialData3_obj;

    public void loadData(){

        System.out.println("Loading Data...");



        for (int i = 0; i < 1000000; i++) {

            financialData3_obj = new FinancialData3("Security " + i, i*2, i*4, LocalDate.now());
            financialData3_obj.processTransactions();
        }
    }
}
