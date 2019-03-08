package com.liuenci.vblog.dao;

import com.liuenci.vblog.model.vo.UserVo;
import com.liuenci.vblog.model.vo.UserVoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author liuenci
 */
@Component
public interface UserVoMapper {
    /**
     * 计算 User 个数
     * @param example
     * @return
     */
    long countByExample(UserVoExample example);

    /**
     * 通过对象删除 User
     * @param example
     * @return
     */
    int deleteByExample(UserVoExample example);

    /**
     * 通过主键删除 User 对象
     * @param uid
     * @return
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * 插入 User 对象
     * @param record
     * @return
     */
    int insert(UserVo record);

    /**
     * 插入可选字段 User 对象
     * @param record
     * @return
     */
    int insertSelective(UserVo record);

    /**
     * 通过条件查询 User 集合
     * @param example
     * @return
     */
    List<UserVo> selectByExample(UserVoExample example);

    /**
     * 通过主键查询一个对象
     * @param uid
     * @return
     */
    UserVo selectByPrimaryKey(Integer uid);

    /**
     * 更新 User 的部分字段
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") UserVo record, @Param("example") UserVoExample example);

    /**
     * 通过 Example 更新 User 对象
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") UserVo record, @Param("example") UserVoExample example);

    /**
     * 通过主键更新 User 的部分字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserVo record);

    /**
     * 通过主键更新 User
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserVo record);
}