package com.tasks.executor.source.controller;

import com.tasks.executor.source.object.Category;
import com.tasks.executor.source.object.Priority;
import com.tasks.executor.source.repository.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/priority")
@RequiredArgsConstructor
public class PriorityController {

    private final PriorityRepository priorityRepository;

    @GetMapping("/all")
    public List<Priority> getAllPriorities() {
        return priorityRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> addPriority(@RequestBody Priority priority) {

        if (priority.getId() == null && priority.getId() == 0) {
            return new ResponseEntity("Id status mast be null ", HttpStatus.NOT_ACCEPTABLE);
        }

        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title ", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getColor().trim().length() == 0 || priority.getColor() == null) {
            return new ResponseEntity("Color must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> updatePriority (@RequestBody Priority priority) {
        if (priority.getId() == 0 && priority.getId() == null) {
            return new ResponseEntity("Category title NOT must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle().trim().length() == 0 || priority.getTitle() == null) {
            return new ResponseEntity("Category title must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getColor().trim().length() == 0 || priority.getColor() == null) {
            return new ResponseEntity("Color must be not empty!", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityRepository.save(priority));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> getPriorityByID (@PathVariable Long id) {
        try {
            var priority = priorityRepository.findById(id).get();
            return ResponseEntity.ok(priority);
        } catch (NoSuchElementException e ) {
            return new ResponseEntity("ID " +id +" not found", HttpStatus.NOT_ACCEPTABLE);
        }
     }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePriorityByID (@PathVariable Long id) {
        try {
            priorityRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e ) {
            return new ResponseEntity("ID " +id +" not found", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
