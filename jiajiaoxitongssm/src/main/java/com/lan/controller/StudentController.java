package com.lan.controller;

import com.lan.common.ResultData;
import com.lan.model.Student;
import com.lan.service.StudentService;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 学生信息管理
 * @author llq
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    //// 日志记录类
    private static Logger logger = Logger.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;


    /**
     * 完善学生个人信息
     * @param session
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> update(@RequestBody Student student, HttpSession session) {
        Student sessionStudent=(Student)session.getAttribute("sessionStudent");
        String s_account=sessionStudent.getS_account();
        logger.debug("********************"+s_account);
        student.setS_account(s_account);
        Map<String, String> map = new HashMap<>();
        System.out.println( student.getS_name());
        System.out.println( student.getS_account());
        if (StringUtils.isEmpty(student.getS_name())) {
            map.put("type", "error");
            map.put("msg", "姓名不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_age())) {
            map.put("type", "error");
            map.put("msg", "年龄不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_sex())) {
            map.put("type", "error");
            map.put("msg", "性别不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_phone())) {
            map.put("type", "error");
            map.put("msg", "手机号码不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_school())) {
            map.put("type", "error");
            map.put("msg", "学校不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_class())) {
            map.put("type", "error");
            map.put("msg", "年级不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_address())) {
            map.put("type", "error");
            map.put("msg", "地址不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_password())) {
            map.put("type", "error");
            map.put("msg", "密码不能为空!");
            return map;
        }

        //从数据库查找学生用户

        if (studentService.update(student)<=0) {
            map.put("type", "error");
            map.put("msg", "学生信息修改失败！");
            return map;
        }
        map.put("type","success");
        map.put("msg", "学生信息修改成功！");
        return map;
    }
    /**
     * 根据学生账号查询学生个人信息
     */
    @RequestMapping(value = "/findBys_account", method = RequestMethod.GET)
    @ResponseBody
    public Student findBys_account(HttpSession session) {
        Student student=(Student)session.getAttribute("sessionStudent");
        String s_account=student.getS_account();
        logger.debug("---------------------"+s_account);

        // Map<String,String> map = new HashMap<>();
        if(studentService.findBys_account(s_account)!=null){
            ResultData.success(student);
        }
        return student;
    }
}




