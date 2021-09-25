package org.csystem.application.rest.todo.converter;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoInfoConverter {
    public Todo toTodo(TodoInfoDTO todoInfoDTO)
    {
        var todo = new Todo();

        todo.setTitle(todoInfoDTO.getTitle());
        todo.setText(todoInfoDTO.getText());

        return todo;
    }

    public TodoInfoDTO toTodoInfoDTO(Todo todo)
    {
        var todoInfoDTO = new TodoInfoDTO();

        todoInfoDTO.setId(todo.getId());
        todoInfoDTO.setTitle(todo.getTitle());
        todoInfoDTO.setText(todo.getText());
        todoInfoDTO.setInsertDateTime(todo.getInsertDateTime());
        todoInfoDTO.setLastUpdate(todo.getLastUpdate());
        todoInfoDTO.setCompleted(todo.isCompleted());

        return todoInfoDTO;
    }
}
