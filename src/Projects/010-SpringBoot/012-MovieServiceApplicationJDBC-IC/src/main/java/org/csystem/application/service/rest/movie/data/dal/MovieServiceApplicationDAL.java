package org.csystem.application.service.rest.movie.data.dal;

import org.csystem.application.service.rest.movie.data.entity.Director;
import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.csystem.application.service.rest.movie.data.repository.IDirectorRepository;
import org.csystem.application.service.rest.movie.data.repository.IMovieRepository;
import org.csystem.util.data.repository.RepositoryException;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.*;

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
        try {
            return m_movieRepository.count();
        }
        catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.countMovies", ex);
        }
    }

    public Iterable<Movie> findAllMovies()
    {
        try {
            return m_movieRepository.findAll();
        }
        catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.findAllMovies", ex);
        }
    }
    public Iterable<Movie> findMoviesByMonthYear(int month, int year)
    {
        try {
            return m_movieRepository.findMoviesByMonthYear(month, year);
        }
        catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.findMoviesByMonthYear", ex);
        }
    }

    public Iterable<Movie> findMoviesByYear(int year)
    {
        return doWorkForRepository(() -> m_movieRepository.findMoviesByYear(year), "MovieServiceApplicationDAL.findByYear");
    }

    public Movie saveMovie(Movie movie)
    {
        try {
            return m_movieRepository.save(movie);
        }
        catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.saveMovie", ex);
        }
    }

    public long countDirectors()
    {
        try {
            return m_directorRepository.count();
        }
        catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.countDirectors", ex);
        }
    }

    public Director saveDirector(Director director)
    {
        try {
            return m_directorRepository.save(director);
        }
        catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.saveDirector", ex);
        }
    }

    public Iterable<Director> findAllDirectors()
    {
        try {
            return m_directorRepository.findAll();
        }
        catch (Throwable ex) {
            throw new RepositoryException("MovieServiceApplicationDAL.findAllDirectors", ex);
        }
    }

    //...
}
