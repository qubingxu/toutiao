package com.nowcoder.controller;

import com.nowcoder.model.OptionProject;
import com.nowcoder.model.Voteoption;
import com.nowcoder.service.OptionService;
import com.nowcoder.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping(value = "/option",method = {RequestMethod.GET, RequestMethod.POST})
public class OptionController {
    @Autowired
    OptionService optionService;

    @Autowired
    VoteService voteService;

    /*@InitBinder public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false)); }*/


    private Voteoption getVoteoption(int id){

        Voteoption vote = voteService.getOptionByid(id);

        return vote;
    }


    /*private List<ViewObject> getNews(int questionId) {
        List<OptionProject> optionList = optionService.getLatestOptions(questionId);

        List<ViewObject> vos = new ArrayList<>();
        for (OptionProject ques : optionList) {
            ViewObject vo = new ViewObject();
            vo.set("ques", ques);
            vos.add(vo);
        }
        return vos;
    }*/


    @RequestMapping(path="/vote",method = {RequestMethod.GET, RequestMethod.POST})
    public String vote(Model model, @RequestParam("votename") String votename, @RequestParam(value = "type",defaultValue = "0") String type, @RequestParam("time") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date date, @RequestParam("option") String[] option /*, @RequestParam("optionB")String optionB, @RequestParam("optionC")String optionC, @RequestParam("optionD")String optionD*/){
        Voteoption voteoption = new Voteoption();
        OptionProject optionProject = new OptionProject();
        voteoption.setQuestionName(votename);
        if("匿名投票".equals(type))
        {
            voteoption.setType(1);
        }
        else {
            voteoption.setType(0);
        }

        voteoption.setTime(date);
        voteoption.setCount(0);
        voteService.addVote(voteoption);
        Voteoption vote = voteService.getOptionByName(votename);
        for (int i = 1; i <= 4; i++) {
            optionProject.setOption(option[i-1].toString());
            optionProject.setOptionId(i);
            optionProject.setQuestionId(vote.getQuestionId());
            optionService.addOption(optionProject);
        }
        return "redirect:/admin";
    }
    @RequestMapping(path="/vote/alert",method = {RequestMethod.GET, RequestMethod.POST})
    public String voteAlert(Model model,@RequestParam("id")int queid, @RequestParam("votename") String votename, @RequestParam(value = "type",defaultValue = "0") String type, @RequestParam("time") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date date, @RequestParam("option") String[] option /*, @RequestParam("optionB")String optionB, @RequestParam("optionC")String optionC, @RequestParam("optionD")String optionD*/){
        Voteoption voteoption = new Voteoption();
        OptionProject optionProject = new OptionProject();
        voteoption.setQuestionName(votename);
        if("匿名投票".equals(type))
        {
            voteoption.setType(1);
        }
        else {
            voteoption.setType(0);
        }

        voteoption.setTime(date);
        voteoption.setQuestionId(queid);
        voteService.updateVote(voteoption);

        for (int i = 1; i <= 4; i++) {
            optionService.updateOption(option[i-1].toString(),queid,i);
        }
        return "redirect:/admin";
    }
    @RequestMapping(value = "/delete",method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(Model model, @RequestParam(name="questionId", required = false)int queid){
        optionService.deleteOption(queid);
        voteService.deleteOption(queid);

        return "redirect:/admin";
    }
    /*@RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.POST})
    public String vote(Model model, @RequestParam(name="questionId", required = false)int queid){
        Voteoption voteoption = voteService.getOptionByid(queid);
        List<ViewObject> vos = getNews(queid);
        OptionProject op = optionService.selectOption(1,queid);
        for (int i = 1; i <= 20; i++){
            System.out.print(op.getOption());
        }
        model.addAttribute("op",op.getOption());
        model.addAttribute("vos", vos);
        model.addAttribute("vote",voteoption);
        return "option";
    }*/
}
