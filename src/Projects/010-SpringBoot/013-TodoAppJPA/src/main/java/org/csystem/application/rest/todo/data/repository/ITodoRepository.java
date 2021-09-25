package org.csystem.application.rest.todo.data.repository;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    @Query("select td from Todo td where td.m_completed = :completed") //select * from todos where completed = :completed"
    Iterable<Todo> findByCompleted(boolean completed);
}
