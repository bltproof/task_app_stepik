package com.example.demo.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private LocalDate date;
    private String description;
    private boolean done;
    private Long userId;
}
