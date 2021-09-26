package org.csystem.application.rest.todo.converter;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoSaveConverter {
    public Todo toTodo(TodoSaveDTO todoSaveDTO)
    {
        var todo = new Todo();

        todo.title = todoSaveDTO.getTitle();
        todo.text = todoSaveDTO.getText();

        return todo;
    }

    public TodoSaveDTO toTodoSaveDTO(Todo todo)
    {
        var todoSaveDTO = new TodoSaveDTO();

        todoSaveDTO.setTitle(todo.title);
        todoSaveDTO.setText(todo.text);

        return todoSaveDTO;
    }
}
