package com.lan.service;

import com.lan.model.Teacher;

public interface TeacherService {
    /**
     * 老师登陆
     * @param t_account
     * @param t_password
     * @return
     */
    public Teacher login(String t_account, String t_password);

    /**
     * 老师注册
     * @param teacher
     * @return
     */
    public int TeacherRegister(Teacher teacher);
    /**
     * 根据账号查询老师信息
     */
    public Teacher findByt_account(String t_account);

    /**
     * 根据账号修改老师信息
     */
    public int update(Teacher teacher);

    /**
     * 老师图片上传
     * @param teacher
     * @return
     */
    public int SaveImage(Teacher teacher);
}
