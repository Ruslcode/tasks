package com.tasks.executor.source.objects;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category", schema = "task_executor")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "completed_count")
    private Long completedCount;
    @Basic
    @Column(name = "uncompleted_count")
    private Long uncompletedCount;
}
