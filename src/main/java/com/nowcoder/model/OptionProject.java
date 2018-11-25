package com.nowcoder.model;

public class OptionProject {
    private int QuestionId;
    private int OptionId;
    private int count;
    private String options;




    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
    }

    public int getOptionId() {
        return OptionId;
    }

    public void setOptionId(int optionId) {
        OptionId = optionId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getOption() {
        return options;
    }

    public void setOption(String option) {
        this.options = option;
    }

}
