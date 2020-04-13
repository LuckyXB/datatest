package com.example.datatest.learning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final  class LearningX {

	private Integer x;
	private Integer y;
	
	
	public static void main(String[] args) {
		LearningX lx = new LearningX();
		lx.setX(3);
		lx.setY(4);
		lx.fed(lx);
		Integer gfgf = 5;
		lx.gfd(gfgf);
		System.out.println(lx.getX()+" "+lx.getY());
		System.out.println(gfgf);
//		javax.lang.model.AnnotatedConstruct
		
	
	}
	
	
	
    public void fed(LearningX lx) {
    	lx.setX(1);
    	lx.setY(2);
    }
    
    public void gfd(Integer gfgf) {
    	gfgf = 6;
    }
}
