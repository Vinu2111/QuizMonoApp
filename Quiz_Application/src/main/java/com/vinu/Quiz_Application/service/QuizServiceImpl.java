package com.vinu.Quiz_Application.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.vinu.Quiz_Application.entities.Question;
import com.vinu.Quiz_Application.entities.Quiz;
import com.vinu.Quiz_Application.entities.Response;
import com.vinu.Quiz_Application.enums.Category;
import com.vinu.Quiz_Application.enums.DifficultyLevel;
import com.vinu.Quiz_Application.exceptions.ResourceNotFoundException;
import com.vinu.Quiz_Application.repos.QuestionRepository;
import com.vinu.Quiz_Application.repos.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Quiz createQuiz(String categoryStr, String difficultyStr, int numQ) {
        Category category = Category.valueOf(categoryStr.toUpperCase());
        DifficultyLevel difficulty = DifficultyLevel.valueOf(difficultyStr.toUpperCase());

        List<Question> questions = questionRepository.findByCategoryAndDifficulty(category, difficulty);

        if (questions.size() < numQ) {
            throw new ResourceNotFoundException("Not enough questions in the database for the quiz.");
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(category + " - " + difficulty + " Quiz");
        quiz.setQuestions(questions.subList(0, numQ));

        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));
    }

   @Override
public Object submitQuiz(Long quizId, List<Response> responses) {
    Quiz quiz = quizRepository.findById(quizId)
            .orElseThrow(() -> new RuntimeException("Quiz not found"));

    int correctCount = 0;
    List<Question> questions = quiz.getQuestions();

    for (Response res : responses) {
        for (Question q : questions) {
            if (q.getId().equals(res.getQuestionId()) &&
                q.getRightAnswer().equalsIgnoreCase(res.getAnswer().trim())) {
                correctCount++;
                break;  // move to next response once matched
            }
        }
    }

    return "Score: " + correctCount + " out of " + questions.size();
}

   @Override
   public Object getScore(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getScore'");
   }


}
