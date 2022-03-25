package org.csystem.app.service.admin.sensor.mapper;

import org.csystem.app.service.admin.sensor.data.entity.Authority;
import org.csystem.app.service.admin.sensor.dto.AuthoritySaveDTO;

//@Mapper(implementationName = "MemberRoleMapperImpl", componentModel = "spring")
public interface IAuthorityMapper {
    Authority toMemberRole(AuthoritySaveDTO memberRoleSaveDTO);
}
