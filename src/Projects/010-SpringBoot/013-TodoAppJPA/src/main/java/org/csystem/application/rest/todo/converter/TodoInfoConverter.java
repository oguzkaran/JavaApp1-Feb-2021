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

        todo.title = todoInfoDTO.getTitle();
        todo.text = todoInfoDTO.getText();

        return todo;
    }

    public TodoInfoDTO toTodoInfoDTO(Todo todo)
    {
        var todoInfoDTO = new TodoInfoDTO();

        todoInfoDTO.setId(todo.id);
        todoInfoDTO.setTitle(todo.title);
        todoInfoDTO.setText(todo.text);
        todoInfoDTO.setInsertDateTime(todo.insertDateTime);
        todoInfoDTO.setLastUpdate(todo.lastUpdate);
        todoInfoDTO.setCompleted(todo.completed);

        return todoInfoDTO;
    }
}
