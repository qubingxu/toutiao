package com.nowcoder.dao;

import com.nowcoder.model.OptionProject;
import com.nowcoder.model.User;
import com.nowcoder.model.Voteoption;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OptionDAO {
    String TABLE_NAME = "optionproject";
    String INSERT_FIELDS = " Questionid, Optionid, Options,Count";
    String SELECT_FIELDS = INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{QuestionId},#{OptionId},#{options},#{count})"})
    int addOption(OptionProject optionProject);

    @Update({"update ", TABLE_NAME, " set Count=#{0} where Questionid=#{1} and Optionid=#{2}"})
    void updateCount(int Count,int Questionid,int Optionid);

    @Update({"update ", TABLE_NAME, " set Options=#{0} where Questionid=#{1} and Optionid=#{2}"})
    void updateOption(String Options,int Questionid,int Optionid);


    @Delete({"delete from ", TABLE_NAME, " where Questionid=#{id}"})
    void deleteByQuestionid(int id);

    @Select({"select *", " from ", TABLE_NAME, " where Optionid=#{0} and Questionid=#{1}"})
    OptionProject selectByName(int optionid,int id);

    List<OptionProject> selectByquestionId(@Param("Questionid") int Questionid);
}
