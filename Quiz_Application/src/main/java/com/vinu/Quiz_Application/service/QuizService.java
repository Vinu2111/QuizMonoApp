package com.vinu.Quiz_Application.service;

import com.vinu.Quiz_Application.entities.Quiz;
import com.vinu.Quiz_Application.entities.Response;

import java.util.List;

public interface QuizService {

    // Method to create quiz by category, difficulty and number of questions
    Quiz createQuiz(String category, String difficulty, int numQ);

    // Get quiz details by quiz id
    Quiz getQuiz(Long id);

    // Submit quiz responses and get result
    Object submitQuiz(Long id, List<Response> responses);

    // Get quiz score by quiz id
    Object getScore(Long id);
}
