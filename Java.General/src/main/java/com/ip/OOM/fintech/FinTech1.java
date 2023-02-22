package com.ip.OOM.fintech;

public class FinTech1 {
    DataLoader2 dataLoader2_obj;

    public static void main(String[] args) {

        FinTech1 finTech = new FinTech1();
        finTech.load();

    }

    public void load() {

        dataLoader2_obj = new DataLoader2();
        dataLoader2_obj.loadData();

    }
}
