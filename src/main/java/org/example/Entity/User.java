
package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String currentQuestionId;

    private int deaths;

    private boolean finished;

    public User() {}

    public User(String username, String currentQuestionId) {
        this.username = username;
        this.currentQuestionId = currentQuestionId;
        this.deaths = 0;
        this.finished = false;
    }

    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getCurrentQuestionId() { return currentQuestionId; }
    public void setCurrentQuestionId(String currentQuestionId) { this.currentQuestionId = currentQuestionId; }

    public int getDeaths() { return deaths; }
    public void setDeaths(int deaths) { this.deaths = deaths; }

    public boolean isFinished() { return finished; }
    public void setFinished(boolean finished) { this.finished = finished; }
}
