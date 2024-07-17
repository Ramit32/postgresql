package com.postgresql.quizapp.databaselayer;

import com.postgresql.quizapp.entitylayer.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<Question, Integer> {
}
