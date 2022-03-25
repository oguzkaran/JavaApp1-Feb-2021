package org.csystem.app.service.admin.sensor.mapper;

import org.csystem.app.service.admin.sensor.data.entity.Member;
import org.csystem.app.service.admin.sensor.dto.MemberSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MemberMapperImpl", componentModel = "spring")
public interface IMemberMapper {
    Member toMember(MemberSaveDTO memberSaveDTO);
    MemberSaveDTO toMemberSaveDTO(Member member);
}
