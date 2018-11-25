package com.nowcoder.dao;

import com.nowcoder.model.AdminLoginTicket;
import com.nowcoder.model.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Mapper
public interface AdminLoginTicketDAO {
    String TABLE_NAME = "adminloginticket";
    String INSERT_FIELDS = " adminid, expired, status, ticket ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{adminId},#{expired},#{status},#{ticket})"})
    int addTicket(AdminLoginTicket ticket);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where ticket=#{ticket}"})
    AdminLoginTicket selectByTicket(String ticket);

    @Update({"update ", TABLE_NAME, " set status=#{status} where ticket=#{ticket}"})
    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);
}
