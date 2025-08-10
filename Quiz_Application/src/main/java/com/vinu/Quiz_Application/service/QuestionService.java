package com.vinu.Quiz_Application.service;

import java.util.List;
import com.vinu.Quiz_Application.entities.Question;
import com.vinu.Quiz_Application.entities.QuestionWrapper;

public interface QuestionService {
    Question addQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
    List<Question> getAllQuestions();
    List<QuestionWrapper> generateQuiz(String category, String difficulty, int numQ);
    int calculateScore(List<String> answers);
}
