package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Questions")
public class Question {
    @Id
    private String id;
     @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Choice> choices = new ArrayList<>();
    @Column(nullable = false)
    private boolean isEnd = true;
    @Column(nullable = false)
    private boolean isDeath = true;


    public Question(){
}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public Question(String id, String text, List<Choice> choices, boolean isEnd,boolean isDeath) {
    this.id=id;
        this.text = text;
        this.choices = choices;
        this.isEnd = isEnd;
        this.isDeath=isDeath;
    }
    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isDeath() {
        return "death".equals(id) || (isEnd && (choices == null || choices.isEmpty()));
    }

}

