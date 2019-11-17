package com.lan.service.impl;

import com.lan.controller.StudentController;
import com.lan.mapper.SearchTeacherMapper;
import com.lan.model.Teacher;
import com.lan.service.SearchTeacherService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("searchTeacherService")
public class SearchTeacherServiceImpl implements SearchTeacherService {
    private static Logger logger = Logger.getLogger(SearchTeacherServiceImpl.class);
    @Resource

    private SearchTeacherMapper searchTeacherMapper;
    public List<Teacher> zhaolaoshi(){
        return searchTeacherMapper.zhaoTeacher();
    }
    public List<Teacher> selectTeacher(String t_class,String t_kemu,String t_sex){


        logger.debug("11111111111111111111---------"+t_class);
        return searchTeacherMapper.selectTeacher(t_class,t_kemu,t_sex);
    }


}
