package com.nowcoder.dao;

import com.nowcoder.model.OptionProject;
import com.nowcoder.model.Voteoption;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Mapper
public interface VoteDAO {
    String TABLE_NAME = "voteoption";
    String INSERT_FIELDS = " questionName, Type, time,count";
    String SELECT_FIELDS = " questionId, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{questionName},#{type},#{time},#{count})"})
    int addNews(Voteoption vote);

    List<Voteoption> selectByquestionId(@Param("questionId") int questionId);

    List<Voteoption> selectForCount(@Param("questionId") int questionId);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where Questionid=#{id}"})
    Voteoption selectById(int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where questionName=#{name}"})
    Voteoption selectByName(String name);

    @Update({"update ", TABLE_NAME, " set count=#{0} where Questionid=#{1}"})
    void updateCount(int Count,int Questionid);

    @Update({"update ",  TABLE_NAME, "set questionName=#{questionName}, Type=#{type},time=#{time} where Questionid=#{questionId}"})
    void updateVote(Voteoption voteoption);

    @Delete({"delete from ", TABLE_NAME, " where Questionid=#{queid}"})
    void deleteOption(int queid);
}


