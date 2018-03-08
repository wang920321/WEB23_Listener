package com.itheima.attribute;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestMyServletContextAttributeListener extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
		//向servletContext域中存数据
		servletContext.setAttribute("name", "tom");
		//向servletContext域中改数据
		servletContext.setAttribute("name", "lucy");
		//删除servletContext域中的数据
		servletContext.removeAttribute("name");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}