package com.augmentum.oes.model;

import java.sql.Timestamp;
import java.util.Date;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class Exam {

    private int id;

    @NotNull(message = "Exam Name is required")
    @NotEmpty(message = "Exam Name is required")
    private String examName;
    private String examDescription;
    private int totalScore;

    @Min(value = 1, message = "singleQuestionScore must more than 1")
    private int singleQuestionScore;
    @Min(value = 1, message = "QuestionQuantity must more than 1")
    private int questionQuantity;
    @Min(value = 30, message = "Exam duration must more than 30")
    private int examDuration;
    private Date createTime;
    private int examState;
    private int userId;
    private int examineeCount;
    private int passRate;
    private int averageScore;

    public Exam() {

    }

    public Exam(int id, String examName, String examDescription, int totalScore, int questionQuantity, int examDuration, int examState) {
        this.id = id;
        this.examName = examName;
        this.examDescription = examDescription;
        this.totalScore = totalScore;
        this.questionQuantity = questionQuantity;
        this.examDuration = examDuration;
        this.examState = examState;
    }

    public Exam(String examName, String examDescription, int singleQuestionScore, int questionQuantity, int totalScore, int examDuration) {
        this.examName = examName;
        this.examDescription = examDescription;
        this.singleQuestionScore = singleQuestionScore;
        this.questionQuantity = questionQuantity;
        this.totalScore = totalScore;
        this.examDuration = examDuration;
    }

    public Exam(int id, String examName, String examDescription, int totalScore, int singleQuestionScore,
            int questionQuantity, int examDuration, int examState, int userId,
            int examineeCount, int passRate, int averageScore) {
        super();
        this.id = id;
        this.examName = examName;
        this.examDescription = examDescription;
        this.totalScore = totalScore;
        this.singleQuestionScore = singleQuestionScore;
        this.questionQuantity = questionQuantity;
        this.examDuration = examDuration;
        this.examState = examState;
        this.userId = userId;
        this.examineeCount = examineeCount;
        this.passRate = passRate;
        this.averageScore = averageScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getSingleQuestionScore() {
        return singleQuestionScore;
    }

    public void setSingleQuestionScore(int singleQuestionScore) {
        this.singleQuestionScore = singleQuestionScore;
    }

    public int getQuestionQuantity() {
        return questionQuantity;
    }

    public void setQuestionQuantity(int questionQuantity) {
        this.questionQuantity = questionQuantity;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public Timestamp getCreateTime() {
        return new Timestamp(createTime.getTime());
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getExamState() {
        return examState;
    }

    public void setExamState(int examState) {
        this.examState = examState;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamineeCount() {
        return examineeCount;
    }

    public void setExamineeCount(int examineeCount) {
        this.examineeCount = examineeCount;
    }

    public int getPassRate() {
        return passRate;
    }

    public void setPassRate(int passRate) {
        this.passRate = passRate;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }
}
