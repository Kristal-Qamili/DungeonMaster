package org.example.Service;


import org.example.Entity.Question;
import org.example.REPO.InMemoryQuestionREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImplementation implements QuestionService {

    private final InMemoryQuestionREPO repository;

    @Autowired
    public QuestionServiceImplementation(InMemoryQuestionREPO repository) {
        this.repository = repository;
    }

    @Override
    public Question getQuestionById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Question not found: " + id));
    }

    @Override
    public boolean isDeath(String questionId) {
        return getQuestionById(questionId).isDeath();
    }

    @Override
    public boolean isEnd(String questionId) {
        return getQuestionById(questionId).isEnd();
    }
}

