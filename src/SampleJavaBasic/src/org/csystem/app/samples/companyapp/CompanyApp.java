package org.csystem.app.samples.companyapp;

public class CompanyApp {
    private CompanyApp()
    {
    }

    public static void run()
    {
        Worker worker = new Worker("12345678912", "Ali", 8, 100);
        Manager manager = new Manager("12345678924", "Veli", 20000, "Yazılım");
        SalesManager salesManager = new SalesManager("12345688642", "Ayşe", 20000, "Pazarlama", 3000);

        HumanResources humanResources = new HumanResources(/*...*/);

        humanResources.payInsurance(worker);
        humanResources.payInsurance(manager);
        humanResources.payInsurance(salesManager);
    }
}
