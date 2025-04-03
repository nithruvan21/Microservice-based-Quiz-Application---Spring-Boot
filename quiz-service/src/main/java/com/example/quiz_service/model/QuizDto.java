package com.example.quiz_service.model;

public class QuizDto {
    String categoryName;
    Integer numOfQuestions;
    String title;

    
    public QuizDto(String categoryName, Integer numOfQuestions, String title) {
        this.categoryName = categoryName;
        this.numOfQuestions = numOfQuestions;
        this.title = title;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Integer getNumOfQuestions() {
        return numOfQuestions;
    }
    public void setNumOfQuestions(Integer numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
}
