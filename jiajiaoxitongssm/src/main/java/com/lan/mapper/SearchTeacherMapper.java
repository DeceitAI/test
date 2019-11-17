package com.lan.mapper;

import com.lan.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 找老师
 */
public interface SearchTeacherMapper {
    /*老师账号*/

    public List<Teacher> zhaoTeacher();
    public List<Teacher> selectTeacher(@Param("t_class")String t_class,@Param("t_kemu")String t_kemu,@Param("t_sex")String t_sex);



}

