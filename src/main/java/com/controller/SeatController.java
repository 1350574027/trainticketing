package com.controller;

import com.entity.ShowResult;
import com.entity.Traininfo;
import com.entity.Trainseat;
import com.service.IIndexService;
import com.service.IOrderService;
import com.service.ISeatService;
import com.util.Conversion;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping(value = "/seat")
public class SeatController {
    @Autowired
    private ISeatService seatService;
    @Autowired
    private IIndexService indexService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findSeatnum.do")
    public String findSeatnum(HttpServletRequest request){
         Integer seatnum = 0;
         Integer trainstate = (Integer) request.getSession().getAttribute("trainstate");
         List<String> trainid = indexService.findStateid(trainstate);
         String id = trainid.get(0);
            Traininfo traininfo = seatService.findTraininfo(id);
            Trainseat trainseats = seatService.findtrainseat(trainstate);
         Conversion conversion =new Conversion();
         int[] seat = conversion.tentotwo(trainseats,traininfo,request);
         request.getSession().setAttribute("seat",seat);
         for(int i = 0;i<seat.length;i++){
             if(seat[i]==0){
                 seatnum++;
             }
         }
         int state = (int)request.getSession().getAttribute("trainstate");
         String ss = "needmoney"+state;
         Float money = (Float) request.getSession().getAttribute(ss);
         String adult = (String)request.getSession().getAttribute("adult");
         if(adult.equals("儿童")){
             money = money/2;
         }
         if(adult.equals("学生")){
             money = money*(float)0.7;
         }
         request.getSession().setAttribute("money",money);
         request.getSession().setAttribute("seatnum",seatnum);
         return "/WEB-INF/index/selectSeat";
    }

    @RequestMapping("/buyticket.do")
    public ModelAndView buyticket(String selectseat,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        int[] seat = (int[]) request.getSession().getAttribute("seat");
        Integer carriagenumber = (Integer) request.getSession().getAttribute("carriagenumber");
        System.out.println("车厢数量="+carriagenumber);
        Integer i = Integer.parseInt(selectseat);
        int size = seat.length;
        Integer carpeo = size/carriagenumber;
        int line = size/5;
        int num = 0;
        int state = 0;
        int[] seats = seat.clone();
        for(int j=0;j<line;j++){
            num=j*5;
            if(seat[num+i]==0){
                seat[num+i]=1;
                state = num+i;
                System.out.println("到了");
                break;
            }
        }
        if(Arrays.toString(seats).equals(Arrays.toString(seat))){
            for(int x=0;x<size;x++){
                if(seat[x]==0){
                    seat[x]=1;
                    state=x;
                    System.out.println("这里");
                    break;
                }
            }
        }
        System.out.println("下标为："+state);
        System.out.println(Arrays.toString(seats));
        System.out.println(Arrays.toString(seat));
        StringBuilder sb = new StringBuilder();
        for(int y = size-1;y>=0;y--){
            sb.append(seat[y]);
        }
        ShowResult showResult = new ShowResult();

        String a =""+sb;
        System.out.println(a);
        String seatresult = Integer.valueOf(a,2).toString();
        System.out.println(seatresult);
        Integer seatsresult = Integer.valueOf(seatresult);
        showResult.setSeatid(seatsresult);
        Integer trainstate = (Integer) request.getSession().getAttribute("trainstate");
        showResult.setTrainstate(trainstate);
        List<String> trainid = indexService.findStateid(trainstate);
        String aa = trainid.get(0);
        showResult.setTrainid(aa);
        float money = (float) request.getSession().getAttribute("money");
        showResult.setNeedmoney1(money);

        Date chufatime = (Date) request.getSession().getAttribute("chufatime1");
        showResult.setChufatime(chufatime);
        Date daodatime = (Date) request.getSession().getAttribute("daodatime");
        showResult.setDaodatime(daodatime);
        String chufa = (String) request.getSession().getAttribute("chufa");
        showResult.setChufa(chufa);
        String daoda = (String) request.getSession().getAttribute("daoda");
        showResult.setDaoda(daoda);
        state = state+1;
        Integer carnum = 0;
        for(int o =1;o<=carriagenumber;o++){
            if(state<=o*carpeo){
                carnum =o;
                break;
            }
        }
        showResult.setCarriageid(carnum);
        state=state-1;
        Integer seatid = state-(carnum-1)*carpeo;
        Integer lines = seatid/5+1;
        showResult.setLiness(lines);
        Integer c = seatid%5;
        String seatss = null;
        if(c==0){
            seatss="A座左靠窗";
        }else if(c==1){
            seatss="B座左中间";
        }else if(c==2){
            seatss="C座左过道";
        }else if(c==3){
            seatss="D座右过道";
        }else if(c==4){
            seatss="F座右靠窗";
        }
        showResult.setSeat(seatss);
        String loginName = (String) request.getSession().getAttribute("loginName");
        showResult.setLoginName(loginName);
        seatService.updateSeatid(showResult);
        System.out.println(showResult.getSeatid()+"---"+showResult.getTrainstate());
        List<ShowResult>showResultList = new ArrayList<ShowResult>();
        System.out.println("login="+showResult.getLoginName());
        System.out.println("chufa="+showResult.getChufa());
        System.out.println("daoda="+showResult.getDaoda());
        System.out.println("chufatime="+showResult.getChufatime());
        System.out.println("daodatime="+showResult.getDaodatime());
        System.out.println("needmoney"+showResult.getNeedmoney1());
        System.out.println("trainid="+showResult.getTrainid());
        System.out.println("state="+showResult.getTrainstate());
        System.out.println("carrageid="+showResult.getCarriageid());
        System.out.println("lines="+showResult.getLiness());
        System.out.println("seat="+showResult.getSeat());
        orderService.insertorder(showResult);
        showResultList.add(showResult);
        modelAndView.addObject("showResult1",showResultList);
        modelAndView.setViewName("/WEB-INF/index/buyticket");
        return modelAndView;


    }


}

