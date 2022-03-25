package org.csystem.app.service.admin.sensor.mapper;

import org.csystem.app.service.admin.sensor.data.entity.User;
import org.csystem.app.service.admin.sensor.dto.UserSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MemberMapperImpl", componentModel = "spring")
public interface IUserMapper {
    User toMember(UserSaveDTO memberSaveDTO);
    UserSaveDTO toMemberSaveDTO(User user);
}
