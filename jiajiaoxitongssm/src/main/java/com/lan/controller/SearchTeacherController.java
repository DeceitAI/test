package com.lan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lan.model.Teacher;
import com.lan.service.SearchTeacherService;
import com.lan.util.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class SearchTeacherController {
    private static Logger logger = Logger.getLogger(StudentController.class);
    List<Teacher> listSearch;
    @Autowired
    private SearchTeacherService searchTeacherService;

    @RequestMapping("/search")
    @ResponseBody
    public Map<Object, Object> search(@RequestBody Map<String,Object> m) {


        logger.debug("------------------------------1");
        logger.debug("-------------------------------ajax");


/*WHERE t_teacher.t_account=t_qiwang.t_account and t_qiwang.t_class=#{t_class} and t_qiwang.t_kemu=#{t_kemu} and t_sex=#{t_sex};
*/
        listSearch = searchTeacherService.zhaolaoshi();
        Page page = new Page( (int)m.get("pageIndex"),listSearch.size());
        page.setPageSize((int)m.get("pageSize"));
       /* m.get("pageIndex");
        m.get("pageSize");*/
        logger.debug("-------------------------------ajax"+m.get("pageIndex")+m.get("pageSize")+page.getPageSize()+page.getpageIndex());
       /* int a=page.getPageSize();
        page.getpageIndex();
        System.out.println(a);
        System.out.println("---------------------"+page.getpageIndex());*/
        logger.debug("-------------------------------ajax"+listSearch.size());
        Map<Object, Object> map = new HashMap<Object, Object>();

        page.setTotalCount(listSearch.size());
        page.setTotalPageCount( page.getTotalPageCount());
        int pageSize=page.getPageSize();
        int pageIndex=page.getpageIndex();
        logger.debug("------------------------------1");
        for(int i=(pageIndex-1)*pageSize,j=0;i<pageIndex*pageSize;i++,j++){

            if (i==listSearch.size()) {
                logger.debug("------------------------------111111");
                break;
            }
            Teacher x = listSearch.get(i);
            map.put(i,x);
            logger.debug("------------------------------"+listSearch.size());
        }

        map.put("msg","返回数据成功");

        logger.debug("------------------------------3333");

/*
        if (listSearch.isEmpty()) {
            map.put("msg", "返回数据为空");
        }
        else map.put("msg","返回数据成功");

        logger.debug("------------------------------"+listSearch.size());
        for (int key=0;key<listSearch.size();key++) {
           Teacher x = listSearch.get(key);
            map.put(key,x);
            logger.debug("------------------------------"+key);


        }*/
map.put("page",page);
        return map;
    }




    @RequestMapping("/selectTeacher")
    @ResponseBody
    public  Map<Object, Object> selectTeacher(@RequestBody Map<String,String> m){

        String t_class=m.get("t_class");
        String t_kemu=m.get("t_kemu");
        String t_sex=m.get("t_sex");

        logger.debug("------------------------------"+t_class);
        logger.debug("------------------------------"+t_kemu);
        logger.debug("------------------------------");
        listSearch = searchTeacherService.selectTeacher(t_class,t_kemu,t_sex);
        Map<Object, Object> map = new HashMap<Object, Object>();
        for (int key=0;key<listSearch .size();key++) {
            Teacher x = listSearch .get(key);
            map.put(key,x);
            logger.debug("------------------------------"+key);


        }
        map.put("msg","返回数据成功");
        return map;
    }




}

