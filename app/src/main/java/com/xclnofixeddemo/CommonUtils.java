package com.xclnofixeddemo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Administrator on 2016/4/9.
 */
public class CommonUtils {


    /**
     * 输入日期格式：2013.04.29
     */
    public static List getDays(String a, String b) {
        List<String> days = new ArrayList<String>();// 日期集合
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long end = sdf.parse(b).getTime();
            long begin = sdf.parse(a).getTime();
            while (begin <= end) {
                Date day = new Date();
                day.setTime(begin);
                begin += 3600 * 24 * 1000;
                days.add(sdf.format(day));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return days;
    }







   public static LinkedList<String> getDayLables(){
       LinkedList<String> labels = new LinkedList<String>();
       labels.add("00");
       labels.add("04");
       labels.add("08");
       labels.add("12");
       labels.add("16");
       labels.add("20");
       labels.add("24");
       return labels;
   }






}
