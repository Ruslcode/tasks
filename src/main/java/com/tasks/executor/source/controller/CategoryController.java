package com.tasks.executor.source.controller;

import com.tasks.executor.source.object.Category;
import com.tasks.executor.source.object.Priority;
import com.tasks.executor.source.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> test () {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category addPriority(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

}
