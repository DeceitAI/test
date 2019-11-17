package com.lan.model;

import java.util.List;

// `t_account` varchar(20) NOT NULL,
//  `t_password` varchar(20) DEFAULT NULL,
//  `t_name` varchar(20) DEFAULT NULL,
//  `t_age` varchar(20) DEFAULT NULL,
//  `t_sex` varchar(20) DEFAULT NULL,
//  `t_school` varchar(20) DEFAULT NULL,
//  `t_image` varchar(50) DEFAULT NULL,
//  `t_phone` varchar(20) DEFAULT NULL,
//  `t_workaddress` varchar(100) DEFAULT NULL,
//  PRIMARY KEY (`t_account`)
public class Teacher {
    private String t_account;
    private String t_password;
    private String t_name;
    private String t_age;
    private String t_sex;
    private String t_school;
    private String t_image;
    private String t_phone;
    private String t_workaddress;
    //老师期望表
    private List<TeacherHope> teacherHope;
    /*订单表*/
    public List<Student> student;

    public String getT_account() {
        return t_account;
    }

    public void setT_account(String t_account) {
        this.t_account = t_account;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_age() {
        return t_age;
    }

    public void setT_age(String t_age) {
        this.t_age = t_age;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_school() {
        return t_school;
    }

    public void setT_school(String t_school) {
        this.t_school = t_school;
    }

    public String getT_image() {
        return t_image;
    }

    public void setT_image(String t_image) {
        this.t_image = t_image;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_workaddress() {
        return t_workaddress;
    }

    public void setT_workaddress(String t_workaddress) {
        this.t_workaddress = t_workaddress;
    }

    public List<TeacherHope> getTeacherHope() {
        return teacherHope;
    }

    public void setTeacherHope(List<TeacherHope> teacherHope) {
        this.teacherHope = teacherHope;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
