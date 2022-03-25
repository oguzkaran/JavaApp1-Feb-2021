package org.csystem.app.service.admin.sensor.data.repository;

import org.csystem.app.service.admin.sensor.data.entity.MemberRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IMemberRoleRepository extends CrudRepository<MemberRole, Integer> {
    @Query(value = "call sp_insert_member_role_by_member_id(:memberId, :role)", nativeQuery = true)
    void insertMemberRoleByMemberId(int memberId, String role);
}
