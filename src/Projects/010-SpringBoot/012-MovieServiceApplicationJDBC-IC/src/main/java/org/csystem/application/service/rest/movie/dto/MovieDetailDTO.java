package org.csystem.application.service.rest.movie.dto;

public class MovieDetailDTO extends MovieDTO {
    private String m_directorName;

    //...
    public String getDirectorName()
    {
        return m_directorName;
    }

    public void setDirectorName(String directorName)
    {
        m_directorName = directorName;
    }
}
