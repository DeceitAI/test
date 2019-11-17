package com.lan.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Student implements Serializable {
    /**
     CREATE TABLE `t_student` (
     `s_account` varchar(20) NOT NULL,
     `s_password` varchar(20) DEFAULT NULL,
     `s_name` varchar(20) DEFAULT NULL,
     `s_sex` varchar(20) DEFAULT NULL,
     `s_age` varchar(20) DEFAULT NULL,
     `s_school` varchar(20) DEFAULT NULL,
     `s_address` varchar(100) DEFAULT NULL,
     `s_class` varchar(20) DEFAULT NULL,
     `s_phone` varchar(20) DEFAULT NULL,
     `s_image` varchar(50) DEFAULT NULL,
     PRIMARY KEY (`s_account`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8
     */
    private String s_account;
    private String s_password;
    private String s_name;
    private String s_sex;
    private String s_age;
    private String s_school;
    private String s_address;
    private String s_class;
    private String s_phone;
    private String s_image;
    //订单表
    private List<Order> order;


    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public String getS_account() {
        return s_account;
    }

    public void setS_account(String s_account) {
        this.s_account = s_account;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_age() {
        return s_age;
    }

    public void setS_age(String s_age) {
        this.s_age = s_age;
    }

    public String getS_school() {
        return s_school;
    }

    public void setS_school(String s_school) {
        this.s_school = s_school;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_image() {
        return s_image;
    }

    public void setS_image(String s_image) {
        this.s_image = s_image;
    }
}
