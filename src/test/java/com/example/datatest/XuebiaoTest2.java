package com.example.datatest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class XuebiaoTest2 {

	public static void main(String[] args) {
		Comparator<InterTest> comparatord = (val,val2) -> {
			// val 待比较数  ，val2 过来比较的数
			if(val.getDocId()> val2.getDocId()) {
				return 1;// 默认升序，1就是交换
			}else if(val.getDocId() < val2.getDocId()) {
				return -1;
			}
			
			if(val.getNamed().equals("34")) {
				return -1;
			}else if(val2.getNamed().equals("34")) {
				return 1;
			}
			return 0;
			
		};
		
		List<InterTest> inters = new ArrayList<>();
		List<InterTest> inters2 = new ArrayList<>();
		
		XuebiaoTest2 xuebiao = new XuebiaoTest2();
		InterTest inter1 = xuebiao.new InterTest();
		inter1.setDocId(2);
		inter1.setNamed("12");
		InterTest inter2 = xuebiao.new InterTest();
		inter2.setDocId(2);
		inter2.setNamed("34");
		
		InterTest inter3 = xuebiao.new InterTest();
		inter3.setDocId(3);
		inter3.setNamed("56");
		InterTest inter4 = xuebiao.new InterTest();
		inter4.setDocId(4);
		inter4.setNamed("78");
		
		inters.add(inter1);
		inters.add(inter2);
		inters2.add(inter3);
		inters2.add(inter4);
		OuterTest outer1 = xuebiao.new OuterTest();
		outer1.setProId(1);
		inters.sort(comparatord);
		outer1.setInters(inters);
		
		
		OuterTest outer2 = xuebiao.new OuterTest();
		outer2.setProId(3);
		inters2.sort(comparatord);
		outer2.setInters(inters2);
		
		List<OuterTest> result = new ArrayList<>();
		result.add(outer2);
		result.add(outer1);
		System.out.println(result.toString());
		
	}
	@Getter
	@Setter
	@ToString
	class OuterTest{
		private Integer proId;
		private List<InterTest> inters;
	}
	
	 @Getter
	 @Setter
	 @ToString
	 class InterTest{
		 private Integer docId;
		 private String named;
	 }
}
