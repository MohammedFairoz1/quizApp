package com.fairoz.quizApp.service;

import com.fairoz.quizApp.Doa.QuestionDoa;
import com.fairoz.quizApp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDoa questionDoa;
    public List<Question> getAllQuestions() {
        return questionDoa.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDoa.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDoa.save(question);
        return "Sucess";
    }
}
