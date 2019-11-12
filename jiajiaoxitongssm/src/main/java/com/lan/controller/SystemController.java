package com.lan.controller;


import com.lan.common.ResultData;
import com.lan.model.Student;
import com.lan.model.Teacher;
import com.lan.service.StudentService;
import com.lan.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统主页控制器
 */
//@RequestMapping("/system")
@Controller
public class SystemController {
    //// 日志记录类
    private static Logger logger = Logger.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/welcome")
    public String index(){
        return "welcome";
    }

    /**
     * 注销登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/login_out",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        if (true){
            request.getSession().removeAttribute("sessionStudent");
            request.getSession().removeAttribute("sessionTeacher");
            return "redirect:login.html";
        }
        else
        {
            return "false";
        }

    }

    /**
     *学生登录表单提交
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> login(@RequestBody HashMap<String, String> m, HttpServletRequest request){
        String s_account = m.get("s_account");
        String s_password = m.get("s_password");
        System.out.println(s_account+"\t"+s_password);
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(s_account)){
            map.put("type", "error");
            map.put("msg", "账号不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(s_password)){
            map.put("type", "error");
            map.put("msg", "密码不能为空!");
            return map;
        }
        //从数据库查找学生用户
        Student student=studentService.login(s_account,s_password);
        if(student==null){
            map.put("type","error");
            map.put("msg","用户不存在");
            return map;
        }
        //存入session
        request.getSession().setAttribute("sessionStudent", student);

        map.put("type","success");

        return map;
    }
    /**
     *老师登录表单提交
     */
    @RequestMapping(value = "/TeacherLogin",method = RequestMethod.POST)
    @ResponseBody
    public Teacher TeacherLogin(@RequestBody HashMap<String, String> m, HttpServletRequest request){
        String t_account = m.get("t_account");
        String t_password = m.get("t_password");
        System.out.println(t_account+"\t"+t_password);
        //Map<String, String> map = new HashMap<>();
        if (t_account==null){
            ResultData.fail();
        }
        if (t_password==null){
            ResultData.fail();
        }
        //从数据库查找学生用户
        Teacher teacher=teacherService.login(t_account,t_password);
        if(teacher==null){
           ResultData.fail();
        }
            ResultData.success(teacher);
        //存入session
        request.getSession().setAttribute("sessionTeacher", teacher);
        return teacher;
    }
    /**
     * 学生注册
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> register(@RequestBody Student student) {
        String s_account=student.getS_account();
        System.out.println(s_account+"\t");
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(student.getS_account())) {
            map.put("type", "error");
            map.put("msg", "账号不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_password())) {
            map.put("type", "error");
            map.put("msg", "密码不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(student.getS_name())) {
            map.put("type", "error");
            map.put("msg", "姓名不能为空!");
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

        //从数据库查找学生用户

        if (studentService.register(student)<=0){
            map.put("type", "error");
            map.put("msg", "用户注册失败");
        }
        map.put("type", "success");
        map.put("msg", "用户注册成功");
        return map;
    }
    /**
     * 老师注册
     */
    @RequestMapping(value = "/TeacherRegister",method = RequestMethod.POST)
    @ResponseBody
    public HashMap <String,String> TeacherRegister(@RequestBody Teacher teacher){
        String t_account=teacher.getT_account();
        System.out.println(t_account);
        HashMap<String,String> map=new HashMap<>();
        if (StringUtils.isEmpty(teacher.getT_account())) {
            map.put("type", "error");
            map.put("msg", "账号不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(teacher.getT_password())) {
            map.put("type", "error");
            map.put("msg", "密码不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(teacher.getT_name())) {
            map.put("type", "error");
            map.put("msg", "姓名不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(teacher.getT_age())) {
            map.put("type", "error");
            map.put("msg", "年龄不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(teacher.getT_sex())) {
            map.put("type", "error");
            map.put("msg", "性别不能为空!");
            return map;
        }

        //从数据库查找学生用户

        if (teacherService.TeacherRegister(teacher)<=0){
            map.put("type", "error");
            map.put("msg", "用户注册失败");
        }
        map.put("type", "success");
        map.put("msg", "用户注册成功");
        return map;
    }

    /**
     * 登录显示用户名
     */
    @RequestMapping(value = "LoginStudent",method = RequestMethod.POST)
    @ResponseBody
    public String doGet( HttpSession session){
        Student sessionStudent=(Student)session.getAttribute("sessionStudent");
        String s_account=sessionStudent.getS_account();
        logger.debug("********************"+s_account);
        if (s_account!=null){
            ResultData.success(s_account);
        }
        return s_account;
    }
}

