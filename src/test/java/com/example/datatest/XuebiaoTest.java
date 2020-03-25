package com.example.datatest;

import com.example.datatest.model.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author xuebiao
 * @Date 2020/3/19 10:57
 * @Description:
 **/
public class XuebiaoTest {


    public static  void main(String[] args){

//        int sss = 1000;
//
//        XuebiaoTest t = new XuebiaoTest();
//        List<String> hhh = new ArrayList<>();
//        for(int k =0; k<sss;++k){
//            hhh.add("da"+k);
//        }
//        Integer start =new Integer(3);
//        Integer limit = new Integer(20);
//        List<String> sssdd =  t.gfgfgf(hhh,start,limit);
//        System.out.println(sssdd.size());
//        for(String sf : sssdd){
//            System.out.println(sf);
//        }

        List<Test> shsh = Arrays.asList(new Test(null,"wsed"),new Test(2,"lishi"),new Test(4,"tttyu"),new Test(1,"nullgg"));
        shsh.sort(Comparator.comparing(Test::getId,Comparator.nullsLast(Integer::compareTo)));
        shsh = shsh.stream().limit(50).collect(Collectors.toList());
        shsh.stream().forEach(t -> {
            System.out.println(t.getName());
        });
    }

    /**
     * 得出结论
     * forhaoshi:::4443
     * foreachhaoshi:::4389 √
     * streamhaoshi:::4421
     */
    public static  void test(){
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private  Integer ffyyyy(Integer start,Integer limit){
        start = (start*limit) -limit;
//        limit = start+ limit;

        System.out.println("fffyyy"+start);
        System.out.println("fffyy"+limit);
        return start;
    }

    public  List<String> gfgfgf(List<String> datas,Integer start,Integer limit){
//        ffyyyy(start,limit);
//        start = (start*limit) -limit;
//        limit = start+ limit;
//        System.out.println("inner start===="+start);
//        System.out.println("inner limit ===="+limit);
        return  getSublist(datas,ffyyyy(start,limit),limit);
    }
     public static   List<String> getSublist(List<String> datas ,Integer start,Integer limit){

        System.out.println("start======="+start);
        System.out.println("limit======"+limit);
        return start >= datas.size() ?
                new ArrayList<>() :
                datas.subList(start, Math.min(datas.size(), start + limit));
    }
}
