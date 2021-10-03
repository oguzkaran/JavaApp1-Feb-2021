package org.csystem.application.rest.todo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    public long id;

    public String text;



    @ManyToOne(fetch = FetchType.LAZY)
    
    public Todo todo;
}
