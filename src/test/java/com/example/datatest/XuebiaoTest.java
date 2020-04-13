package com.example.datatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import com.example.datatest.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author xuebiao
 * @Date 2020/3/19 10:57
 * @Description:
 **/
public class XuebiaoTest {


	public static  void main(String[] args){
    	
//        int sss = 100;
//
//        XuebiaoTest t = new XuebiaoTest();
//        List<String> hhh = new ArrayList<>();
//        for(int k =0; k<sss;++k){
//            hhh.add("da"+k);
//        }
        
//        List<User> tests = new ArrayList<>();
//        User u = new User("1","ah",34,"ttt");
//        User ut = new User("1","hah",34,"ttt");
//        User u2 = new User("1","bbaaba",34,"ttt2");
//        User u3 = new User("3","dhah3",34,"dadad");
//        User u4 = new User("4","chah4",34,"ttt4");
//        tests.add(u);
//        tests.add(u2);
//        tests.add(u3);
//        tests.add(u4);
//        tests.add(ut);
//    	Comparator<User> comparator = (v1,v2) -> v1.getName().compareTo(v2.getName());
        
    	//Collections.sort(tests, (v1,v2) -> v1.getName().compareTo(v2.getName()));
    	
//    	tests.forEach(System.out::println);
    	
//        tests.removeIf(distinctByKey(User :: getId));
//        
//        tests.stream().map(user -> user.getId()).distinct().collect(Collectors.toList());
//        t.fjfkfk(tests,hhh);
//        tests.stream().forEach(System.out::println);
        
        
//        Map<String,User> yrsy = new HashMap<>();
//        yrsy.put(u.getId(), u);
//        yrsy.put(u2.getId(), u2);
//        yrsy.put(u4.getId(), u4);
//        
//        User jjj = yrsy.get(u3.getId());
//        System.out.println(jjj.getName());
//        StringJoiner sj= new StringJoiner(",","( "," )");// 指定分割符，开头和结尾
//        for(User uss : tests) {
//        	sj.add(uss.getId());
//        }
//        String fgfg = sj.toString();
//        System.out.println(fgfg);
//        XuebiaoTest xt = new XuebiaoTest();
//        xt.editStr(fgfg);
//        System.out.println(fgfg);
        
        

//        Integer start =new Integer(3);
//        System.out.println(start.equals("3"));
//        Integer limit = new Integer(20);
//        List<String> sssdd =  t.gfgfgf(hhh,start,limit);
//        System.out.println(sssdd.size());
//        for(String sf : sssdd){
//            System.out.println(sf);
//        }

        
//    	System.out.println(System.getProperty("user.dir"));
//        List<Test> shsh = Arrays.asList(new Test(null,"wsed"),new Test(2,"lishi"),new Test(4,"tttyu"),new Test(1,"nullgg"));
//        shsh.sort(Comparator.comparing(Test::getId,Comparator.nullsLast(Integer::compareTo)));
//        shsh = shsh.stream().limit(50).collect(Collectors.toList());
//        shsh.stream().forEach(t -> {
//            System.out.println(t.getName());
//        });
    	
//    	Map<Integer,Test> fgfgf = Stream.of(new Test(1,"zhangsan"),new Test(2,"lisi"),new Test(1,"haha")).collect(Collectors.toMap(Test::getId, t->t,(v1,v2)->v2));
//    	fgfgf.forEach((k,v) -> System.out.println("key:"+k+"value"+v));
        
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//      String ymd = formatter.format(LocalDateTime.now());
//      
//      System.out.println(ymd);
//        List<String> hfhfh = Arrays.asList("123,345".split(","));
//        System.out.println(hfhfh.contains("123"));
    	
//    	int  k = companyListReq.lastIndexOf(",");
//    	StringBuffer sb = new StringBuffer(companyListReq);
//    	String jj = sb.deleteCharAt(k).toString();
//    	System.out.println(jj);
    	
//    	 String html = "<html><body><p>Hello HTML</p></body></html>";
//    	String  utrl = "https://www.liaoxuefeng.com/wiki/1022910821149312/1023027697415616";
//         Document doc;
//		try {
//			doc = Jsoup.parse(new URL(utrl),10000);
//			  Elements as= doc.getElementsByTag("span");
//		         for (Element e : as) {
//		             System.out.println(e.text());
//		         }
//		} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//    	try (SqlExecutor executor = new SqlExecutor("jdbc:h2:tcp://localhost/C:/xuebiao/h2db/test", "sa", "123456")) {
			// raw query:
//			List<List<Object>> results = executor.select("SELECT * FROM USER WHERE ID = ?",1);
//			results.forEach(row -> {
//				System.out.println(String.join(", ", row.stream().map(String::valueOf).toArray(String[]::new)));
//			});
			//executor.insert("INSERT INTO USER VALUES(?,?,?,?)","7", "ZHANGSAN","50","ZHNAG@TT.com");
			// update:
			//executor.update("UPDATE USER  SET score = 99 WHERE id = ?", 1);
			// delete:
//			executor.deleteById("user", 7);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
       
    }
    
    private static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
    
    public static String toJSONString(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
    private void editStr(String ssss) {
    	ssss = ssss+"edit";
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
     
     private void fjfkfk(List<User> tests,List<String> hhh){
    	 for(User test : tests) {
    		 for(String dd : hhh) {
    			 if(String.valueOf(test.getId()).equals(dd)) {
    				 test.setName("gai12345");
    				 break;
    			 }
    		 }
    	 }
    	// return tests;
     }
}
