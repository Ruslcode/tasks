package com.tasks.executor.source.objects;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "task", schema = "task_executor")
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class TaskEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "completed")
    private Integer completed;
    @Basic
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private Priority priorityByPriorityId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryByCategoryId;
}
