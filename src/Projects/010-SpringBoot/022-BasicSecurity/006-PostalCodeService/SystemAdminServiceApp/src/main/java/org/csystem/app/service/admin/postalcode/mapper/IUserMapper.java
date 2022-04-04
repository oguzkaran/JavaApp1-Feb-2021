package org.csystem.app.service.admin.postalcode.mapper;

import org.csystem.app.service.admin.postalcode.data.entity.User;
import org.csystem.app.service.admin.postalcode.dto.UserSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MemberMapperImpl", componentModel = "spring")
public interface IUserMapper {
    User toMember(UserSaveDTO memberSaveDTO);
    UserSaveDTO toMemberSaveDTO(User user);
}
