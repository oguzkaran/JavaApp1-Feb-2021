package org.csystem.application.service.rest.movie.converter;

import org.csystem.application.service.rest.movie.data.entity.Director;
import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.csystem.application.service.rest.movie.dto.MovieDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class MovieDirectorConverter {
    private final MovieConverter m_movieConverter;
    private final DirectorConverter m_directorConverter;

    public MovieDirectorConverter(MovieConverter movieConverter, DirectorConverter directorConverter)
    {
        m_movieConverter = movieConverter;
        m_directorConverter = directorConverter;
    }

    public MovieDetailDTO toMovieDetailDTO(Movie movie, Director director)
    {
        var movieDetailDTO = new MovieDetailDTO();

        var movieDTO = m_movieConverter.toMovieDTO(movie);
        var directorDTO = m_directorConverter.toDirectorDTO(director);
        movieDetailDTO.setName(movie.getName());
        movieDetailDTO.setSceneTime(movieDTO.getSceneTime());
        movieDetailDTO.setRating(movieDTO.getRating());
        movieDetailDTO.setCost(movieDTO.getCost());
        movieDetailDTO.setDirectorName(directorDTO.getName());

        return movieDetailDTO;
    }
}
