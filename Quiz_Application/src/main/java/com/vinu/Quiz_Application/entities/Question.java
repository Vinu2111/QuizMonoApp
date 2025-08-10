package com.vinu.Quiz_Application.entities;


import com.vinu.Quiz_Application.enums.Category;
import com.vinu.Quiz_Application.enums.DifficultyLevel;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Question title cannot be blank")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Option 1 is required")
    private String option1;

    @NotBlank(message = "Option 2 is required")
    private String option2;

    @NotBlank(message = "Option 3 is required")
    private String option3;

    @NotBlank(message = "Option 4 is required")
    private String option4;

    @NotBlank(message = "Correct option is required")
    private String correctOption;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyLevel difficulty;

    @Min(value = 1, message = "Marks must be at least 1")
    private int marks;

    public String getRightAnswer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRightAnswer'");
    }

    public void setCorrectAnswer(String rightAnswer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCorrectAnswer'");
    }
}
