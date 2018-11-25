package com.nowcoder.service;

import com.nowcoder.dao.OptionDAO;
import com.nowcoder.model.OptionProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionDAO optionDAO;


    public List<OptionProject> getLatestOptions(int questionId) {
        return optionDAO.selectByquestionId(questionId);
    }

    public void updateCount(int Count, int Questionid, int Optionid){
        optionDAO.updateCount(Count,Questionid,Optionid);
    }

    public void updateOption(String Options,int Quesid ,int Optionid){
        optionDAO.updateOption(Options,Quesid,Optionid);
    }

    public void addOption(OptionProject optionProject){
        optionDAO.addOption(optionProject);
    }

    public void deleteOption(int queid) {
        optionDAO.deleteByQuestionid(queid);
    }

    public OptionProject selectOption(int optionid, int id){
        return optionDAO.selectByName(optionid,id);
    }
}
