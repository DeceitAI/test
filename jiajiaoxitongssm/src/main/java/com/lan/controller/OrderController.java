package com.lan.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lan.model.Student;
import com.lan.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeDebug.map;

@Controller
@RequestMapping("/order")

@ResponseBody
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderController {
    private static Logger logger = Logger.getLogger(StudentController.class);
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public Map<Object, Object> studentOrder(){

        List<Student> listOrder;
        logger.debug("------------------------------1");
        listOrder=orderService.StudentOrder();
        logger.debug("------------------------------21");
        Map<Object, Object> map = new HashMap<Object, Object>();
        logger.debug("-----------------------------31");
        for (int key=0;key<listOrder.size();key++) {
            Student x = listOrder.get(key);
            map.put("dataOrder",x);
            logger.debug("------------------------------"+key);


        }

        map("msg","success");

        return map;

    }



}
