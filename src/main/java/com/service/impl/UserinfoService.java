package com.service.impl;


import com.dao.UserinfoMapper;
import com.entity.Userinfo;
import com.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class UserinfoService implements IUserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public List<Userinfo>findAll(){
        List<Userinfo>userinfos = userinfoMapper.findAll();
        return userinfos;
    }

    @Override
    public List<Userinfo>findNamePassword(Userinfo userinfo){
        List<Userinfo>userinfos = userinfoMapper.findNamePassword(userinfo);
        return userinfos;
    }

    @Override
    public Boolean insertUserinfo(Userinfo userinfo){
        try{
            userinfoMapper.insertUserinfo(userinfo);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void deleteByLoginName(String loginName){userinfoMapper.deleteByLoginName(loginName);}

    @Override
    public void updateLoginPassword(Userinfo userinfo){userinfoMapper.updateLoginPassword(userinfo);}


}
