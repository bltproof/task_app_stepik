package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository taskRepository,
                           UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    @Override
    public Task create(Task task) {
        task.setUserId(userService.getCurrentUser().getId());
        return taskRepository.save(task);
    }

    @Override
    public Task getOne(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Task> getAll() {
        return taskRepository.findAllByUserId(userService.getCurrentUser().getId());
    }

    @Override
    public Task update(Long id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void complete(Long id, Task task) {
        if (!task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }
}
