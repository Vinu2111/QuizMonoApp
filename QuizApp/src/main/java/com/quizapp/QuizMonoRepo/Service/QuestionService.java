package com.quizapp.QuizMonoRepo.Service;



import java.util.List;

import org.springframework.stereotype.Service;
import com.quizapp.QuizMonoRepo.Entity.Question;
import com.quizapp.QuizMonoRepo.enums.Category;
import com.quizapp.QuizMonoRepo.Repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	private final QuestionRepository questionRepository;

	public List<Question> getQuestionsByCategory(Category category) {
		
           return questionRepository.findByCategory(category);

    }

    public Question addQuestion(Question question) {
        
        return questionRepository.save(question);
    }
}
