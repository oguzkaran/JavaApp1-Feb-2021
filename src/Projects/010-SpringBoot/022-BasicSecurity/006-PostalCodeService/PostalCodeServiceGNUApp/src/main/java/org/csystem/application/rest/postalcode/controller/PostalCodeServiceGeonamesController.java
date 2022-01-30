package org.csystem.application.rest.postalcode.controller;

import org.csystem.application.rest.postalcode.security.annotation.PrePostalCode;
import org.csystem.application.rest.postalcode.security.annotation.SysAdmin;
import org.csystem.application.rest.postalcode.dto.PostalCodeInfoDTO;
import org.csystem.application.rest.postalcode.service.PostalCodeAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api/postalcodes")
public class PostalCodeServiceGeonamesController {
    private final PostalCodeAppService m_postalCodeAppService;

    public PostalCodeServiceGeonamesController(PostalCodeAppService postalCodeAppService)
    {
        m_postalCodeAppService = postalCodeAppService;
    }

    @GetMapping("postalcode")
    @PrePostalCode("#code")
    public List<PostalCodeInfoDTO> findPostalCodeInfoByPostalCode1(@RequestParam("code") int code)
    {
        return m_postalCodeAppService.findPostalCodeInfoByPostalCode(code);
    }

    @GetMapping("rpostalcode")
    @RolesAllowed({"USER", "ADMIN"})
    public ResponseEntity<List<PostalCodeInfoDTO>> findPostalCodeInfoByPostalCodeRE(@RequestParam("code") int postalCode)
    {
        return ResponseEntity.ok(m_postalCodeAppService.findPostalCodeInfoByPostalCode(postalCode));
    }

    @GetMapping("epostalcode")
    @SysAdmin //@Secured("ROLE_SYS_ADMIN")
    public ResponseEntity<List<PostalCodeInfoDTO>> findPostalCodeInfoByPostalCode(@RequestParam("code") String postalCode)
    {
        return ResponseEntity.ok(m_postalCodeAppService.findPostalCodeInfoByPostalCode(Integer.parseInt(postalCode)));
    }

    //http://host:50501/api/postalcodes/postalcode/country?code=6700&country=EN -> default TR olacak
    @GetMapping("postalcode/country")
    @PreAuthorize("hasAuthority('ROLE_VIEWER') or hasRole('USER')") //@Secured({"ROLE_VIEWER", "ROLE_USER"})
    public ResponseEntity<List<PostalCodeInfoDTO>> findPostalCodeInfoByPostalCodeAndCountry(
            @RequestParam("code") int postalCode, @RequestParam(defaultValue = "TR") String country)
    {
        throw new UnsupportedOperationException("TODO:Please write that action method");
    }

}
