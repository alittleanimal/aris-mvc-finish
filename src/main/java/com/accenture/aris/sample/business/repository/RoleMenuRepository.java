package com.accenture.aris.sample.business.repository;

import com.accenture.aris.sample.business.entity.RoleMenuEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuRepository {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(RoleMenuEntity key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated
     */
    int insert(RoleMenuEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated
     */
    int insertSelective(RoleMenuEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated
     */
    RoleMenuEntity selectByPrimaryKey(RoleMenuEntity key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RoleMenuEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RoleMenuEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated Mon Oct 16 15:22:50 CST 2017
     */
    List<RoleMenuEntity> selectByEntity(RoleMenuEntity entity);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_menu
     *
     * @mbggenerated Mon Oct 16 15:22:50 CST 2017
     */
    int countByEntity(RoleMenuEntity entity);
}