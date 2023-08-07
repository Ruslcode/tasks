package com.tasks.executor.source.repository;

import com.tasks.executor.source.object.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
