package com.jam.train.gradbatis.mybatis.domain;

import java.util.Date;

public class UUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.nickname
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.pswd
     *
     * @mbg.generated
     */
    private String pswd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.last_login_time
     *
     * @mbg.generated
     */
    private Date lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.status
     *
     * @mbg.generated
     */
    private Long status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.id
     *
     * @return the value of u_user.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.id
     *
     * @param id the value for u_user.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.nickname
     *
     * @return the value of u_user.nickname
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.nickname
     *
     * @param nickname the value for u_user.nickname
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.email
     *
     * @return the value of u_user.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.email
     *
     * @param email the value for u_user.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.pswd
     *
     * @return the value of u_user.pswd
     *
     * @mbg.generated
     */
    public String getPswd() {
        return pswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.pswd
     *
     * @param pswd the value for u_user.pswd
     *
     * @mbg.generated
     */
    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.create_time
     *
     * @return the value of u_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.create_time
     *
     * @param createTime the value for u_user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.last_login_time
     *
     * @return the value of u_user.last_login_time
     *
     * @mbg.generated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.last_login_time
     *
     * @param lastLoginTime the value for u_user.last_login_time
     *
     * @mbg.generated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.status
     *
     * @return the value of u_user.status
     *
     * @mbg.generated
     */
    public Long getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.status
     *
     * @param status the value for u_user.status
     *
     * @mbg.generated
     */
    public void setStatus(Long status) {
        this.status = status;
    }
}