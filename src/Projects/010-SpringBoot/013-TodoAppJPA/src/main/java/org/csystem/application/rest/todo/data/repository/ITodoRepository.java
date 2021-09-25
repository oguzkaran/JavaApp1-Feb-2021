package org.csystem.application.rest.todo.data.repository;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    //...
}
