package com.vinu.Quiz_Application.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinu.Quiz_Application.entities.Question;
import com.vinu.Quiz_Application.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<Object> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @GetMapping
    public ResponseEntity<Object> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(id, question));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Question deleted successfully");
    }

    @GetMapping("/generate")
    public ResponseEntity<Object> generateQuiz(
            @RequestParam String category,
            @RequestParam String difficulty,
            @RequestParam int numQ
    ) {
        return ResponseEntity.ok(questionService.generateQuiz(category, difficulty, numQ));
    }

    @PostMapping("/getScore")
    public ResponseEntity<Object> getScore(@RequestBody List<String> answers) {
        return ResponseEntity.ok(questionService.calculateScore(answers));
    }
}
