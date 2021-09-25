package org.csystem.application.rest.todo.data.dal;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.csystem.application.rest.todo.data.repository.ITodoRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.*;

@Component
public class TodoAppDAL {
    private final ITodoRepository m_todoRepository;

    public TodoAppDAL(ITodoRepository todoRepository)
    {
        m_todoRepository = todoRepository;
    }

    public Iterable<Todo> findAllTodos()
    {
        return doWorkForRepository(m_todoRepository::findAll, "TodoAppDAL.saveTodo");
    }

    public Iterable<Todo> findTodosByCompleted(boolean completed)
    {
        return doWorkForRepository(() -> m_todoRepository.findByCompleted(completed), "TodoAppDAL.findTodosByCompleted");
    }

    public Todo saveTodo(Todo todo)
    {
        return doWorkForRepository(() -> m_todoRepository.save(todo), "TodoAppDAL.saveTodo");
    }
}
