package org.example.Service;

import org.example.Entity.User;


import org.example.Entity.User;
import org.example.REPO.UserREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

    private UserREPO repository;

    @Autowired
    public UserService(UserREPO repository) {
        this.repository = repository;
    }

    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }


    public User getOrCreateUser(String username) {
        return repository.findByUsername(username)
                .orElseGet(() -> {
                    User user = new User(username, "q1");
                    return repository.save(user);
                });
    }
    public void updateProgress(String username, String nextQuestionId, boolean isDeath, boolean isEnd) {
        User user = getOrCreateUser(username);
        user.setCurrentQuestionId(nextQuestionId);
        if (isDeath) {
            user.setDeaths(user.getDeaths() + 1);
        }
        if (isEnd) {
            user.setFinished(true);
        }
        repository.save(user);
    }
    public void resetUser(String username) {
        repository.findByUsername(username).ifPresent(user -> {
            user.setCurrentQuestionId("q1");
            user.setDeaths(0);
            user.setFinished(false);
            repository.save(user);
        });
    }

}
