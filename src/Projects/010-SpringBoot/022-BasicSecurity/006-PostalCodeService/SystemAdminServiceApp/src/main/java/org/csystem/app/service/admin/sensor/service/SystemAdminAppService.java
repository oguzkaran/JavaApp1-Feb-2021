package org.csystem.app.service.admin.sensor.service;

import org.csystem.app.service.admin.sensor.data.dal.SystemAdminAppHelper;
import org.csystem.app.service.admin.sensor.data.entity.MemberRole;
import org.csystem.app.service.admin.sensor.dto.MemberRoleSaveDTO;
import org.csystem.app.service.admin.sensor.dto.MemberSaveDTO;
import org.csystem.app.service.admin.sensor.mapper.IMemberMapper;
import org.csystem.util.console.Console;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class SystemAdminAppService {
    private final SystemAdminAppHelper m_systemAdminAppHelper;
    private final IMemberMapper m_memberMapper;
    private final BCryptPasswordEncoder m_bCryptPasswordEncoder;

    private MemberSaveDTO saveMemberCallback(MemberSaveDTO memberSaveDTO)
    {
        memberSaveDTO.password = "{bcrypt}" + m_bCryptPasswordEncoder.encode(memberSaveDTO.password);
        return m_memberMapper.toMemberSaveDTO(m_systemAdminAppHelper.saveMember(m_memberMapper.toMember(memberSaveDTO)));
    }

    private MemberRoleSaveDTO saveMemberRoleCallback(MemberRoleSaveDTO memberRoleSaveDTO)
    {
        var memberOpt = m_systemAdminAppHelper.findById(memberRoleSaveDTO.memberId);

        if (memberOpt.isEmpty())
            throw new IllegalArgumentException("No member for id:" + memberRoleSaveDTO.memberId);

        var memberRole = new MemberRole();

        memberRole.role = memberRoleSaveDTO.role;
        memberRole.member = memberOpt.get();

        m_systemAdminAppHelper.saveMemberRole(memberRole);

        return memberRoleSaveDTO;
    }

    public SystemAdminAppService(SystemAdminAppHelper systemAdminAppHelper, IMemberMapper memberMapper, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        m_systemAdminAppHelper = systemAdminAppHelper;
        m_memberMapper = memberMapper;
        m_bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public MemberSaveDTO saveMember(MemberSaveDTO memberSaveDTO)
    {
        return doWorkForService(() -> saveMemberCallback(memberSaveDTO), "SystemAdminAppService.saveMember");
    }

    public MemberRoleSaveDTO saveMemberRole(MemberRoleSaveDTO memberRoleSaveDTO)
    {
        return doWorkForService(() -> saveMemberRoleCallback(memberRoleSaveDTO), "SystemAdminAppService.saveMemberRole");
    }
}
