package org.csystem.application.service.rest.movie.service;

import org.csystem.application.service.rest.movie.converter.DirectorConverter;
import org.csystem.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import org.csystem.application.service.rest.movie.dto.DirectorDTO;
import org.csystem.util.data.repository.RepositoryException;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DirectoryService {
    private final MovieServiceApplicationDAL m_movieServiceApplicationDAL;
    private final DirectorConverter m_directorConverter;

    public DirectoryService(MovieServiceApplicationDAL movieServiceApplicationDAL, DirectorConverter directorConverter)
    {
        m_movieServiceApplicationDAL = movieServiceApplicationDAL;
        m_directorConverter = directorConverter;
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO)
    {
        try {
            m_movieServiceApplicationDAL.saveDirector(m_directorConverter.toDirector(directorDTO));

            return directorDTO;
        }
        catch (RepositoryException ex) {
            throw new DataServiceException("MovieApplicationService.saveDirector", ex.getCause());
        }
    }

    public List<DirectorDTO> findAllDirectors()
    {
        try {
            return StreamSupport.stream(m_movieServiceApplicationDAL.findAllDirectors().spliterator(), false)
                    .map(m_directorConverter::toDirectorDTO)
                    .collect(Collectors.toList());
        }
        catch (Throwable ex) {
            throw new DataServiceException("MovieApplicationService.findAllDirectors", ex.getCause());
        }
    }

    //...
}
