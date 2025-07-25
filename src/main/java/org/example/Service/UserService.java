package org.example.Service;

import org.example.Entity.User;


import org.example.REPO.UserREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserREPO repository;

    @Autowired
    public UserService(UserREPO repository) {
        this.repository = repository;
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsernameIgnoreCase(username);
    }

    public User getOrCreateUser(String username) {
        return repository.findByUsernameIgnoreCase(username)
                .orElseGet(() -> repository.save(new User(username, "q1")));
    }

@Transactional
    public void updateProgress(String username, String nextQuestionId, boolean isDeath, boolean isEnd) {
        User user = getOrCreateUser(username);
        user.setCurrentQuestionId(nextQuestionId);
    int before = user.getDeaths();
    repository.save(user);
    User afterSave = repository.findByUsernameIgnoreCase(username).orElse(null);
    System.out.println("Deaths before: " + before);
    System.out.println("Deaths after save: " + (afterSave != null ? afterSave.getDeaths() : "null"));


        if (isDeath) {
            user.setDeaths(user.getDeaths() + 1);
        }

        if (isEnd) {
            user.setFinished(true);
        }

        repository.save(user);
    }

    public void resetUser(String username) {
        repository.findByUsernameIgnoreCase(username).ifPresent(user -> {
            user.setCurrentQuestionId("q1");
            user.setDeaths(0);
            user.setFinished(false);
            repository.save(user);
        });
    }
}
