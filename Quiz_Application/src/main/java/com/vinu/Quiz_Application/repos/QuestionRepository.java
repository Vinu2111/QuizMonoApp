package com.vinu.Quiz_Application.repos;

import com.vinu.Quiz_Application.entities.Question;
import com.vinu.Quiz_Application.enums.Category;
import com.vinu.Quiz_Application.enums.DifficultyLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Correct method name matching entity fields 'category' and 'difficulty'
    List<Question> findByCategoryAndDifficulty(Category category, DifficultyLevel difficulty);
}
