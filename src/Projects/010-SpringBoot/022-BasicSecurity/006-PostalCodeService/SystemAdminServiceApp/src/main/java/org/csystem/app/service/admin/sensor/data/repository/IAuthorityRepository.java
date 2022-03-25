package org.csystem.app.service.admin.sensor.data.repository;

import org.csystem.app.service.admin.sensor.data.entity.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorityRepository extends CrudRepository<Authority, Integer> {
    @Query(value = "call sp_insert_authority(:username, :role)", nativeQuery = true)
    void insertAuthority(String username, String role);
}
