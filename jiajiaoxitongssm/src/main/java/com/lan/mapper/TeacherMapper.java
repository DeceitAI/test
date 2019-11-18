package com.lan.mapper;

import com.lan.model.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * 老师管理模块
 */
public interface TeacherMapper {
    /**
     * 老师登录
     */
    public Teacher login(@Param("t_account") String t_account, @Param("t_password") String t_password);

    /**
     * 老师注册
     */
    public int TeacherRegister(Teacher teacher);

    /**
     * 根据账号查询老师信息
     */
    public Teacher findByt_account(String t_account);

    /**
     * 根据老师账号信息完善
     */
    public int update(Teacher teacher);

    /**
     * 老师图片上传
     */
    public int SaveImage(Teacher teacher);
}
