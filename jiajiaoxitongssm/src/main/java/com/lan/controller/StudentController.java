package com.lan.controller;

import com.lan.model.Student;
import com.lan.service.StudentService;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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




    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam String s_account, @RequestParam String s_password, HttpServletRequest request) {

        //s_account="201710098166";
     //   s_password="123456";
        Student student = studentService.login(s_account, s_password);
        Map<String, Object> map = new HashMap<>();
        if (student == null)
        {
            map.put("result", "登录失败");
        }
        else if (student.getS_account()!=null&&student.getS_password()!=null)
        {
            map.put("result", "ok");
            map.put("student", student);
            request.getSession().setAttribute("student", student);
        }

        return map;
    }

}




