package com.vinu.Quiz_Application.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinu.Quiz_Application.entities.Response;
import com.vinu.Quiz_Application.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<Object> createQuiz(
            @RequestParam String category,
            @RequestParam String difficulty,
            @RequestParam int numQ
    ) {
        return ResponseEntity.ok(quizService.createQuiz(category, difficulty, numQ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getQuiz(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuiz(id));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<Object> submitQuiz(
            @PathVariable Long id,
            @RequestBody List<Response> responses
    ) {
        return ResponseEntity.ok(quizService.submitQuiz(id, responses));
    }

    @GetMapping("/{id}/score")
    public ResponseEntity<Object> getQuizScore(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getScore(id));
    }
}
