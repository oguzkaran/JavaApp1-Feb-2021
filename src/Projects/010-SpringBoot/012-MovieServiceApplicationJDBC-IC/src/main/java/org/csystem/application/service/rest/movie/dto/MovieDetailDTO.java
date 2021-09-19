package org.csystem.application.service.rest.movie.dto;

public class MovieDetailDTO {
    private MovieDTO m_movieDTO;
    private String m_directorName;

    //...

    public MovieDTO getMovie()
    {
        return m_movieDTO;
    }

    public void setMovie(MovieDTO movieDTO)
    {
        m_movieDTO = movieDTO;
    }

    public String getDirectorName()
    {
        return m_directorName;
    }

    public void setDirectorName(String directorName)
    {
        m_directorName = directorName;
    }
}
