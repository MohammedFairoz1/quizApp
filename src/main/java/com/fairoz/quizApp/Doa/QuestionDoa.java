package com.fairoz.quizApp.Doa;

import com.fairoz.quizApp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDoa extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);
}
