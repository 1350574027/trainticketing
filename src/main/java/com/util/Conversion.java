package com.util;

import com.entity.Traininfo;
import com.entity.Trainseat;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class Conversion {
    public int[] tentotwo(Trainseat trainseat, Traininfo traininfo, HttpServletRequest request) {
        String seatid = trainseat.getSeatid();
        Integer seatids = Integer.parseInt(seatid);
        Integer carriagenumber = traininfo.getCarriagenumber();
        request.getSession().setAttribute("carriagenumber",carriagenumber);
        Integer carriagenumpeo = traininfo.getCarriagenumpeo();
        Integer shuzusize = carriagenumber * carriagenumpeo;

        int[] integers = new int[shuzusize];
        String s = Integer.toBinaryString(seatids);
        int num = 0;
        for (int i = s.length(); i > 0 ; i--){
            integers[num++] = (int)s.charAt(i-1) - 48;
        }
        System.out.println(Arrays.toString(integers));
        return integers;
    }
}
