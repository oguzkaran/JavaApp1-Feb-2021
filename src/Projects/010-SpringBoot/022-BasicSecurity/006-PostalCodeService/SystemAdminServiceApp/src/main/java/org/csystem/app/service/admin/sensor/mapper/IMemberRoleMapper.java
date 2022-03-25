package org.csystem.app.service.admin.sensor.mapper;

import org.csystem.app.service.admin.sensor.data.entity.MemberRole;
import org.csystem.app.service.admin.sensor.dto.MemberRoleSaveDTO;
import org.mapstruct.Mapper;

//@Mapper(implementationName = "MemberRoleMapperImpl", componentModel = "spring")
public interface IMemberRoleMapper {
    MemberRole toMemberRole(MemberRoleSaveDTO memberRoleSaveDTO);
}
