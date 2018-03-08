package com.itheima.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		//放到域中的属性
		System.out.println(event.getName()+"chuangjian");//放到域中的name
		System.out.println(event.getValue()+"chuangjian");//放到域中的value
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println(event.getName()+"shanchu");//删除域中的name
		System.out.println(event.getValue()+"shanchu");//删除域中的value
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println(event.getName()+"xiugai");//获得修改前域中的name
		System.out.println(event.getValue()+"xiugai");//获得修改前的域中的value
		
	}

}
