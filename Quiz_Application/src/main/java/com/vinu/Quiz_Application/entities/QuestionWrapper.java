package com.vinu.Quiz_Application.entities;


import com.vinu.Quiz_Application.enums.Category;
import com.vinu.Quiz_Application.enums.DifficultyLevel;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionWrapper {

    private Long id;
    private String title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Category category;
    private DifficultyLevel difficulty;
}
