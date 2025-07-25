package org.example.Entity;

import jakarta.persistence.*;


public class Choice {
    private String id;
    private String label;
    private String text;
    private String nextQuestionId;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(String nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

    public String getId() {
        return id;
    }

    public Choice(){}
    public Choice(String label, String text, String nextQuestionId) {
        this.label = label;
        this.text = text;
        this.nextQuestionId = nextQuestionId;
    }
}
