package com.nowcoder.dao;

import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " UserName, PassWord,salt ";
    String SELECT_FIELDS = " Userid, UserName, PassWord, salt ";

    @Insert({"insert into ",TABLE_NAME, "(",INSET_FIELDS,")values (#{UserName},#{PassWord},#{salt})"})
    int addUser(User user);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where Userid=#{id}"})
    User selectById(int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where UserName=#{name}"})
    User selectByName(String name);

    @Update({"update ", TABLE_NAME, " set PassWord=#{password},salt=#{salt} where Userid=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ", TABLE_NAME, " where Userid=#{id}"})
    void deleteById(int id);
}
