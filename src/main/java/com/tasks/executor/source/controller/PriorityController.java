package com.tasks.executor.source.controller;

import com.tasks.executor.source.object.Priority;
import com.tasks.executor.source.repository.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
@RequiredArgsConstructor
public class PriorityController {

    private final PriorityRepository priorityRepository;

    @GetMapping("/test")
    public List<Priority> test() {
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
        return ResponseEntity.ok(priorityRepository.save(priority));
    }
}
