package com.lan.mapper;

import com.lan.model.Order;
import com.lan.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    public List<Student> StudentOrder();
}
