package com.example.datatest.learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final  class LearningX {

	private Integer x;
	private Integer y;
	
	static List<UG> ghghgh = new ArrayList<>();
	static {
		ghghgh.add(new UG(1,0));
		ghghgh.add(new UG(2,1));
		ghghgh.add(new UG(3,1));
		ghghgh.add(new UG(4,2));
		ghghgh.add(new UG(5,2));
		ghghgh.add(new UG(6,4));
		ghghgh.add(new UG(7,5));
		ghghgh.add(new UG(8,5));
	}
	
	public static void main(String[] args) {
		LearningX lx = new LearningX();
		lx.getOrganizationIdList(1).forEach(System.out::println);;
//		
//		BigInteger b1 = new BigInteger("1");
//		BigInteger b2 = new BigInteger("2");
//		BigInteger b3 = new BigInteger("3");
//	
//		List<BigInteger> hhhh = Arrays.asList(b1,b2,b3);
//		BigInteger b4 = new BigInteger("3");
//		System.out.println(hhhh.contains(BigInteger.valueOf(1)));
		
		
	}
	
	public List<Integer> getOrganizationIdList(Integer organizationId) {
	    List<Integer> organizationIdList = new ArrayList<>();
	    organizationIdList.add(organizationId);
	    List<Integer> idList =  ghghgh.stream().filter(hh -> hh.pid.equals(organizationId)).map(t -> t.getId()).collect(Collectors.toList());
	    if(!CollectionUtils.isEmpty(idList)){
	    	idList.stream().forEach(t -> organizationIdList.addAll(this.getOrganizationIdList(t)));
	    }
	    return organizationIdList;
	}

	
    public void fed(LearningX lx) {
    	lx.setX(1);
    	lx.setY(2);
    }
    
    public void gfd(Integer gfgf) {
    	gfgf = 6;
    }
    
    @Getter
    @Setter
    public static class UG{
    	private Integer id;
    	private Integer pid;
    	
    	public UG(Integer id ,Integer pid) {
    		this.id = id;
    		this.pid = pid;
    	}
    }
}
