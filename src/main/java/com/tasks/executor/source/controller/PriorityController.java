package com.tasks.executor.source.controller;

import com.tasks.executor.source.object.Priority;
import com.tasks.executor.source.repository.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/priority")
@RequiredArgsConstructor
public class PriorityController {

    private final PriorityRepository priorityRepository;

    @GetMapping("/test")
    public List<Priority> test () {
        return priorityRepository.findAll();
    }
}
