package org.csystem.application.service.rest.movie.data.dal;

import org.csystem.application.service.rest.movie.data.entity.Director;
import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.csystem.application.service.rest.movie.data.repository.IDirectorRepository;
import org.csystem.application.service.rest.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceApplicationDAL {
    private final IMovieRepository m_movieRepository;
    private final IDirectorRepository m_directorRepository;

    public MovieServiceApplicationDAL(IMovieRepository movieRepository, IDirectorRepository directorRepository)
    {
        m_movieRepository = movieRepository;
        m_directorRepository = directorRepository;
    }

    public long countMovies()
    {
        //...
        return m_movieRepository.count();
    }

    public Iterable<Movie> findAllMovies()
    {
        return m_movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie)
    {
        //...
        return m_movieRepository.save(movie);
    }

    public long countDirectors()
    {
        return m_directorRepository.count();
    }


    public Director saveDirector(Director director)
    {
        return m_directorRepository.save(director);
    }

    public Iterable<Director> findAllDirectors()
    {
        return m_directorRepository.findAll();
    }

    //...
}
