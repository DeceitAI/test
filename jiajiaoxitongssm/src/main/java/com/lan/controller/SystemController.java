package com.lan.controller;


import com.lan.model.Student;
import com.lan.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统主页控制器
 */

@RequestMapping("/system")
@Controller
public class SystemController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    /**
     *登录表单提交
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
        request.getSession().setAttribute("student", student);
        map.put("type","success");

        return map;
    }
}
