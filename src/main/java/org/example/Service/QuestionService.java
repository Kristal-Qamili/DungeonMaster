package org.example.Service;


import org.example.Entity.Question;

public interface QuestionService {
     Question getQuestionById(String id);
      boolean isDeath(String questionId);
     boolean isEnd(String questionId);
}
