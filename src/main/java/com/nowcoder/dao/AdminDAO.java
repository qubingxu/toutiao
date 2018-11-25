package com.nowcoder.dao;

import com.nowcoder.model.Admin;
import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Mapper
public interface AdminDAO {
    String TABLE_NAME = "admin";
    String INSET_FIELDS = " UserName, PassWord,salt ";
    String SELECT_FIELDS = " Adminid, UserName, PassWord, salt ";

    @Insert({"insert into ",TABLE_NAME, "(",INSET_FIELDS,")values (#{name},#{password},#{salt})"})
    int addAdmin(Admin admin);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where Adminid=#{id}"})
    Admin selectById(int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where UserName=#{name}"})
    Admin selectByName(String name);

    @Update({"update ", TABLE_NAME, " set PassWord=#{password},salt=#{salt} where Adminid=#{id}"})
    void updatePassword(Admin admin);

    @Delete({"delete from ", TABLE_NAME, " where Adminid=#{id}"})
    void deleteById(int id);
}
