package com.example.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/todos")
public class TodoController {
    private List<Todo> todos = new ArrayList<>();
    private int idCounter = 1;

    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping
    public Todo addTodo(@RequestBody TodoRequest request) {
        Todo newTodo = new Todo(idCounter++, request.getTitle(), false);
        todos.add(newTodo);
        return newTodo;
    }


    @PutMapping("/{id}")
    public String markDone(@PathVariable int id) {
        for(Todo t: todos) {
            if(t.getId() == id) {
                t.setCompleted(true);
                return "Todo marked as a completed";
            }
        }
        return "Todo not found";
    }


    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        todos.removeIf(t -> t.getId() == id);
        return "Todo deleted";
    }
}