package com.controller;
import com.entity.Passengerinfo;
import com.service.IPassengerinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping(value = "/passengerinfo")
public class PassengerinfoController {
    @Autowired
    private IPassengerinfoService passengerinfoService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Passengerinfo>passengerinfos = passengerinfoService.findAll();
        modelAndView.addObject("passengerinfos",passengerinfos);
        modelAndView.setViewName("/WEB-INF/index/passengerList");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Passengerinfo>passengerinfos = passengerinfoService.findById(id);
        Iterator<Passengerinfo> it = passengerinfos.iterator();
        while (it.hasNext()){
            Passengerinfo pa = (Passengerinfo)it.next();
            String adult = pa.getAdult();
            request.getSession().setAttribute("adult",adult);
        }
        modelAndView.addObject("passengerinfos",passengerinfos);
        modelAndView.setViewName("/WEB-INF/index/traininfo");
        return modelAndView;
    }

    @RequestMapping("/findMyself.do")
    public ModelAndView findMyself(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        String loginName = (String) session.getAttribute("loginName");
        Passengerinfo passengerinfo = new Passengerinfo(loginName);
        List<Passengerinfo>passengerinfos = passengerinfoService.findMyself(passengerinfo);
        modelAndView.addObject("passengerinfos",passengerinfos);
        modelAndView.setViewName("/WEB-INF/index/passengerList");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteById.do")
    public String delectById(Integer id){
        passengerinfoService.deleteById(id);
        return "redirect:/passengerinfo/findMyself.do";
    }

    @RequestMapping(value = "/deleteBatch.do",method = RequestMethod.POST)
    public String delectBatch(Integer[] ids){
        System.out.println(ids);
        if(ids!=null){
            passengerinfoService.deleteBatch(ids);
        }
        return "redirect:/passengerinfo/findMyself.do";
    }

    @RequestMapping("/insertOrupdataToJSP.do")
    public String insertOrupdataToJSP(Integer id,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("id",id);
        return "/WEB-INF/index/insertOrupdata";
    }



    @RequestMapping("/loginFileupload.do")
    public String loginFileupload(@RequestParam("headImage1") MultipartFile image, HttpServletRequest request, @Valid Passengerinfo passengerinfo, BindingResult br, Model model){
        if(br.getErrorCount()>0){
            FieldError passengername=br.getFieldError("passengername");
            FieldError idcard=br.getFieldError("idcard");
            if(passengername!=null){
                String passengernamemsg = passengername.getDefaultMessage();
                model.addAttribute("passengernamemsg",passengernamemsg);
            }
            if(idcard!=null){
                String idcardmsg = idcard.getDefaultMessage();
                model.addAttribute("idcardmsg",idcardmsg);
            }
            return   "forward:/passengerinfo/insertOrupdataToJSP.do";
        }
        HttpSession session = request.getSession();
        String loginName = (String) session.getAttribute("loginName");
        passengerinfo.setLoginName(loginName);

        Integer id = (Integer) session.getAttribute("id");
        passengerinfo.setId(id);

        if (!image.isEmpty() && image.getSize() > 0){
            String originalFilename = image.getOriginalFilename();              //获取原始文件名
            String dirPath = request.getServletContext().getRealPath("/upload/");//获得服务器真实路径
            File filePath = new File(dirPath);
            if (!filePath.exists()){                //如果路径不存在，则创建
                filePath.mkdirs();
            }
            String fileName = UUID.randomUUID() + "_" + originalFilename;
            //存入数据库
            String passengerpicture = fileName;
            passengerinfo.setPassengerpicture(passengerpicture);
//            Passengerinfo passengerinfo = new Passengerinfo(id,passengername,idcard,adult,passengerpicture,loginName);

            if(passengerinfo.getId()==null){
                passengerinfoService.insert(passengerinfo);
            }else {
                passengerinfoService.update(passengerinfo);
            }
            try {
                image.transferTo(new File(dirPath + "/" + fileName));

                System.out.println(dirPath + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return   "forward:/passengerinfo/findMyself.do";
    }



}
