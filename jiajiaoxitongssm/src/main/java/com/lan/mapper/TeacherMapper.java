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
}
