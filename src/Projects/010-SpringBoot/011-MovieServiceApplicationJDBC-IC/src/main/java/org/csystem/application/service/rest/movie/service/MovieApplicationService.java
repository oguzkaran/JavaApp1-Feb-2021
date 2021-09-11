package org.csystem.application.service.rest.movie.service;

import org.csystem.application.service.rest.movie.converter.MovieConverter;
import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.csystem.application.service.rest.movie.data.repository.IMovieRepository;
import org.csystem.application.service.rest.movie.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieApplicationService {
    private final IMovieRepository m_movieRepository;
    private final MovieConverter m_movieConverter;

    public MovieApplicationService(IMovieRepository movieRepository, MovieConverter movieConverter)
    {
        m_movieRepository = movieRepository;
        m_movieConverter = movieConverter;
    }

    public long countMovies()
    {
        //...
        return m_movieRepository.count();
    }

    public List<MovieDTO> findAllMovies()
    {
        return StreamSupport.stream(m_movieRepository.findAll().spliterator(), false)
                .map(m_movieConverter::toMovieDTO)
                .collect(Collectors.toList());
    }

    public Movie saveMovie(Movie movie)
    {
        //...
        return m_movieRepository.save(movie);
    }
}
