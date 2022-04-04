package org.csystem.app.service.admin.postalcode.data.entity;

import javax.persistence.*;


@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    public int id;

    @Column(length = 50)
    public String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    public User user;
}

