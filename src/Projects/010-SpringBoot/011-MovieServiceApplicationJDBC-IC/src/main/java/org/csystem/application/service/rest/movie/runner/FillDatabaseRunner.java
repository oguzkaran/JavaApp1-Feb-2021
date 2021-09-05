package org.csystem.application.service.rest.movie.runner;

import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.csystem.application.service.rest.movie.data.repository.IMovieRepository;
import org.csystem.util.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class FillDatabaseRunner implements ApplicationRunner {
    private final IMovieRepository m_movieRepository;

    public FillDatabaseRunner(IMovieRepository movieRepository)
    {
        m_movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Movie movie = new Movie();

        movie.name = "Inseption";
        movie.sceneTime = LocalDate.now();
        movie.rating = 100000;
        movie.cost = new BigDecimal(100000000);
        movie.imdb = 7.5F;

        m_movieRepository.save(movie);

        Console.writeLine("id:%d", movie.id);
        Console.writeLine("Count:%d", m_movieRepository.count());
    }
}
