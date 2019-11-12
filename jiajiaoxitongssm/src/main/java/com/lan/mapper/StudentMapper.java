package com.lan.mapper;

import com.lan.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 *学生管理模块
 */
public interface StudentMapper {
    /**
     * 学生登录
     */
    public Student login(@Param("s_account") String s_account,@Param("s_password") String s_password);
    /**
     * 学生注册
     */
    public int register(Student student);

    /**
     * 根据学生账号信息完善
     */
    public int update(Student student);

    /**
     * 根据学生账号查询用户个人信息
     */
    public Student findBys_account(String s_account);




}
