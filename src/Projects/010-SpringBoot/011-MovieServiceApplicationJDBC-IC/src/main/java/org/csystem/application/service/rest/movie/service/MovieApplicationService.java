package org.csystem.application.service.rest.movie.service;

import org.csystem.application.service.rest.movie.converter.DirectorConverter;
import org.csystem.application.service.rest.movie.converter.MovieConverter;
import org.csystem.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import org.csystem.application.service.rest.movie.dto.DirectorDTO;
import org.csystem.application.service.rest.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieApplicationService {
    private final MovieServiceApplicationDAL m_movieServiceApplicationDAL;
    private final MovieConverter m_movieConverter;
    private final DirectorConverter m_directorConverter;

    public MovieApplicationService(MovieServiceApplicationDAL movieServiceApplicationDAL, MovieConverter movieConverter, DirectorConverter directorConverter)
    {
        m_movieServiceApplicationDAL = movieServiceApplicationDAL;
        m_movieConverter = movieConverter;
        m_directorConverter = directorConverter;
    }

    public long countMovies()
    {
        //...
        return m_movieServiceApplicationDAL.countMovies();
    }

    public List<MovieDTO> findAllMovies()
    {
        return StreamSupport.stream(m_movieServiceApplicationDAL.findAllMovies().spliterator(), false)
                .map(m_movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        //...
        m_movieServiceApplicationDAL.saveMovie(m_movieConverter.toMovie(movieDTO));

        return movieDTO;
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO)
    {
        m_movieServiceApplicationDAL.saveDirector(m_directorConverter.toDirector(directorDTO));

        return directorDTO;
    }

    public List<DirectorDTO> findAllDirectors()
    {
        return StreamSupport.stream(m_movieServiceApplicationDAL.findAllDirectors().spliterator(), false)
                .map(m_directorConverter::toDirectorDTO)
                .collect(Collectors.toList());
    }

    //...
}
