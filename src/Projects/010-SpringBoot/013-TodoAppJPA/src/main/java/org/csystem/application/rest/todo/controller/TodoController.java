package org.csystem.application.rest.todo.controller;

import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.csystem.application.rest.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {
    private final TodoService m_todoService;

    public TodoController(TodoService todoService)
    {
        m_todoService = todoService;
    }

    @GetMapping("todos/all")
    public List<TodoInfoDTO> findAllTodos()
    {
        return m_todoService.findAllTodos();
    }

    @GetMapping("todos/find/completed")
    public List<TodoInfoDTO> findTodosByCompleted(@RequestParam("comp") boolean completed)
    {
        return m_todoService.findTodosByCompleted(completed);
    }

    @GetMapping("todos/find/title")
    public Iterable<TodoInfoDTO> findTodosByTitle(String title)
    {
        return m_todoService.findTodosByTitle(title);
    }

    @GetMapping("todos/find/title/contains")
    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text)
    {
        return m_todoService.findTodosByTitleContains(text);
    }

    @GetMapping("todos/find/title/completed")
    public Iterable<TodoInfoDTO> findByCompletedAndTitle(@RequestParam(defaultValue = "true") boolean completed, String title)
    {
        return m_todoService.findByCompletedAndTitle(completed, title);
    }

    @GetMapping("todos/find/title/completed/contains")
    public Iterable<TodoInfoDTO> findByCompletedAndTitleContains(@RequestParam(defaultValue = "true") boolean completed, String text)
    {
        return m_todoService.findByCompletedAndTitleContains(completed, text);
    }

    @PostMapping("save")
    public TodoInfoDTO saveTodo(@RequestBody TodoSaveDTO todoSaveDTO)
    {
        return m_todoService.saveTodo(todoSaveDTO);
    }
}
