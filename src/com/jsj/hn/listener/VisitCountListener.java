package com.jsj.hn.listener;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener("持久存取页面访问计数")
public class VisitCountListener implements ServletContextListener {

	public VisitCountListener() {
		super();
	}
	/**
	 * Web应用停止时，容器调用此方法
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//获取ServletContext对象
		ServletContext context=sce.getServletContext();
		//输出应用停止日志信息
		context.log(context.getServletContextName()+"应用停止! ");
		//获得计数器对象
		Integer counter=(Integer)context.getAttribute("count");
		if(counter!=null) {
			try {
				//把计数器的数值写到项目发布目录下的count.txt文件中
				String filepath=context.getRealPath("/")+"count.txt";
				PrintWriter pw= new PrintWriter(filepath);
				pw.println(counter.intValue());
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Web应用初始化时，容器调用此方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//获取ServletContext对象
		ServletContext context=sce.getServletContext();
		//输出应用初始化日志信息
		context.log(context.getServletContextName()+"应用开始初始化！");
		try {
			//从文件中读取计数器的数值
			BufferedReader reader=new BufferedReader(new InputStreamReader(context.getResourceAsStream("/count.txt")));
			String strcount=reader.readLine();
			if(strcount==null || "".equals(strcount)) {
				strcount="0";
			}
			int count=Integer.parseInt(strcount);
			reader.close();
			//把计数器对象保存到Web应用范围
			context.setAttribute("count", count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
