package com.quizapp.QuizMonoRepo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.QuizMonoRepo.Entity.QuestionWrapper;
import com.quizapp.QuizMonoRepo.Entity.Quiz;
import com.quizapp.QuizMonoRepo.Entity.Response;
import com.quizapp.QuizMonoRepo.Service.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public Quiz createQuiz(
            @RequestParam String category,
            @RequestParam String level,
            @RequestParam String title) {
        return quizService.createQuiz(category, level, title);
    }

    @GetMapping("/getQuizByID/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
