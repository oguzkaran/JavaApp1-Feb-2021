package org.csystem.application.rest.todo.service;

import org.csystem.application.rest.todo.converter.TodoInfoConverter;
import org.csystem.application.rest.todo.converter.TodoSaveConverter;
import org.csystem.application.rest.todo.data.dal.TodoAppDAL;
import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
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

    private static <T, R> List<R> toList(Iterable<? extends T> iterable, boolean parallel, Function<? super T, ? extends R> function)
    {
        return StreamSupport.stream(iterable.spliterator(), parallel)
                .map(function)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findAllTodosCallback()
    {
        return toList(m_todoAppDAL.findAllTodos(), true, m_todoInfoConverter::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed)
    {
        return StreamSupport.stream(m_todoAppDAL.findTodosByCompleted(completed).spliterator(), true)
                .map(m_todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title)
    {
        return StreamSupport.stream(m_todoAppDAL.findTodosByTitle(title).spliterator(), false)
                .map(m_todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String text)
    {
        return StreamSupport.stream(m_todoAppDAL.findTodosByTitleContains(text).spliterator(), false)
                .map(m_todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }


    private Iterable<TodoInfoDTO> findByCompletedAndTitleCallback(boolean completed, String title)
    {
        return StreamSupport.stream(m_todoAppDAL.findByCompletedAndTitle(completed, title).spliterator(), false)
                .map(m_todoInfoConverter::toTodoInfoDTO)
                .collect(Collectors.toList());
    }

    private Iterable<TodoInfoDTO> findByCompletedAndTitleContainsCallback(boolean completed, String title)
    {
        return StreamSupport.stream(m_todoAppDAL.findByCompletedAndTitleContains(completed, title).spliterator(), false)
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

    public Iterable<TodoInfoDTO> findTodosByTitle(String title)
    {
        return doWorkForService(() -> findTodosByTitleCallback(title), "TodoService.findTodosByTitle");
    }

    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text)
    {
        return doWorkForService(() -> findTodosByTitleContainsCallback(text), "TodoService.findTodosByTitleContains");
    }

    public Iterable<TodoInfoDTO> findByCompletedAndTitle(boolean completed, String title)
    {
        return doWorkForService(() -> findByCompletedAndTitleCallback(completed, title), "TodoService.findByCompletedAndTitle");
    }


    public Iterable<TodoInfoDTO> findByCompletedAndTitleContains(boolean completed, String text)
    {
        return doWorkForService(() -> findByCompletedAndTitleContainsCallback(completed, text), "TodoService.findByCompletedAndTitle");
    }

    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO)
    {
        return doWorkForService(() -> saveCallback(todoSaveDTO), "TodoService.saveTodo");
    }
}
