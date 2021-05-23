/*----------------------------------------------------------------------------------------------------------------------
    Bir sınıfın veri elemanının Optional olması durumu
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Optional;

class App {
    public static void main(String[] args)
    {
        var p1 = new Person("Oğuz", "Karan");
        var p2 = new Person("Ali", "Vefa", "Serçe");

        Console.writeLine(p1.getFullname());
        Console.writeLine(p2.getFullname());
        Console.writeLine(p1);
        Console.writeLine(p2);
    }
}


class Person {
    private String m_firstName;
    private Optional<String> m_middleName;
    private String m_lastName;

    public Person(String firstName, String lastName)
    {
        this(firstName, "", lastName);
    }

    public Person(String firstName, String middleName, String lastName)
    {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public Optional<String> getMiddleName()
    {
        return m_middleName;
    }

    public void setMiddleName(String middleName)
    {
        m_middleName = middleName == null || middleName.isBlank() ? Optional.empty() : Optional.of(middleName);
    }

    public String getLastName()
    {
        return m_lastName;
    }

    public void setLastName(String lastName)
    {
        m_lastName = lastName;
    }

    public String getFullname()
    {
        return String.format("%s%s %s", m_firstName, m_middleName.map(n -> " " + n).orElse(""), m_lastName.toUpperCase());
    }

    public String toString()
    {
        return getFullname();
    }
}
