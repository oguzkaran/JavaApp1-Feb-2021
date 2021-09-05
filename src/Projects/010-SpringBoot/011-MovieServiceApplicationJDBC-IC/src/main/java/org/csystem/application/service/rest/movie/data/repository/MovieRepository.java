package org.csystem.application.service.rest.movie.data.repository;

import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository {
    private static final String COUNT_SQL = "select count(*) from movies";
    private static final String FIND_BY_MONTH_YEAR = "select * from movies where date_part('month', scene_time) = :month and date_part('year', scene_time) = :year";
    private static final String FIND_BY_YEAR = "select * from movies where date_part('year', scene_time) = :year";
    private static final String SAVE_SQL = "insert into movies (name, rating, scene_time, cost, imdb) values (:name, :rating, :sceneTime, :cost, :imdb)";
    private final NamedParameterJdbcTemplate m_jdbcTemplate;

    private static void fillCounts(ResultSet resultSet, ArrayList<Long> counts) throws SQLException
    {
        do
            counts.add(resultSet.getLong(1));
        while (resultSet.next());
    }

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate)
    {
        m_jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_jdbcTemplate.query(COUNT_SQL, (ResultSet rs) -> fillCounts(rs, counts) );

        return counts.isEmpty() ? 0 : counts.get(0);
    }



    @Override
    public <S extends Movie> S save(S movie)
    {
        var keyHolder = new GeneratedKeyHolder();
        var parameterSource = new BeanPropertySqlParameterSource(movie);

        parameterSource.registerSqlType("sceneTime", Types.DATE);

        m_jdbcTemplate.update(SAVE_SQL, parameterSource, keyHolder, new String[]{"movie_id"});

        movie.id = keyHolder.getKey().longValue();

        return movie;
    }

    @Override
    public Iterable<Movie> findMoviesByYear(int year)
    {
        return null;
    }

    @Override
    public Iterable<Movie> findMoviesByMonthYear(int month, int year)
    {
        return null;
    }

    @Override
    public void delete(Movie entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
