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
    public Teacher login(String t_account, String t_password)
    {
        Teacher teacher=new Teacher();
        teacher=teacherMapper.login(t_account,t_password);
        return teacher;
    }
}
