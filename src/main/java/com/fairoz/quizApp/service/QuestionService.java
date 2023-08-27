package com.fairoz.quizApp.service;

import com.fairoz.quizApp.Doa.QuestionDoa;
import com.fairoz.quizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDoa questionDoa;
    public ResponseEntity<List<Question>> getAllQuestions() {
       try {
           return new  ResponseEntity<>(questionDoa.findAll(), HttpStatus.OK);
       }catch (Exception e){
        e.printStackTrace();
    }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        return new ResponseEntity<>(questionDoa.findByCategory(category), HttpStatus.OK) ;
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDoa.save(question);
        return new ResponseEntity<>("Sucess", HttpStatus.OK);
    }
}
