package com.lzx.comment.dao;

import com.lzx.comment.dataobject.UserDO;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @InterfaceName UserDAO
 * @Author 刘正星
 * @Date 2020/7/12 13:33
 **/
@Mapper
public interface UserDAO {
    /**
     * 查询
     *
     * @return 全部User
     */
   // @Select("SELECT id,user_name as userName,pwd,nick_name as nickName,avatar,gmt_created as gmtCreated,gmt_modified as gmtModified FROM user")
    public List<UserDO> findAll();

    /**插入
     * @param userDO
     * @return 行数
     */
    int add(UserDO userDO);
    /*@Insert("INSERT INTO user (user_name, pwd, nick_name,avatar,gmt_created,gmt_modified) VALUES(#{userName}, #{pwd}, #{nickName}, #{avatar},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(UserDO userDO);
    */

    /**
     * 修改
     *
     * @param userDO
     * @return
     */
   // @Update("UPDATE user set nick_name = #{nickName},gmt_modified = now() where id = #{id} ")
    int update(UserDO userDO);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    //@Delete("delete from user where id=#{id}")
    int delete(@Param("id") long id);

    /**
     * 根据用户名查找
     *
     * @param name
     * @return userdo
     */
    //@Select("select id,user_name as userName,pwd,nick_name as nickName,avatar,gmt_created as gmtCreated,gmt_modified as gmtModified  from user  where user_name=#{userName} limit 1")
    UserDO findByUserName(@Param("userName") String name);

    List<UserDO> query(@Param("keyWord") String keyWord);


    List<UserDO> search(@Param("keyWord")String keyWord,@Param("startTime") LocalDateTime startTime,@Param("endTime") LocalDateTime endTime);

    int batchAdd(@Param("list") List<UserDO> userDOs);

    List<UserDO> findByIds(@Param("ids") List<Long> ids);


}
