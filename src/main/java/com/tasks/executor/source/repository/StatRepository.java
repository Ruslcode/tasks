package com.tasks.executor.source.repository;

import com.tasks.executor.source.object.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Long> {
}
