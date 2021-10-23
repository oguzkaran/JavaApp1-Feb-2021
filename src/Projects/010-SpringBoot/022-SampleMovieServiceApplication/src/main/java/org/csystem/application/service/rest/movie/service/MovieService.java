package org.csystem.application.service.rest.movie.service;

import org.csystem.application.service.rest.movie.converter.MovieConverter;
import org.csystem.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import org.csystem.application.service.rest.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class MovieService {
    private final MovieServiceApplicationDAL m_movieServiceApplicationDAL;
    private final MovieConverter m_movieConverter;

    private List<MovieDTO> findAllMoviesCallback()
    {
        return StreamSupport.stream(m_movieServiceApplicationDAL.findAllMovies().spliterator(), false)
                .map(m_movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }

    private List<MovieDTO> findMoviesByMonthYearCallback(int month, int year)
    {
        return StreamSupport.stream(m_movieServiceApplicationDAL.findMoviesByMonthYear(month, year).spliterator(), false)
                .map(m_movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }

    private List<MovieDTO> findMoviesByYearCallback(int year)
    {
        return StreamSupport.stream(m_movieServiceApplicationDAL.findMoviesByYear(year).spliterator(), false)
                .map(m_movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }

    private MovieDTO saveMovieCallback(MovieDTO movieDTO)
    {
        m_movieServiceApplicationDAL.saveMovie(m_movieConverter.toMovie(movieDTO));

        return movieDTO;
    }


    public MovieService(MovieServiceApplicationDAL movieServiceApplicationDAL, MovieConverter movieConverter)
    {
        m_movieServiceApplicationDAL = movieServiceApplicationDAL;
        m_movieConverter = movieConverter;
    }

    public long countMovies()
    {
        return doWorkForService(m_movieServiceApplicationDAL::countMovies, "MovieApplicationService.countMovies");
    }

    public List<MovieDTO> findAllMovies()
    {
        return doWorkForService(this::findAllMoviesCallback, "MovieApplicationService.findAllMovies");
    }

    public List<MovieDTO> findMoviesByMonthYear(int month, int year)
    {
        return doWorkForService(() -> findMoviesByMonthYearCallback(month, year),
                "MovieApplicationService.findMoviesByMonthYear");
    }

    public List<MovieDTO> findMoviesByYear(int year)
    {
        return doWorkForService(() -> findMoviesByYearCallback(year), "MovieApplicationService.findMoviesByYear");
    }

    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        return doWorkForService(() -> saveMovieCallback(movieDTO), "MovieApplicationService.saveMovie");
    }
}
