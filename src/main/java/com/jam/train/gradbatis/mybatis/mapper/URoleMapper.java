package com.jam.train.gradbatis.mybatis.mapper;

import com.jam.train.gradbatis.mybatis.domain.URole;

public interface URoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role
     *
     * @mbg.generated
     */
    int insert(URole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role
     *
     * @mbg.generated
     */
    int insertSelective(URole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role
     *
     * @mbg.generated
     */
    URole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(URole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(URole record);
}