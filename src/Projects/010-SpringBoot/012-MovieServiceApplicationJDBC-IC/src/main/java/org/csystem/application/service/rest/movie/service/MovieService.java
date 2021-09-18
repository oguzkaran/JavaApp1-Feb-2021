package org.csystem.application.service.rest.movie.service;

import org.csystem.application.service.rest.movie.converter.MovieConverter;
import org.csystem.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import org.csystem.application.service.rest.movie.dto.MovieDTO;
import org.csystem.util.data.repository.RepositoryException;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import static org.csystem.util.data.DatabaseUtil.*;

@Service
public class MovieService {
    private final MovieServiceApplicationDAL m_movieServiceApplicationDAL;
    private final MovieConverter m_movieConverter;

    public MovieService(MovieServiceApplicationDAL movieServiceApplicationDAL, MovieConverter movieConverter)
    {
        m_movieServiceApplicationDAL = movieServiceApplicationDAL;
        m_movieConverter = movieConverter;
    }

    public long countMovies()
    {
        try {
            return m_movieServiceApplicationDAL.countMovies();
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.countMovies", ex);
        }
    }

    public List<MovieDTO> findAllMovies()
    {
        try {
            return StreamSupport.stream(m_movieServiceApplicationDAL.findAllMovies().spliterator(), false)
                    .map(m_movieConverter::toMovieDTO)
                    .collect(Collectors.toList());
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.findAllMovies", ex);
        }
    }

    public List<MovieDTO> findMoviesByMonthYear(int month, int year)
    {
        try {
            return StreamSupport.stream(m_movieServiceApplicationDAL.findMoviesByMonthYear(month, year).spliterator(), false)
                    .map(m_movieConverter::toMovieDTO)
                    .collect(Collectors.toList());
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.findMoviesByMonthYear", ex);
        }
    }

    public List<MovieDTO> findMoviesByYear(int year)
    {
        return doWorkForService(() -> StreamSupport.stream(m_movieServiceApplicationDAL.findMoviesByYear(year).spliterator(), false)
                .map(m_movieConverter::toMovieDTO)
                .collect(Collectors.toList()), "MovieApplicationService.findMoviesByYear");
    }

    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        try {
            m_movieServiceApplicationDAL.saveMovie(m_movieConverter.toMovie(movieDTO));

            return movieDTO;
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.saveMovie", ex.getCause());
        }
    }
    //...
}
