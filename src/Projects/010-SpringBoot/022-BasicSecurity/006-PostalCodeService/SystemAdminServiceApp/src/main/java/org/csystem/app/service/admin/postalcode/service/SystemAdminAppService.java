package org.csystem.app.service.admin.postalcode.service;

import org.csystem.app.service.admin.postalcode.data.dal.SystemAdminAppHelper;
import org.csystem.app.service.admin.postalcode.data.entity.Authority;
import org.csystem.app.service.admin.postalcode.dto.AuthoritySaveDTO;
import org.csystem.app.service.admin.postalcode.dto.UserSaveDTO;
import org.csystem.app.service.admin.postalcode.mapper.IUserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class SystemAdminAppService {
    private final SystemAdminAppHelper m_systemAdminAppHelper;
    private final IUserMapper m_userMapper;
    private final BCryptPasswordEncoder m_bCryptPasswordEncoder;

    private UserSaveDTO saveUserCallback(UserSaveDTO userSaveDTO)
    {
        userSaveDTO.password = "{bcrypt}" + m_bCryptPasswordEncoder.encode(userSaveDTO.password);
        return m_userMapper.toMemberSaveDTO(m_systemAdminAppHelper.saveUser(m_userMapper.toMember(userSaveDTO)));
    }

    private AuthoritySaveDTO saveAuthorityCallback(AuthoritySaveDTO authoritySaveDTO)
    {
        var memberOpt = m_systemAdminAppHelper.findUserById(authoritySaveDTO.username);

        if (memberOpt.isEmpty())
            throw new IllegalArgumentException("No user:" + authoritySaveDTO.username);

        var memberRole = new Authority();

        memberRole.authority = authoritySaveDTO.authority;
        memberRole.user = memberOpt.get();

        m_systemAdminAppHelper.saveAuthority(memberRole);

        return authoritySaveDTO;
    }

    public SystemAdminAppService(SystemAdminAppHelper systemAdminAppHelper, IUserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        m_systemAdminAppHelper = systemAdminAppHelper;
        m_userMapper = userMapper;
        m_bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserSaveDTO saveUser(UserSaveDTO userSaveDTO)
    {
        return doWorkForService(() -> saveUserCallback(userSaveDTO), "SystemAdminAppService.saveUser");
    }

    public AuthoritySaveDTO saveAuthority(AuthoritySaveDTO authoritySaveDTO)
    {
        return doWorkForService(() -> saveAuthorityCallback(authoritySaveDTO), "SystemAdminAppService.saveMemberRole");
    }
}
