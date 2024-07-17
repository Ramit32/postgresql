package com.postgresql.quizapp.servicelayer;

import com.postgresql.quizapp.databaselayer.QuestionDao;
import com.postgresql.quizapp.entitylayer.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
   private QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }
    public String setAllQuestions(Question question){
        if(questionDao.existsById(question.getId())){
            return "Already exist";
        }else{
            questionDao.save(question);
            return "Added";
        }


    }

    public Question update(Question question) {
        if(questionDao.existsById(question.getId())){
            return questionDao.save(question);
        }else{
            throw new RuntimeException("The question with given id doesn't exist.");
        }
    }

    public void delete(int id) {
        if(questionDao.existsById(id)){
            questionDao.deleteById(id);
        }else{
            throw new RuntimeException("id not found");
        }
    }

    public Optional<Question> questionById(int id) {
        if(questionDao.existsById(id)){
            return questionDao.findById(id);
        }else{
            throw   new RuntimeException("id doesnot exist");
        }
    }
}
