package com.lan.service;


import com.lan.model.Order;
import com.lan.model.Student;

import java.util.List;

public interface OrderService {
    public List<Student> StudentOrder();

    /**
     * 保存订单信息
     */
    public void SaveOrder(Order order);
}
