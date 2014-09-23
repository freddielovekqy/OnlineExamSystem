package com.augmentum.oes.model;

import java.util.Date;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.augmentum.oes.util.DateUtil;
import com.augmentum.oes.util.json.DateSerializer;

public class Question {

    private int id;

    @NotNull(message = "Question Title is required")
    @NotEmpty(message = "Question Title is required")
    private String questionTitle;

    @NotNull(message = "Option A is required")
    @NotEmpty(message = "Option A is required")
    private String optionA;

    @NotNull(message = "Option B is required")
    @NotEmpty(message = "Option B is required")
    private String optionB;

    @NotNull(message = "Option C is required")
    @NotEmpty(message = "Option C is required")
    private String optionC;

    @NotNull(message = "Option D is required")
    @NotEmpty(message = "Option D is required")
    private String optionD;

    @NotNull(message = "Answer is required")
    @NotEmpty(message = "Answer is required")
    private String answer;

    private int userId;
    private int isDeleted;
    private Date createTime = new Date();
    private Date lastUpdateTime;

    public Question() {
        super();
    }

    public Question(int id, String questionTitle, String optionA, String optionB, String optionC, String optionD,
            String answer) {
        super();
        this.id = id;
        this.questionTitle = questionTitle;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
    }

    public Question(String questionTitle, String optionA, String optionB, String optionC, String optionD,
            String answer) {
        super();
        this.questionTitle = questionTitle;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestionId() {
        String questionNumber = String.format("%05d", id);
        questionNumber = "Q" + questionNumber;
        return questionNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCorrectAnswer() {
        if ("A".equals(answer)) {
            return optionA;
        } else if ("B".equals(answer)) {
            return optionB;
        } else if ("C".equals(answer)) {
            return optionC;
        } else {
            return optionD;
        }
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public java.sql.Timestamp getCreateTime() {
        return new java.sql.Timestamp(createTime.getTime());
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonSerialize(using = DateSerializer.class)
    public Date getLastUpdateTime() {

        return lastUpdateTime;
    }

    public String getUpdateTime() {
        return DateUtil.getDate(lastUpdateTime);
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Question) {
            Question q = (Question) object;
            if (q.getId() == id && q.getQuestionTitle().equals(questionTitle) && q.getAnswer().equals(answer) &&
                    q.getOptionA().equals(optionA) && q.getOptionB().equals(optionB) && q.getOptionC().equals(optionC) && q.getOptionD().equals(optionD)) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

}
