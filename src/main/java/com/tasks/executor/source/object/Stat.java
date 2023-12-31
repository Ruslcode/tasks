package com.tasks.executor.source.object;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stat", schema = "task_executor")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Stat {
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "completed_total")
    private Long completedTotal;
    @Basic
    @Column(name = "uncompleted_total")
    private Long uncompletedTotal;
}
