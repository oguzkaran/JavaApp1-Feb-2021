package org.csystem.app.service.admin.sensor.data.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public int id;

    @Column(length = 50)
    public String username;

    @Column(length = 100)
    public String password;

    public boolean enabled;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<MemberRole> memberRoles;
}
