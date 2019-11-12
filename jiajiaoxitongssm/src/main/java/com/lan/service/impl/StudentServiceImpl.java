package com.lan.service.impl;

import com.lan.mapper.StudentMapper;
import com.lan.model.Student;
import com.lan.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    /**
     * 学生登录
     * @param s_account
     * @param s_password
     * @return
     */
    public Student login(String s_account,String s_password)
    {
         return studentMapper.login(s_account,s_password);
    }

    /**
     * 学生注册
     * @param student
     * @return
     */
    public int register(Student student){
        return studentMapper.register(student);
    }

    /**、
     * 学生信息修改
     * @param student
     * @return
     */
    public int update(Student student){
        return studentMapper.update(student);
    }

    /**
     * 根据学生账号查询学生详细信息
     * @param s_account
     * @return
     */
    public Student findBys_account(String s_account){
        return studentMapper.findBys_account(s_account);
    }


}
