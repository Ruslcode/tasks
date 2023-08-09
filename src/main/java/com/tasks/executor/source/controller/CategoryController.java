package com.tasks.executor.source.controller;

import com.tasks.executor.source.object.Category;
import com.tasks.executor.source.object.Priority;
import com.tasks.executor.source.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addPriority(@RequestBody Category category) {
        if (category.getId() != 0 && category.getId() != null) {
            return new ResponseEntity("Category title must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle().trim().length() == 0 || category.getTitle() == null) {
            return new ResponseEntity("Category title must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        if (category.getId() == 0 && category.getId() == null) {
            return new ResponseEntity("Category title NOT must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle().trim().length() == 0 || category.getTitle() == null) {
            return new ResponseEntity("Category title must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Category> getCategoryByID (@PathVariable Long id) {
        try {
            var category = categoryRepository.findById(id).get();
            return ResponseEntity.ok(category);
        } catch (NoSuchElementException e ) {
            return new ResponseEntity("ID " +id +" not found", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoryByID (@PathVariable Long id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e ) {
            return new ResponseEntity("ID " +id +" not found", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
