package com.nowcoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Voteoption {
    private int questionId;
    private String questionName;
    private int type;
    @DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
    private Date time;
    private int count;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
    public Date getTime() {
        return time;
    }
    @DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
    public void setTime(Date time) {
        this.time = time;
    }
}
