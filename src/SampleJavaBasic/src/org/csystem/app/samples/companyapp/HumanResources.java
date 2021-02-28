package org.csystem.app.samples.companyapp;

public class HumanResources {
    //...
    public void payInsurance(Employee employee)
    {
        //...
        System.out.printf("Citizen Id:%s%n", employee.getCitizenId());
        System.out.printf("Name:%s%n", employee.getName());
        System.out.printf("Payment:%f%n", employee.calculateInsurancePayment());
    }
}
