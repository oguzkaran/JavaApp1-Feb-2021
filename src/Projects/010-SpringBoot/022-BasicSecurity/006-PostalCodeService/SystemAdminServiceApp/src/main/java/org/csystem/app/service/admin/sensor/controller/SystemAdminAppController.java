package org.csystem.app.service.admin.sensor.controller;

import org.csystem.app.service.admin.sensor.dto.MemberRoleSaveDTO;
import org.csystem.app.service.admin.sensor.dto.MemberSaveDTO;
import org.csystem.app.service.admin.sensor.service.SystemAdminAppService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("api/members")
public class SystemAdminAppController {
    private final SystemAdminAppService m_systemAdminAppService;

    public SystemAdminAppController(SystemAdminAppService systemAdminAppService)
    {
        m_systemAdminAppService = systemAdminAppService;
    }

    @PostMapping("member/save")
    @RolesAllowed("SYS_ADMIN")
    public MemberSaveDTO saveMember(@RequestBody MemberSaveDTO memberSaveDTO)
    {
        return m_systemAdminAppService.saveMember(memberSaveDTO);
    }

    @PostMapping("member/role/save")
    @RolesAllowed("SYS_ADMIN")
    public MemberRoleSaveDTO saveMemberMemberRole(@RequestBody MemberRoleSaveDTO memberRoleSaveDTO)
    {
        return m_systemAdminAppService.saveMemberRole(memberRoleSaveDTO);
    }
}
