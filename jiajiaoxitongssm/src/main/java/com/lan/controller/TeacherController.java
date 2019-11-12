package com.lan.controller;

import com.lan.common.ResultData;
import com.lan.model.Teacher;
import com.lan.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 老师信息管理
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    //// 日志记录类
    private static Logger logger = Logger.getLogger(StudentController.class);
    @Autowired
    private TeacherService teacherService;

    /**
     * 修改老师信息
     * @param teacher
     * @param session
     * @return
     */
    @RequestMapping(value = "/UpdateTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> update(@RequestBody Teacher teacher, HttpSession session) {
        Teacher sessionTeacher=(Teacher) session.getAttribute("sessionTeacher");
        String t_account=sessionTeacher.getT_account();
        logger.debug("********************"+t_account);
        teacher.setT_account(t_account);
        Map<String, String> map = new HashMap<>();
        System.out.println( teacher.getT_name());
        System.out.println( teacher.getT_account());
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
        if (StringUtils.isEmpty(teacher.getT_phone())) {
            map.put("type", "error");
            map.put("msg", "手机号码不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(teacher.getT_school())) {
            map.put("type", "error");
            map.put("msg", "学校不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(teacher.getT_workaddress())) {
            map.put("type", "error");
            map.put("msg", "工作地址不能为空!");
            return map;
        }
        if (StringUtils.isEmpty(teacher.getT_password())) {
            map.put("type", "error");
            map.put("msg", "密码不能为空!");
            return map;
        }

        //从数据库查找老师用户

        if (teacherService.update(teacher)<=0) {
            map.put("type", "error");
            map.put("msg", "老师信息修改失败！");
            return map;
        }
        map.put("type","success");
        map.put("msg", "学生信息修改成功！");
        return map;
    }
    /**
     * 根据老师账号查询老师个人信息
     */
    @RequestMapping(value = "/findByt_account", method = RequestMethod.GET)
    @ResponseBody
    public Teacher findByt_account(HttpSession session) {
        Teacher teacher=(Teacher) session.getAttribute("sessionTeacher");
        String t_account=teacher.getT_account();
        logger.debug("---------------------"+t_account);

        // Map<String,String> map = new HashMap<>();
        if(teacherService.findByt_account(t_account)!=null){
            ResultData.success(teacher);
        }
        return teacher;
    }

    /**
     * 老师图片上传
     */

}
