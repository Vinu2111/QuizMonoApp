package com.quizapp.QuizMonoRepo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.QuizMonoRepo.Entity.Quiz;



@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
