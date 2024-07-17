package com.postgresql.quizapp.servicelayer;

import com.postgresql.quizapp.databaselayer.QuestionDao;
import com.postgresql.quizapp.entitylayer.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }
}
