package com.vinu.Quiz_Application.service;

import com.vinu.Quiz_Application.entities.Question;
import com.vinu.Quiz_Application.entities.QuestionWrapper;
import com.vinu.Quiz_Application.enums.Category;
import com.vinu.Quiz_Application.enums.DifficultyLevel;
import com.vinu.Quiz_Application.exceptions.ResourceNotFoundException;
import com.vinu.Quiz_Application.repos.QuestionRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question existing = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));

        existing.setTitle(updatedQuestion.getTitle());
        existing.setOption1(updatedQuestion.getOption1());
        existing.setOption2(updatedQuestion.getOption2());
        existing.setOption3(updatedQuestion.getOption3());
        existing.setOption4(updatedQuestion.getOption4());
        existing.setCorrectAnswer(updatedQuestion.getRightAnswer());
        existing.setCategory(updatedQuestion.getCategory());
        existing.setDifficulty(updatedQuestion.getDifficulty());

        return questionRepository.save(existing);
    }

    @Override
    public void deleteQuestion(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Question not found with id: " + id);
        }
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
public List<QuestionWrapper> generateQuiz(String category, String difficulty, int numQ) {
    // Fetch questions by category and difficulty
    List<Question> questions = questionRepository.findByCategoryAndDifficulty(
            Category.valueOf(category.toUpperCase()),
            DifficultyLevel.valueOf(difficulty.toUpperCase())
    );

    // Check if enough questions available
    if (questions.size() < numQ) {
        throw new ResourceNotFoundException("Not enough questions for given criteria");
    }

    // Shuffle and select the required number of questions
    Collections.shuffle(questions);
    List<Question> selected = new ArrayList<>(questions.subList(0, numQ));

    // Map selected questions to QuestionWrapper and return
    List<QuestionWrapper> wrappers = new ArrayList<>();
    for (Question q : selected) {
        wrappers.add(new QuestionWrapper(
                q.getId(),
                q.getTitle(),
                q.getOption1(),
                q.getOption2(),
                q.getOption3(),
                q.getOption4(),
                null, // If you want to add answer or explanation here, replace null accordingly
                null
        ));
    }

    return wrappers;
}


    @Override
    public int calculateScore(List<String> answers) {
        List<Question> allQuestions = questionRepository.findAll();
        int score = 0;

        for (int i = 0; i < answers.size() && i < allQuestions.size(); i++) {
            if (answers.get(i).equalsIgnoreCase(allQuestions.get(i).getRightAnswer())) {
                score++;
            }
        }

        return score;
    }

}

