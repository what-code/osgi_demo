package osgi_demo.impl;

import osgi_demo.Hello;

/**
 * Title:HelloImpl.java
 * 
 * Description:HelloImpl.java
 * 
 * Copyright: Copyright (c) 2014-2-18
 * 
 * Company: IZENE Software(Shanghai) Co., Ltd.
 * 
 * @author Shengjie Guo
 * 
 * @version 1.0
 */
public class HelloImpl implements Hello {
	
	private String str;
	
	public HelloImpl(String str){
		this.str = str;
	}

	@Override
	public void sayHello() {
		System.out.println("--impl say-->" + str);
	}

}
