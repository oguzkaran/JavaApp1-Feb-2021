package org.csystem.application.service.rest.movie.controller;

import org.csystem.application.service.rest.movie.dto.MovieDTO;
import org.csystem.application.service.rest.movie.dto.MovieDetailDTO;
import org.csystem.application.service.rest.movie.service.MovieService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/movie")
@Scope("prototype")
public class MovieController {
    private final MovieService m_movieService;

    public MovieController(MovieService movieService)
    {
        m_movieService = movieService;
    }

    @GetMapping("/all")
    public List<MovieDTO> findAll()
    {
        try {
            return m_movieService.findAllMovies();
        }
        catch (DataServiceException ex) {
            return new ArrayList<>(); //Bu geçici olarak yapıldı
        }
    }

    @GetMapping("/info")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") int year)
    {
        try {
            return m_movieService.findMoviesByYear(year);
        }
        catch (DataServiceException ex) {
            return new ArrayList<>(); //Bu geçici olarak yapıldı
        }
    }

    @GetMapping("/infos")
    public List<MovieDTO> findMovieByYear(@RequestParam("year") String yearStr)
    {
        try {
            return m_movieService.findMoviesByYear(Integer.parseInt(yearStr));
        }
        catch (DataServiceException|NumberFormatException ex) {
            return new ArrayList<>(); //Bu geçici olarak yapıldı
        }
    }

    @GetMapping("/infosre")
    public ResponseEntity<List<MovieDTO>> findMovieByYearResponseEntity(@RequestParam("year") String yearStr)
    {
        ResponseEntity<List<MovieDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_movieService.findMoviesByYear(Integer.parseInt(yearStr)));
        }
        catch (DataServiceException|NumberFormatException ex) {
            //...
        }

        return responseEntity;
    }

    @GetMapping("/info/detail")
    public ResponseEntity<List<MovieDetailDTO>> findMoviesDetailsByYear(@RequestParam("year") String yearStr)
    {
        ResponseEntity<List<MovieDetailDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_movieService.findMoviesDetailsByYear(Integer.parseInt(yearStr)));
        }
        catch (DataServiceException|NumberFormatException ex) {
            //...
        }

        return responseEntity;
    }

    @GetMapping("/count")
    public long count()
    {
        try {
            return m_movieService.countMovies();
        }
        catch (DataServiceException ex) {
            return -1; //Geçici olarak yapıldı
        }
    }


}
