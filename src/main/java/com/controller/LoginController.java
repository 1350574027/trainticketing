package com.controller;


import com.entity.Userinfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.service.IUserinfoService;
import com.util.Md5;
import com.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.sql.ResultSetMetaData;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private IUserinfoService userinfoService;

    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public String index(){
        return "redirect:/index.jsp";
    }

    @RequestMapping("/captche")
    public void captche(HttpServletRequest request , HttpServletResponse response){
        int width = 60,height = 60;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        g.setColor(Color.red);
        String randomText = getRandom(4);
        request.getSession().setAttribute("captche", randomText);
        g.drawString(randomText,10,10);
        try{
            OutputStream ios = response.getOutputStream();
            ImageIO.write(bufferedImage,"JPEG",ios);
            ios.flush();;
            ios.close();
        }catch (Exception ex){}
    }

    public String getRandom(int num){
        String s = "";
        Random r = new Random();
        String[] random = {"1","2","3","4","5","6","7","8","9","0"};
        for (int i = 0; i < num; i++){
            s += random[r.nextInt(10)];
        }
        return s;
    }


    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String login(){
        return "/WEB-INF/login/login";
    }

    @RequestMapping(value = "/registe.do" , method = RequestMethod.GET)
    public String registe(){return "/WEB-INF/login/registe";
    }

    @RequestMapping(value = "/logininfo.do",method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo logininfo(@RequestBody HashMap<String,Object> params,HttpServletRequest request){
        ReturnInfo info = new ReturnInfo();
        String loginName = params.get("loginName").toString();
        String loginPassword = params.get("loginPassword").toString();
        String logpad = Md5.md5Password(loginPassword);
        Userinfo userinfo = new Userinfo(loginName,logpad);
        List<Userinfo>userinfos = userinfoService.findNamePassword(userinfo);
        if(userinfos.isEmpty()){
            System.out.println("空");
            info.setInfo("账号或密码错误");
            info.setCode(0);
        }else{
            System.out.println(userinfos);
            info.setInfo("登陆成功");
            if(loginName.equals("admin")){
               info.setCode(2);
            }else {
                info.setCode(1);
            }
            request.getSession().setAttribute("loginName", loginName);
        }
        return info;
    }

    @RequestMapping(value = "/registeinfo.do",method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo registeinfo(@RequestBody HashMap<String,Object> params,HttpServletRequest request){
        String loginName = params.get("loginName").toString();
        String loginPassword = params.get("loginPassword").toString();
        String logpad = Md5.md5Password(loginPassword);
        System.out.println(logpad);
        Userinfo userinfo = new Userinfo(loginName,logpad);
        Boolean b = userinfoService.insertUserinfo(userinfo);
        ReturnInfo info = new ReturnInfo();
        if(b==true){
            info.setInfo("注册成功了");
            info.setCode(1);
            request.getSession().setAttribute("loginName", userinfo.getLoginName());
        }else {
            info.setInfo("这个账号被注册了，换一个吧");
            info.setCode(0);
        }
        return info;
    }

}
