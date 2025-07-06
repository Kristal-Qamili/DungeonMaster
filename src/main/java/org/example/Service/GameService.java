package org.example.Service;

import org.example.Entity.Choice;
import org.example.Entity.Question;
import org.example.REPO.QuestionREPO;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Question currentQuestion;

    private final QuestionREPO repo;
    private String currentQuestionId = "q1";

    public GameService(QuestionREPO repo) {
        this.repo = repo;
        this.currentQuestion = repo.findById("q1")
                .orElseThrow(() -> new RuntimeException("Starting question not found"));

    }

    public Question getCurrentQuestion() {
        return repo.findById(currentQuestionId).orElseThrow(() -> new RuntimeException("Question not found: " + currentQuestionId));
    }
    public void processChoice(String input) {
        Question current = getCurrentQuestion();
        for (Choice c : current.getChoices()) {
            if (c.getLabel().equalsIgnoreCase(input)) {
                currentQuestionId = c.getNextQuestionId();
                return;
            }
        }
        throw new IllegalArgumentException("Invalid choice.");
    }


    public boolean isGameOver() {
        Question current = getCurrentQuestion();
        return current.isDeath() || current.isEnd();
    }

}
