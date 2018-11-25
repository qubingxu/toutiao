package com.nowcoder;
import com.nowcoder.model.User;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.dao.VoteDAO;
import com.nowcoder.model.Voteoption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
@Sql("/init-schema.sql")
public class DataTests {
    @Autowired(required = false)
    UserDAO userDAO;

    @Autowired(required = false)
    VoteDAO voteDAO;

    @Test
    public void initData() {
        Random random = new Random();
        for (int i = 0; i < 11; ++i) {
            User user = new User();
            user.setUserName(String.format("USER%d", i));
            user.setPassWord("123");
            userDAO.addUser(user);
            Voteoption voteoption = new Voteoption();
            voteoption.setQuestionName(i+"a");

        }
    }
}
