package com.lan.service;

import com.lan.model.Student;

public interface StudentService {
    /**
     * 学生登录
     * @param s_account
     * @param s_password
     * @return
     */
    public Student login(String s_account,String s_password);

    /**
     * 学生注册
     * @param student
     * @return
     */
    public int register(Student student);

}
