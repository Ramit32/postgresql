package com.postgresql.quizapp.entitylayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data // helps in reducing boiler plate code like getters setters hashcode etc
public class Question {
    @Id
    //@JsonIgnoreProperties(value = "true")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String difficultylevel;
}

