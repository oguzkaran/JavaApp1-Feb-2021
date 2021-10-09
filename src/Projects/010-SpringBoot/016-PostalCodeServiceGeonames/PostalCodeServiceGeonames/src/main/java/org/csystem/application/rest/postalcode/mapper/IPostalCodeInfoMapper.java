package org.csystem.application.rest.postalcode.mapper;

import org.csystem.application.rest.postalcode.data.entity.PostalCodeInfo;
import org.csystem.application.rest.postalcode.dto.PostalCodeInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PostalCodeInfoMapper", componentModel = "spring")
public interface IPostalCodeInfoMapper {
    PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfo postalCode);
    PostalCodeInfo toPostalCodeInfo(PostalCodeInfoDTO postalCodeInfoDTO);
}
