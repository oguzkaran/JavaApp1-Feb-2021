package org.csystem.application.rest.postalcode.runner;

import org.csystem.application.rest.postalcode.data.dal.PostalCodeServiceHelper;
import org.csystem.application.rest.postalcode.geonames.json.dto.PostalCodeInfo;
import org.csystem.application.rest.postalcode.service.PostalCodeAppService;
import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeonamesRestRunner implements ApplicationRunner {
    private final PostalCodeAppService m_postalCodeAppService;


    public GeonamesRestRunner(PostalCodeAppService postalCodeAppService)
    {
        m_postalCodeAppService = postalCodeAppService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        var pc = m_postalCodeAppService.findPostalCodeInfoByPostalCode(34387);

        if (!pc.isEmpty())
            pc.forEach(Console::writeLine);
    }
}
