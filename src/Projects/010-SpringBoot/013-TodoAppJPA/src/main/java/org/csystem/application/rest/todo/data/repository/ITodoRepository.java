package org.csystem.application.rest.todo.data.repository;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    //@Query("select td from Todo td where td.completed = :completed") //select * from todos where completed = :completed"
    Iterable<Todo> findByCompleted(boolean completed);

    //@Query("select td from Todo td where td.title = :title")
    Iterable<Todo> findByTitle(String title);

    Iterable<Todo> findByTitleContains(String text);

    //@Query("select td from Todo td where td.completed=:completed and td.title = :title")
    Iterable<Todo> findByCompletedAndTitle(boolean completed, String title);

    Iterable<Todo> findByCompletedAndTitleContains(boolean completed, String text);

    //Iterable<Todo> findByTitleOrderBy(String title);
}
