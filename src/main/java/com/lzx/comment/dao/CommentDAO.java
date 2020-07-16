package com.lzx.comment.dao;

import com.lzx.comment.dataobject.CommentDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @InterfaceName CommentDAO
 * @Author 刘正星
 * @Date 2020/7/12 13:35
 **/
@Mapper
public interface CommentDAO {
    /**
     * 查询
     * @return
     */
    //@Select("SELECT id,ref_id as refId,user_id as userId,parent_id as parentId,content,gmt_created as gmtCreated,gmt_modified as gmtModified FROM comment")
    List<CommentDO> findAll();

    /**
     * 插入
     * @param commentDO
     * @return 行数
     */
    /*@Insert("INSERT INTO comment (ref_id,user_id,content,parent_id,gmt_created,gmt_modified) VALUES(#{refId},#{userId},#{content},#{parentId},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(CommentDO commentDO);*/

    int add(CommentDO commentDO);

    /**
     * 更新
     * @param commentDO
     * @return 行数
     */
    //@Update("UPDATE comment set user_id = #{userId},content = #{content},gmt_modified = now() where id =#{id}")
    int update(CommentDO commentDO);

    /**
     * 删除
     * @param id
     * @return 行数
     */
    //@Delete("DELETE from comment where id =#{id}")
    int delete(@Param("id")long id);

    /**
     * 查找
     * @param refId
     * @return List<CommentDO>
     */
    //@Select("SELECT id,ref_id as refId,user_id as userId,parent_id as parentId,content,gmt_created as gmtCreated,gmt_modified as gmtModified FROM comment where ref_id = #{refId}")
    List<CommentDO> findByRefId(@Param("refId")String refId);

    /**
     * 批量插入
     * @param commentDOS
     * @return
     */
    int batchAdd(@Param("list") List<CommentDO> commentDOS);

    /**
     * 批量查询
     * @param ids
     * @return
     */
    List<CommentDO> findByUserIds(@Param("userIds") List<Long> ids);
}
