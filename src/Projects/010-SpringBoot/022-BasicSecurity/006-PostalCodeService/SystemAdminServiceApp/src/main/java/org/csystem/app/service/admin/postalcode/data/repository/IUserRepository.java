package org.csystem.app.service.admin.postalcode.data.repository;

import org.csystem.app.service.admin.postalcode.data.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, String> {
    //@Procedure("insert_member")
    @Query(value = "select insert_user(:username, :password, :enabled)", nativeQuery = true)
    void insertUser(String username, String password, short enabled);
}
