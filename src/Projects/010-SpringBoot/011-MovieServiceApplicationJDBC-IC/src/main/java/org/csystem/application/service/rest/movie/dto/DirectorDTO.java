package org.csystem.application.service.rest.movie.dto;

import java.time.LocalDate;

public class DirectorDTO {
    private String m_name;
    private LocalDate m_birthDate;

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }
}
