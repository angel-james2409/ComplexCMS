package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.UserLogin;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.Date;


import java.util.List;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
public interface UserLoginJdbi {
    @SqlUpdate("insert into user_login(user_name,user_password,user_type,user_reference,last_password_update) values (:ul,:up,:ut,:ui,:lpu)")
    @GetGeneratedKeys
    int insert(@Bind("ul") String userLogin,@Bind("up") String pass, @Bind("ut") String usertype,@Bind("ui") int cvid, @Bind("lpu") Date lastPasswordUpdate )throws Throwable;

    @SqlUpdate("update user_login set user_password=:ul.password,last_password_update=:lpu where user_name=:uid")
    int update(@BindBean("ul") UserLogin userLogin,@Bind("lpu") Date date,@Bind("uid") String user)throws Throwable;

    @SqlUpdate("delete from user_login where user_name=:uid ")
    int  delete(@Bind("uid") String name)throws Throwable; 

    @SqlQuery("select * from user_login where user_name=:uid")
    @RegisterMapper(UserLoginRowMapper.class)
    UserLogin find (@Bind("uid") String name)throws Throwable;
    
    @SqlQuery("select * from user_login")
    @RegisterMapper (UserLoginRowMapper.class) 
    List<UserLogin> getAll()throws Throwable;
}
