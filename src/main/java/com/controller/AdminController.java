package com.controller;

import com.entity.*;
import com.service.IAdminService;
import com.service.IIndexService;
import com.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
//管理员操作
    @Autowired
    private IAdminService adminService;

    //查询所有的列车信息（traininfo表，包括列车号、车厢数、每节车厢载客数）显示在管理员主页上
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Traininfo>list = adminService.findAll();
        modelAndView.addObject("admin",list);
        modelAndView.setViewName("/WEB-INF/admin/adminindex");
        return modelAndView;
    }

    //跳转到添加列车信息的输入界面addTraininfo.jsp
    @RequestMapping("/insert.do")
    public String insert(){
        return "/WEB-INF/admin/addTraininfo";
    }


    @RequestMapping("/insertTraininfo.do")
    public String insertTraininfo(Traininfo traininfo){
        try{
            adminService.insertTraininfo(traininfo);
        }catch (Exception e){
            return "forward:/admin/findAll.do";
        }
        return "forward:/admin/findAll.do";
    }

    @RequestMapping("/setup.do")
    public String setup(String id,HttpServletRequest request){
        Trainseat trainseat = new Trainseat();
        trainseat.setTrainid(id);
        adminService.insertAndGetState(trainseat);
        request.getSession().setAttribute("trainseat",trainseat);
        return "/WEB-INF/admin/addStation";
    }

    @RequestMapping("/cleansession.do")
    public String cleansession(HttpServletRequest request){
        request.getSession().removeAttribute("trainseat");
        return "forward:/admin/findAll.do";
    }

    @RequestMapping(value = "/addStation.do")
    public String addStation (Station station, HttpServletRequest request) throws ParseException {
        Trainseat trainseat = (Trainseat) request.getSession().getAttribute("trainseat");
        station.settrainid(trainseat.getTrainid());
        station.settrainstate(trainseat.getTrainstate());
        String i = request.getParameter("arrivaltime1");
        i=i+":00";
        i=i.replaceAll("[A-Z]+"," ").trim();
        SimpleDateFormat arrtime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date arrivaltime = arrtime.parse(i);
        station.setarrivaltime(arrivaltime);
        System.out.println(station.getarrivaltime());
        if(station.getdeparture()==0){
            station.setdeparture(1);
            station.setterminus(0);
        }else if(station.getdeparture()==1){
            station.setdeparture(0);
            station.setterminus(0);
        }else{
            station.setdeparture(0);
            station.setterminus(1);
        }
        adminService.addStation(station);
        return "/WEB-INF/admin/addStation";
    }

    @RequestMapping("/page.do")
    public ModelAndView showlist(HttpServletRequest request) {
        ModelAndView modelAndView =new ModelAndView();
        int pageIndex = 1;//设置初始的当前页，页面显示的都是第一页
        int pageSize = 4;//设置每一页显示几条数据,用于计算总页数，此处设置的值必须与sql语句的limit最后的数值一样
        PageUtil<Station> pageUtil = new PageUtil<Station>();//初始化工具类
        List<Station> list = new ArrayList<Station>();
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }//对页面上的分页标签传的值,进行获取,也是就点击'上一页或者下一页'传过来的pageindex
        pageUtil.setPageIndex(pageIndex);//保存至工具类
        int number = adminService.pagecount();//调用service层方法计算出总数据量，就是多少条数据.
        pageUtil.setPageNumber(number);//保存至工具类
        pageUtil.setPageSize(pageSize);//保存至工具类
        pageUtil.setPageCount((int) Math.ceil((double) (pageUtil.getPageNumber() / pageUtil.getPageSize())) + 1);//计算出总页数,并封装到工具类
        int index = (pageIndex - 1) * pageSize;//计算出每一页从数据库中第几条数据开始取值，也就是limit后面的第一个数字
        list = adminService.stationlist(index);//调用service层的方法，取得数据库中的值
        pageUtil.setList(list);//保存到工具类中的集合
//        model.addAttribute("pageUtil", pageUtil);//传递到页面，存入值栈中
        modelAndView.addObject("pageUtil",pageUtil);
        modelAndView.setViewName("/WEB-INF/admin/stationPage");
        return modelAndView;//跳转的相关页面
    }
}
