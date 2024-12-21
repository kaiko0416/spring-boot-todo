package com.example.todo.dto.response.tasks;

import java.time.LocalDateTime;
import com.example.todo.entity.Project;
import com.example.todo.entity.Task;
import com.example.todo.enums.TaskPriority;
import lombok.Data;

@Data
public class TaskBaseResponse {
  private Integer id;
  private Project project;

  private String name;

  private TaskPriorityResponse priority;

  private String memo;

  private LocalDateTime deadlineAt;

  private LocalDateTime completedAt;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public TaskBaseResponse(Task task) {
    this.id = task.getId();
    this.project = task.getProject();
    this.name = task.getName();
    this.priority = new TaskPriorityResponse(task.getPriority());
    this.memo = task.getMemo();
    this.deadlineAt = task.getDeadlineAt();
    this.completedAt = task.getCompletedAt();
    this.createdAt = task.getCreatedAt();
    this.updatedAt = task.getUpdatedAt();


  }



}
