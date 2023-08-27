package com.fairoz.quizApp.service;

import com.fairoz.quizApp.Doa.QuestionDoa;
import com.fairoz.quizApp.dao.QuizDao;
import com.fairoz.quizApp.model.Question;
import com.fairoz.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDoa questionDoa;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions =questionDoa.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Sucess Fairoz", HttpStatus.CREATED);
    }
}
