package org.csystem.app.service.admin.sensor.data.dal;

import org.csystem.app.service.admin.sensor.data.entity.Member;
import org.csystem.app.service.admin.sensor.data.entity.MemberRole;
import org.csystem.app.service.admin.sensor.data.repository.IMemberRepository;
import org.csystem.app.service.admin.sensor.data.repository.IMemberRoleRepository;
import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

import java.lang.management.MemoryPoolMXBean;
import java.util.Optional;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;
import static org.csystem.util.data.DatabaseUtil.doWorkForRepositoryRunnable;

@Component
public class SystemAdminAppHelper {
    private final IMemberRepository m_memberRepository;
    private final IMemberRoleRepository m_memberRoleRepository;

    private Member saveMemberCallback(Member member)
    {
        m_memberRepository.insertMember(member.username, member.password, member.enabled);

        return member;
    }

    private void saveMemberRoleCallback(MemberRole memberRole)
    {
        m_memberRoleRepository.insertMemberRoleByMemberId(memberRole.member.id, memberRole.role);
    }

    public SystemAdminAppHelper(IMemberRepository memberRepository, IMemberRoleRepository memberRoleRepository)
    {
        m_memberRepository = memberRepository;
        m_memberRoleRepository = memberRoleRepository;
    }

    public Optional<Member> findById(int id)
    {
        return doWorkForRepository(() -> m_memberRepository.findById(id), "SystemAdminAppHelper.findById");
    }

    public Member saveMember(Member member)
    {
        return doWorkForRepository(() -> saveMemberCallback(member), "SystemAdminAppHelper.saveMember");
    }

    public void saveMemberRole(MemberRole memberRole)
    {
        doWorkForRepositoryRunnable(() -> saveMemberRoleCallback(memberRole), "SystemAdminAppHelper.saveMemberRole");
    }
    //...
}
