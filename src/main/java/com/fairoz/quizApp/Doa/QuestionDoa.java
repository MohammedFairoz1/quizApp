package com.fairoz.quizApp.Doa;

import com.fairoz.quizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDoa extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where q.category=:category order by RAND() limit :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);

}
