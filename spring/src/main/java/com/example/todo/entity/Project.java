package com.example.todo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 255)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String summary;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  /**
   * @PrePersist JPA（Java Persistence API）のアノテーション。エンティティの新規作成処理が行われる前に呼び出される。
   */
  @PrePersist
  private void onCreate() {
    LocalDateTime now = LocalDateTime.now();
    this.setCreatedAt(now);
    this.setUpdatedAt(now);
  }

  /**
   * @PreUpdate JPA（Java Persistence API）のアノテーション。エンティティの更新処理が行われる前に呼び出される。
   */
  @PreUpdate
  private void onUpdate() {
    this.setUpdatedAt(LocalDateTime.now());
  }
}
