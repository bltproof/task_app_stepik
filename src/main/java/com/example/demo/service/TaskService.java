package com.example.demo.service;

import com.example.demo.model.Task;

public interface TaskService {

    Task create(Task task);

    Task getOne(Long id);

    Iterable<Task> getAll();

    Task update(Long id, Task task);

    void delete(Long id);

    void complete(Long id, Task task);
}
