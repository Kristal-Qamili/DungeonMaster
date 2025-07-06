package org.example.REPO;

import org.example.Entity.Question;
import java.util.Optional;


public interface QuestionREPO {
    Optional<Question> findById(String id);
}

