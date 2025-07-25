package org.example.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
public class Question {
    private String id;
    private String text;
    private List<Choice> choices;
    private boolean isEnd ;
    private boolean isDeath ;


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
            return id != null && id.startsWith("death");

    }
}

