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

    @PostMapping("save")
    public TodoInfoDTO saveTodo(@RequestBody TodoSaveDTO todoSaveDTO)
    {
        return m_todoService.saveTodo(todoSaveDTO);
    }
}
