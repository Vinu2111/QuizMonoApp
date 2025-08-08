package com.quizapp.QuizMonoRepo.Entity;

import com.quizapp.QuizMonoRepo.enums.Category;
import com.quizapp.QuizMonoRepo.enums.DifficultyLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionID;

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

    @Enumerated(EnumType.STRING)  // ✅ Required so Hibernate handles this as enum
    private Category category;

    @Enumerated(EnumType.STRING)  // ✅ Required for DifficultyLevel too
    private DifficultyLevel difficultyLevel;
}
