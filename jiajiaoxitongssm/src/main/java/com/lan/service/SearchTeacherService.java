package com.lan.service;

import com.lan.model.Teacher;

import java.util.List;

public interface SearchTeacherService {

    public List<Teacher> zhaolaoshi();
    public List<Teacher> selectTeacher(String t_class,String t_kemu,String t_sex);
}
