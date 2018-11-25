package com.nowcoder.dao;

import com.nowcoder.model.People;
import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Mapper
public interface PeopleDAO {
    String TABLE_NAME = "people";
    String INSET_FIELDS = " Questionid,Optionid,UserName ";
    String SELECT_FIELDS = " Questionid,Optionid,UserName ";

    @Insert({"insert into ",TABLE_NAME, "(",INSET_FIELDS,")values (#{questionId},#{optionId},#{userName})"})
    public void addPeople(People people);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where Questionid=#{0} and Oprionid=#{1}"})
    People selectById(int Questionid,int Oprionid);


    @Delete({"delete from ", TABLE_NAME, " where Questionid=#{id}"})
    void deleteById(int id);
}
