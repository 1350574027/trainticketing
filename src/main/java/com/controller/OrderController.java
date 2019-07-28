package com.controller;

import com.entity.ShowResult;
import com.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findByLoginName.do")
    public ModelAndView findByLoginName(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String loginName = (String) request.getSession().getAttribute("loginName");
        List<ShowResult>list = orderService.findByLoginName(loginName);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("/WEB-INF/index/order");
        return modelAndView;
    }

    @RequestMapping("/findAllOrder.do")
    public ModelAndView findAllOrder(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<ShowResult>list = orderService.findAll();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("/WEB-INF/admin/allOrder");
        return modelAndView;
    }
}
