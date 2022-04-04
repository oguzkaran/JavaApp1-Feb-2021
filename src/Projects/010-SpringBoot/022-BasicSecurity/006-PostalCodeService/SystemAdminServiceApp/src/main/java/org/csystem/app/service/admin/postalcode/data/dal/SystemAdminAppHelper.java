package org.csystem.app.service.admin.postalcode.data.dal;

import org.csystem.app.service.admin.postalcode.data.entity.Authority;
import org.csystem.app.service.admin.postalcode.data.entity.User;
import org.csystem.app.service.admin.postalcode.data.repository.IAuthorityRepository;
import org.csystem.app.service.admin.postalcode.data.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;
import static org.csystem.util.data.DatabaseUtil.doWorkForRepositoryRunnable;

@Component
public class SystemAdminAppHelper {
    private final IUserRepository m_memberRepository;
    private final IAuthorityRepository m_memberRoleRepository;

    private User saveUserCallback(User user)
    {
        m_memberRepository.insertUser(user.username, user.password, user.enabled);

        return user;
    }

    private void saveAuthorityCallback(Authority authority)
    {
        m_memberRoleRepository.insertAuthority(authority.user.username, authority.authority);
    }

    public SystemAdminAppHelper(IUserRepository memberRepository, IAuthorityRepository memberRoleRepository)
    {
        m_memberRepository = memberRepository;
        m_memberRoleRepository = memberRoleRepository;
    }

    public Optional<User> findUserById(String username)
    {
        return doWorkForRepository(() -> m_memberRepository.findById(username), "SystemAdminAppHelper.findUserById");
    }

    public User saveUser(User user)
    {
        return doWorkForRepository(() -> saveUserCallback(user), "SystemAdminAppHelper.saveUser");
    }

    public void saveAuthority(Authority authority)
    {
        doWorkForRepositoryRunnable(() -> saveAuthorityCallback(authority), "SystemAdminAppHelper.saveAuthority");
    }
    //...
}
