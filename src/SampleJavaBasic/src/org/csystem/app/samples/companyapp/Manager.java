package org.csystem.app.samples.companyapp;

public class Manager extends Employee {
    private double m_salary;
    private String m_department;

    public Manager(String citizenId, String name, double salary, String department)
    {
        super(citizenId, name);
        m_salary = salary;
        m_department = department;
    }

    public double getSalary()
    {
        return m_salary;
    }

    public void setSalary(double salary)
    {
        //...
        m_salary = salary;
    }

    public String getDepartment()
    {
        return m_department;
    }

    public void setDepartment(String department)
    {
        //...
        m_department = department;
    }

    public double calculateInsurancePayment()
    {
        return m_salary * 1.5;
    }
}
