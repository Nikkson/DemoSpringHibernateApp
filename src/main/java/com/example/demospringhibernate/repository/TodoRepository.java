package com.example.demospringhibernate.repository;

import com.example.demospringhibernate.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
