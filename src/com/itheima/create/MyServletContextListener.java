package com.itheima.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{
   //监听context域对象的创建
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//就是被监听的对象---servletContext
		//ServletContext servletContext = sce.getServletContext();
		//getSource就是被监听的对象  是通用方法
		//ServletContext source = (ServletContext) sce.getSource();
		//System.out.println("context创建了。。");
		/**作业
		 * a、初始化的工作：初始化对象 初始化数据 ---- 加载数据库驱动  连接池的初始化
		 *  b、加载一些初始化的配置文件 --- spring的配置文件
		 *  c、任务调度----定时器----Timer/TimerTask
		 */
		//开启一个计息调度---每天晚上12计息一次
		Timer timer=new Timer();
		//task:任务   firstTime:第一次执行时间  period：间隔执行时间
		//timer.scheduleAtFixedRate(task, firstTime, period);
		/*timer.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				System.out.println("银行计息。。。。。");
				
			}
			
		}, new Date(), 5000);*/
		//修改成银行真正计息业务
		//1起始时间：定义成晚上12点
		//2间隔时间：24小时
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss" );
		//String currentTime="2018-03-09 00:00:00";
		String currentTime="2018-03-08 17:31:00";
		Date parse=null;
		try {
			parse = format.parse(currentTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				System.out.println("银行计息。。。。。");
				
			}
			
		}, parse, 24*60*60*1000);
	}
	//监听context域对象的销毁
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context销毁了。。");
		
	}

}
