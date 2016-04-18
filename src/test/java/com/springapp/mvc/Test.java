package com.springapp.mvc;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pc01 on 2016/3/27.
 */
public class Test {


    public static  final String C="C";
    public static  final String V="V";
    public static  final String Usernamez="ZGL";
    public static  final String Usernamed="DZG";
    public static  final  String  P="P";
    public static  final  String  D="D";
    public static  final  String  COMMA=",";
    public static  final  String  ID="100";
    public static  final  String  ID1="101";
    public static  final  String  guize="1,2,4,3";


    public static String createkeytime(String string) throws ParseException {

        SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateformat1.parse(string);
        String format = dateformat1.format(date1);
        return format;

    }

    public static Date convertoDate(String  date) throws ParseException {
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateformat.parse(date);
        return  date1;

    }
    public static String convertoString(Date date){
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        String format = dateformat.format(date);
        return  format;

    }
    public static Date befordate(Date date1) throws ParseException {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        Date endDate = dft.parse(dft.format(calendar.getTime()));
        return endDate;
    }

    public static List<String>  createlistKey(int i) throws ParseException {
        Date date = new Date();
        List<String> strings = new ArrayList<String>();
        for (int j = 0; j < i; j++) {
            date=befordate(date);
            strings.add(convertoString(date));
        }
        return strings;
    }
    public static int converInt(String str){
        try{
            if(str!=null && str.length()>0){
               int i=Integer.parseInt(str);
                return i;
            }

        }catch (NumberFormatException e){
                return 0;
        }
        return 0;
    }
    public static void luoji1() throws ParseException {
        List<Boolean> boos=new ArrayList<Boolean>();
        //三部分组成C V/TIME/USERNAME /GOODID
        List<String> phones=new ArrayList<String>();
        phones.add("123");
        phones.add("1234");
        phones.add("12345");
        HashMap<String, String> stringStringHashMap = getStringStringHashMap();
        guize1(stringStringHashMap,"1",Usernamed);

        for (String phone : phones) {
            boolean b = guize1(stringStringHashMap, "2", phone);
            boos.add(b);
        }
        boolean phonetureOrfalse = phonetureOrfalse(boos);

    }

    private static boolean phonetureOrfalse(List<Boolean> boos) {
        for (Boolean boo : boos) {
            if (boo==false)
            {
                return false;
            }
        }return true;
    }

    private static boolean guize1(HashMap<String, String> stringStringHashMap,String yiersansi,String usernamed) throws ParseException {
        if(guize.contains(yiersansi)){
            int sum=0;
            //穿入多少天
            List<String> strings = createlistKey(30);
            for (String string : strings) {
                //组装key
                String key =V+COMMA+string+COMMA+usernamed+COMMA+P+COMMA+ID1;
                int i =converInt(stringStringHashMap.get(key));
                //System.out.println(key);
                sum+=i;
            }
            if (sum>=5){
                return false;
            }
        }return true;
    }

    @NotNull
    private static HashMap<String, String> getStringStringHashMap() {
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put("C,2016-03-25,ZGL,S,100","1");
        stringStringHashMap.put("V,2016-03-26,DZG,P,101","2");
        stringStringHashMap.put("C,2016-03-22,ZGL,S,100","2");
        stringStringHashMap.put("V,2016-03-26,DZG,P,101","1");
        return stringStringHashMap;
    }

    public static void main(String[] args) throws ParseException {
        luoji1();
    }
}
