package com.controller;

import com.entity.SelectTrain;
import com.entity.ShowResult;
import com.entity.Station;
import com.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;


@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private IIndexService indexService;

    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public String login(){
        return  "/WEB-INF/index/index";
    }

    @RequestMapping("/findStation.do")
    public ModelAndView findStation(SelectTrain selectTrain, HttpServletRequest request){
        request.getSession().setAttribute("chufatime",selectTrain.getTime());
        request.getSession().setAttribute("chufa",selectTrain.getChufa());
        request.getSession().setAttribute("daoda",selectTrain.getDaoda());

        List<ShowResult>total = new ArrayList<ShowResult>();
        SimpleDateFormat sdate =  new SimpleDateFormat("yyyy-MM-dd");



        String date1 = sdate.format(selectTrain.getTime());
        System.out.println(date1);
        selectTrain.setTimes(date1);
        Station station1 = new Station();
        Station station2 = new Station();
        ModelAndView modelAndView = new ModelAndView();
        List<Station> stations = indexService.findTrainstate(selectTrain);
        Iterator iterator = stations.iterator();
        while(iterator.hasNext()){ ;
            Integer i = Integer.parseInt((String) iterator.next());
            String chufa = selectTrain.getChufa();
            String daoda = selectTrain.getDaoda();
            station1.setstationname(chufa);
            station1.settrainstate(i);
            station2.setstationname(daoda);
            station2.settrainstate(i);
            List<Station> stations1 = indexService.findid(station1);
            List<Station> stations2 = indexService.findid(station2);
            Iterator iterator1 = stations1.iterator();
            Iterator iterator2 = stations2.iterator();
            while (iterator1.hasNext()){
                Integer x = Integer.valueOf((Integer) iterator1.next()).intValue();
                while (iterator2.hasNext()){
                    Integer y = Integer.valueOf((Integer) iterator2.next()).intValue();
                    if (x<y){
                        ShowResult showResult = new ShowResult();
                        selectTrain.setStates(i);
                        List<Station> stationsture = indexService.findResult(selectTrain);
                        System.out.println(selectTrain.getChufa()+selectTrain.getDaoda()+selectTrain.getStates());
                        List<Station>st1=indexService.findResultchufa(selectTrain);
                        Iterator it1 = st1.iterator();
                        while(it1.hasNext()){
                            Station sta1 = (Station)it1.next();
                            showResult.setChufatime(sta1.getarrivaltime());
                            showResult.setChufa(sta1.getstationname());
                            showResult.setChufamoney(sta1.getprice());
                            showResult.setTrainid(sta1.gettrainid());
                            showResult.setTrainstate(sta1.gettrainstate());
                        }
                        List<Station>st2=indexService.findResultdaoda(selectTrain);
                        Iterator it2 = st2.iterator();
                        while(it2.hasNext()){
                            Station sta2 = (Station)it2.next();
                            showResult.setDaodatime(sta2.getarrivaltime());
                            showResult.setDaoda(sta2.getstationname());
                            showResult.setDaodamoney(sta2.getprice());
                        }
                        List<ShowResult>showResultList =new ArrayList<ShowResult>();
                        showResultList.add(showResult);
                        total.addAll(showResultList);
                        Integer flag = showResult.getTrainstate();
                        String ss = "needmoney" + flag;
                        request.getSession().setAttribute(ss,showResult.getNeedmoney());
                    }
                }
            }
        }



        modelAndView.addObject("total",total);
        modelAndView.setViewName("/WEB-INF/index/selectResult");
        return modelAndView;
    }

    @RequestMapping("/traininfo.do")
    public ModelAndView traininfo(Integer id , HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String chufa = (String) request.getSession().getAttribute("chufa");
        String daoda = (String) request.getSession().getAttribute("daoda");
        request.getSession().setAttribute("trainstate",id);
        System.out.println(chufa+"+"+daoda);
        SelectTrain selectTrain = new SelectTrain();
        selectTrain.setChufa(chufa);
        selectTrain.setDaoda(daoda);
        selectTrain.setStates(id);
        System.out.println(selectTrain.getChufa()+selectTrain.getDaoda()+id);
        List<Station>list1 = indexService.findResultchufa(selectTrain);
        List<Station>list2 = indexService.findResultdaoda(selectTrain);
        Iterator it1 = list1.iterator();
        Iterator it2 = list2.iterator();
        while(it1.hasNext()){
            Station st1 = (Station) it1.next();
            request.getSession().setAttribute("chufatime1",st1.getarrivaltime());
            System.out.println("chufatime="+request.getSession().getAttribute("chufatime1"));
        }
        while(it2.hasNext()){
            Station st2 = (Station) it2.next();
            request.getSession().setAttribute("daodatime",st2.getarrivaltime());
            System.out.println("daodatime="+request.getSession().getAttribute("daodatime"));
        }
        modelAndView.setViewName("/WEB-INF/index/traininfo");

        return modelAndView;
    }

    @RequestMapping("/trainstation.do")
    public ModelAndView trainstation(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Station>stations = new ArrayList<Station>();
        Station station1 = new Station();
        Integer trainstate = (Integer) request.getSession().getAttribute("trainstate");
        System.out.println("trainstate ="+trainstate);
        List<Station>list = indexService.findBystate(trainstate);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            stations.add((Station) iterator.next());
            stations.add(station1);
        }
        modelAndView.addObject("stations",stations);
        modelAndView.setViewName("/WEB-INF/index/trainstation");
        return modelAndView;
    }

    @RequestMapping("/cancellation.do")
    public String cancellation(HttpServletRequest request){
        request.getSession().setAttribute("loginName","");
        return "/WEB-INF/login/login";
    }
}
