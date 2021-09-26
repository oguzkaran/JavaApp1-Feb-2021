package org.csystem.application.rest.todo.service;

import org.csystem.application.rest.todo.data.dal.TodoAppDAL;
import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.csystem.application.rest.todo.mapper.ITodoInfoMapper;
import org.csystem.application.rest.todo.mapper.ITodoSaveMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class TodoService {
    private final TodoAppDAL m_todoAppDAL;
    private final ITodoInfoMapper m_todoInfoMapper;
    private final ITodoSaveMapper m_todoSaveMapper;

    private TodoInfoDTO saveCallback(TodoSaveDTO todoSaveDTO)
    {
        return m_todoInfoMapper.toTodoInfoDTO(m_todoAppDAL.saveTodo(m_todoSaveMapper.toTodo(todoSaveDTO)));
    }

    //Bu metot library'ye eklenecek
    private static <T, R> List<R> convertToList(Iterable<? extends T> iterable, boolean parallel, Function<? super T, ? extends R> function)
    {
        return StreamSupport.stream(iterable.spliterator(), parallel)
                .map(function)
                .collect(Collectors.toList());
    }

    private List<TodoInfoDTO> findAllTodosCallback()
    {
        return convertToList(m_todoAppDAL.findAllTodos(), true, m_todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed)
    {
        return convertToList(m_todoAppDAL.findTodosByCompleted(completed), true, m_todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title)
    {
        return convertToList(m_todoAppDAL.findTodosByTitle(title), false, m_todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String text)
    {
        return convertToList(m_todoAppDAL.findTodosByTitleContains(text), false, m_todoInfoMapper::toTodoInfoDTO);
    }


    private Iterable<TodoInfoDTO> findByCompletedAndTitleCallback(boolean completed, String title)
    {
        return convertToList(m_todoAppDAL.findByCompletedAndTitle(completed, title), false, m_todoInfoMapper::toTodoInfoDTO);
    }

    private Iterable<TodoInfoDTO> findByCompletedAndTitleContainsCallback(boolean completed, String title)
    {
        return convertToList(m_todoAppDAL.findByCompletedAndTitleContains(completed, title), false, m_todoInfoMapper::toTodoInfoDTO);
    }

    public TodoService(TodoAppDAL todoAppDAL, ITodoInfoMapper todoInfoMapper, ITodoSaveMapper todoSaveMapper)
    {
        m_todoAppDAL = todoAppDAL;
        m_todoInfoMapper = todoInfoMapper;
        m_todoSaveMapper = todoSaveMapper;
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
