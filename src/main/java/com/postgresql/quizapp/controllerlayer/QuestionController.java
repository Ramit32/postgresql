package com.postgresql.quizapp.controllerlayer;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.postgresql.quizapp.entitylayer.Question;
import com.postgresql.quizapp.servicelayer.QuestionService;
import org.apache.coyote.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("Create")//CREATE
    public ResponseEntity<String> setAllQuestions(@RequestBody Question question){
            return new ResponseEntity<String>(questionService.setAllQuestions(question), HttpStatus.CREATED);
    }

    @GetMapping("{id}")//READ
    public ResponseEntity<?> getQuestionById(@PathVariable int id){
        Optional<Question> question;
        try{
            question=questionService.questionById(id);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(question,HttpStatus.OK);
    }

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<List<Question>>(questionService.getAllQuestions(),HttpStatus.OK);
    }


    @PostMapping("update")//UPDATE
    public ResponseEntity<?> updateQuestions(@RequestBody Question question){
        try{
            return new ResponseEntity<>(questionService.update(question),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")//DELETE
    public ResponseEntity<String> deleteQuestions(@PathVariable int id){
        try{
            questionService.delete(id);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>("The entity has been deleted successfully",HttpStatus.OK);
    }
}
