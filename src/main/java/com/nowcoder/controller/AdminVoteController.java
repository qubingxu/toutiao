package com.nowcoder.controller;
import com.nowcoder.model.HostHolder;
import com.nowcoder.model.ViewObject;
import com.nowcoder.model.Voteoption;
import com.nowcoder.service.UserService;
import com.nowcoder.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminVoteController {
    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;

    private List<ViewObject> getNews(int questionId) {
        List<Voteoption> voteList = voteService.getLatestNews(questionId);

        List<ViewObject> vos = new ArrayList<>();
        for (Voteoption votes : voteList) {
            ViewObject vo = new ViewObject();
            vo.set("votes", votes);
            vos.add(vo);
        }
        return vos;
    }
    @RequestMapping(path = { "/admin"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String admin(Model model, @RequestParam(value = "pop",defaultValue = "0") int pop) {
        model.addAttribute("vos", getNews(0));
        model.addAttribute("pop",pop);
        return "admin";
    }
}
