package com.kosta.filterAndListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener1
 *
 */
@WebListener
public class MyListener1 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener1() {
        System.out.println("MyListener1 implements ServletContextListener ����");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 System.out.println("MyListener1 implements ServletContextListener �Ҹ�");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	 System.out.println("MyListener1 implements ServletContextListener �ʱ�ȭ");
    }
	
}
