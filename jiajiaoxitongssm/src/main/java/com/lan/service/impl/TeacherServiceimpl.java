package com.lan.service.impl;

import com.lan.mapper.TeacherMapper;
import com.lan.model.Student;
import com.lan.model.Teacher;
import com.lan.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceimpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    /**
     * 老师登录
     * @param t_account
     * @param t_password
     * @return
     */
    public Teacher login(String t_account, String t_password)
    {
        return teacherMapper.login(t_account,t_password);
    }

    /**
     * 老师注册
     * @param teacher
     * @return
     */
    public int TeacherRegister(Teacher teacher){
        int i=teacherMapper.TeacherRegister(teacher);
        return i;
    }
    /**
     * 根据账号查询老师信息
     */
    public Teacher findByt_account(String t_account){
       return teacherMapper.findByt_account(t_account);
    }

    /**
     * 根据账号修改老师个人信息
     */
    public int update(Teacher teacher){
        return teacherMapper.update(teacher);
    }

    /**
     * 老师图片上传
     */
    public String SaveImage(String image){
        return teacherMapper.SaveImage(image);
    }
}
