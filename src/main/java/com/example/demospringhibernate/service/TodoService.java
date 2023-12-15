package com.example.demospringhibernate.service;

import com.example.demospringhibernate.model.Todo;
import com.example.demospringhibernate.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Todo findById(Long id){
        return todoRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }

    public void delete(long id){
        todoRepository.deleteById(id);
    }
    //save edit delete
}
