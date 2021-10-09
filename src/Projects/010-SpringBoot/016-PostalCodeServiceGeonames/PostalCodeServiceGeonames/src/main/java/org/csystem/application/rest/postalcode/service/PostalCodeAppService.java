package org.csystem.application.rest.postalcode.service;

import org.csystem.application.rest.postalcode.data.dal.PostalCodeServiceHelper;
import org.csystem.application.rest.postalcode.geonames.json.dto.PostalCode;
import org.csystem.application.rest.postalcode.geonames.json.dto.PostalCodeInfo;
import org.csystem.application.rest.postalcode.mapper.IPostalCodeInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostalCodeAppService {
    private final PostalCodeServiceHelper m_postalCodeServiceHelper;
    private final RestTemplate m_restTemplate;
    private final IPostalCodeInfoMapper m_postalCodeInfoMapper;

    @Value("${geonames.uri}")
    private String m_urlTemplate;

    public PostalCodeAppService(PostalCodeServiceHelper postalCodeServiceHelper, RestTemplate restTemplate, IPostalCodeInfoMapper postalCodeInfoMapper)
    {
        m_postalCodeServiceHelper = postalCodeServiceHelper;
        m_restTemplate = restTemplate;
        m_postalCodeInfoMapper = postalCodeInfoMapper;
    }

    public List<PostalCode> findPostalCodeInfoByPostalCode(int postalCode)
    {
        var url = String.format(m_urlTemplate, postalCode);

        return m_restTemplate.getForObject(url, PostalCodeInfo.class).postalCodes;
    }
}
