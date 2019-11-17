package com.lan.service.impl;

import com.lan.mapper.OrderMapper;
import com.lan.model.Order;
import com.lan.model.Student;
import com.lan.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("OrderSercice")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<Student> StudentOrder() {

        return orderMapper.StudentOrder();
    }
}
