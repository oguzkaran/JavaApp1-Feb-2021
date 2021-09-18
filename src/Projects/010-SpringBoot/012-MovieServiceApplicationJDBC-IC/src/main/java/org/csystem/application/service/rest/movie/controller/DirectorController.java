package org.csystem.application.service.rest.movie.controller;

import org.csystem.application.service.rest.movie.dto.DirectorDTO;
import org.csystem.application.service.rest.movie.service.DirectoryService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("api/director")
public class DirectorController {
    private final DirectoryService m_directoryService;

    public DirectorController(DirectoryService directoryService)
    {
        m_directoryService = directoryService;
    }

    @GetMapping("/all")
    public List<DirectorDTO> findAllDirectors()
    {
        try {
            return m_directoryService.findAllDirectors();
        }
        catch (DataServiceException ex) {
            return new ArrayList<>(); //Geçici olarak yazıldı
        }
    }
}
