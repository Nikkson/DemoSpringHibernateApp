package com.example.demospringhibernate.controller;

import com.example.demospringhibernate.model.Todo;
import com.example.demospringhibernate.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/")
    public String listTodos(Model model){
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @GetMapping("/todo/add")
    public String addTodoForm(Model model){
        model.addAttribute("todo", new Todo());
        return "todoEdit";
    }

    @PostMapping("/todo/add")
    public String addTodo(@ModelAttribute Todo todo, Model model){
        todoService.save(todo);
        model.addAttribute("todos" , todoService.findAll());
        return "todos";
    }

    @GetMapping("/todo/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model){
        model.addAttribute("todo", todoService.findById(id));
        return "todoEdit";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable Long id, @ModelAttribute Todo todo, Model model){
        todoService.save(todo);
        //model.addAttribute("todos" , todoService.findAll());
        return "redirect:/";
    }

    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.delete(id);
        return "redirect:/";
    }


    //addTodo get/post
    //editTodo get/post
    //deleteTodo get id
}
