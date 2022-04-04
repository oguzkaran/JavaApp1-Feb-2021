package org.csystem.app.service.admin.postalcode.data.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(length = 50)
    public String username;

    @Column(length = 100)
    public String password;

    public short enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Authority> memberRoles;
}

