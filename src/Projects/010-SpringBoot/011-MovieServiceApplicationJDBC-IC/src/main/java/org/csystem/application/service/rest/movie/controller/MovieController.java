package org.csystem.application.service.rest.movie.controller;

import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.csystem.application.service.rest.movie.dto.MovieDTO;
import org.csystem.application.service.rest.movie.service.MovieApplicationService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
@Scope("prototype")
public class MovieController {
    private final MovieApplicationService m_movieApplicationService;

    public MovieController(MovieApplicationService movieApplicationService)
    {
        m_movieApplicationService = movieApplicationService;
    }

    @GetMapping("/movies")
    public List<MovieDTO> findAll()
    {
        return m_movieApplicationService.findAllMovies();
    }

    @GetMapping("/count")
    public long count()
    {
        return m_movieApplicationService.countMovies();
    }
}
