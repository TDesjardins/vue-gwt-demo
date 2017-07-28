package com.axellience.vuegwtdemo.client.components.todolist;

import com.axellience.vuegwt.client.component.VueComponent;
import com.axellience.vuegwt.jsr69.component.annotations.Component;
import com.axellience.vuegwt.jsr69.component.annotations.Computed;
import jsinterop.annotations.JsProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple Todo list.
 * Is able to list some todo, mark them as done, remove done todos or all at the same time.
 */
@Component(components = { TodoComponent.class })
public class TodoListComponent extends VueComponent
{
    @JsProperty List<Todo> todos;
    @JsProperty String newTodoText;

    public TodoListComponent()
    {
        this.todos = new LinkedList<>();
        this.newTodoText = "";
    }

    public void addTodo()
    {
        this.todos.add(new Todo(this.newTodoText));
        this.newTodoText = "";
    }

    public void removeTodo(Todo todo)
    {
        this.todos.remove(todo);
    }

    public void clearTodos()
    {
        this.todos.clear();
    }

    public void clearDoneTodos()
    {
        this.todos =
            this.todos.stream().filter(todo -> !todo.isDone()).collect(Collectors.toList());
    }

    /**
     * Will be automatically called by Vue.js to
     * get the value of doneTodos in the template
     * @return The number of todos that are done
     */
    @Computed
    public long getDoneTodos()
    {
        if (this.todos == null)
            return 0;

        return this.todos.stream().filter(Todo::isDone).count();
    }
}
