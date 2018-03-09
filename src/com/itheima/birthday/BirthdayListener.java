package com.itheima.birthday;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.mail.MailUtils;



public class BirthdayListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//当web应用启动开启一个任务调度---功能用户生日当天发送邮件
		//开启一个定时器
		Timer timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				//为当前的生日的用户发邮件
				//1获得今天过生日的人
				//获得今天的日期
				SimpleDateFormat format=new SimpleDateFormat("MM-dd");
				String currentDate = format.format(new Date());
				//根据当前时间从数据库查询今天过生日的人
				QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
				String sql="select * from customer where birthday like ?";
				List<Customer> customerList=null;
				try {
					 customerList=runner.query(sql, new BeanListHandler<Customer>(Customer.class), "%"+currentDate);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//03-09
				//2发邮件
				if(customerList!=null&&customerList.size()>0){
					for (Customer customer : customerList) {
						try {
							MailUtils.sendMail(customer.getEmail(), "生日", customer.getRealname()+"生日快乐！");
							System.out.println(customer.getRealname()+"邮件发送完毕！");
						} catch (AddressException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		}, new Date(), 1000*10);//时间开发起始时间是一个固定的时间
		//实际开发中间隔时间是一天（这个时间代表每天什么时候发邮件，而不是给固定一个人发邮件）
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
    
}
