package com.itheima.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener{
    private String id;
    private String name;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 绑定的方法
	 * @param event
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("person被绑定了");
		
	}
	/**
	 * 解绑的方法
	 * @param event
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("person被解绑了");
		
	}
    
}
