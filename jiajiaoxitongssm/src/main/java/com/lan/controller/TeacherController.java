package com.lan.controller;

import com.lan.common.ResultData;
import com.lan.model.Teacher;
import com.lan.service.TeacherService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
     * 根据老师cookie账号查询老师个人信息
     */
    @RequestMapping(value = "/FteacherDetail", method = RequestMethod.POST)
    @ResponseBody
    public Teacher FteacherDetail(@RequestBody Teacher teacher ) {
        String t_account=teacher.getT_account();
        System.out.println(t_account);
        logger.debug("---------------------"+t_account);
        Teacher teacher1=teacherService.findByt_account(t_account);
        /*Map<String,String> map = new HashMap<>();*/
        if(teacher1!=null){
            ResultData.success(teacher1);
        }
        return teacher1;
    }

    /**
     * 老师图片上传
     */
    @RequestMapping(value = "/saveImage",method =RequestMethod.POST )
    @ResponseBody
    public Teacher saveImage(HttpSession session,Teacher teacher,
                                         @RequestParam(value = "filename", required = false)	MultipartFile filename
    )throws IOException {
        Teacher sessionTeacher=(Teacher) session.getAttribute("sessionTeacher");
        String t_account=sessionTeacher.getT_account();
        logger.debug("********************"+t_account);
        System.out.println(t_account);
        teacher.setT_account(t_account);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String filename2 = filename.getOriginalFilename();

        if (!filename2.isEmpty()) {
            // FileUtils 可以做文件流的拷贝 和 操作
            FileUtils.copyInputStreamToFile(
                    filename.getInputStream(),
                    new File("D:\\javaeeDaZuoYe\\images",
                            filename.getOriginalFilename()));
            //把图片路径保存到用户信息里面
            resultMap.put("img", "/images/"+filename.getOriginalFilename());
            resultMap.put("t_account", t_account);
            teacherService.SaveImage(teacher);
            resultMap.put("key", "success");
            resultMap.put("teacher",teacher);
            return teacher;
        }else{
            resultMap.put("key", "error");
            return teacher;
        }
    }
}
