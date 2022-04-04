package org.csystem.app.service.admin.postalcode.mapper;

import org.csystem.app.service.admin.postalcode.data.entity.Authority;
import org.csystem.app.service.admin.postalcode.dto.AuthoritySaveDTO;

//@Mapper(implementationName = "MemberRoleMapperImpl", componentModel = "spring")
public interface IAuthorityMapper {
    Authority toMemberRole(AuthoritySaveDTO memberRoleSaveDTO);
}
