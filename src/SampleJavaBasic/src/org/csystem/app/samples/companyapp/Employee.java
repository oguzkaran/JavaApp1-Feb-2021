package org.csystem.app.samples.companyapp;

public class Employee {
    private String m_citizenId;
    private String m_name;
    //...
    public Employee(String citizenId, String name)
    {
        //...
        m_citizenId = citizenId;
        m_name = name;
    }

    public String getCitizenId()
    {
        return m_citizenId;
    }

    public void setCitizenId(String citizenId)
    {
        //...
        m_citizenId = citizenId;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        //...
        m_name = name;
    }

    public double calculateInsurancePayment()
    {
        return 0;
    }
}
