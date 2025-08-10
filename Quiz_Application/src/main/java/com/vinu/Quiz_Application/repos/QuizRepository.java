package com.vinu.Quiz_Application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vinu.Quiz_Application.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // Add custom queries here if needed in future
}
