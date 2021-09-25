package org.csystem.application.rest.todo.service;

import org.csystem.application.rest.todo.converter.TodoInfoConverter;
import org.csystem.application.rest.todo.converter.TodoSaveConverter;
import org.csystem.application.rest.todo.data.dal.TodoAppDAL;
import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.*;

@Service
public class TodoService {
    private final TodoAppDAL m_todoAppDAL;
    private final TodoInfoConverter m_todoInfoConverter;
    private final TodoSaveConverter m_todoSaveConverter;

    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO)
    {
        return m_todoInfoConverter.toTodoInfoDTO(m_todoAppDAL.saveTodo(m_todoSaveConverter.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findAllTodosCallback()
    {
        return StreamSupport.stream(m_todoAppDAL.findAllTodos().spliterator(), true)
                .map(m_todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed)
    {
        return StreamSupport.stream(m_todoAppDAL.findTodosByCompleted(completed).spliterator(), true)
                .map(m_todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    public TodoService(TodoAppDAL todoAppDAL, TodoInfoConverter todoInfoConverter, TodoSaveConverter todoSaveConverter)
    {
        m_todoAppDAL = todoAppDAL;
        m_todoInfoConverter = todoInfoConverter;
        m_todoSaveConverter = todoSaveConverter;
    }

    public List<TodoInfoDTO> findAllTodos()
    {
        return doWorkForService(this::findAllTodosCallback, "TodoService.findAll");
    }
    public List<TodoInfoDTO> findTodosByCompleted(boolean completed)
    {
        return doWorkForService(() -> findTodosByCompletedCallback(completed), "TodoService.findTodosByCompleted");
    }

    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO)
    {
        return doWorkForService(() -> saveCallback(todoSaveDTO), "TodoService.saveTodo");
    }
}
