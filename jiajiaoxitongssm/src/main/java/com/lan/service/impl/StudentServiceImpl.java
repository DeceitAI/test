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
    public Student login(String s_account,String s_password)
    {

         return studentMapper.login(s_account,s_password);

    }


    public int register(Student student){
        return studentMapper.register(student);
    }


}
