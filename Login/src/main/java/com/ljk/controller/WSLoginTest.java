package com.ljk.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ljk.service.UserService;
import com.ljk.service.UserServiceImpl;
import com.ljk.yc.User;

import ws.HelloPulish;

import javax.xml.ws.Endpoint;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService(endpointInterface="com.ljk.controller.WSLoginTest",
serviceName="WSLoginTest",
targetNamespace="http://com.ljk.WSLoginTest")
public class WSLoginTest  extends SpringBeanAutowiringSupport {
	private UserService userService=new UserServiceImpl();
	public String wsTest(String username,String password){  //@WebParam(name="password"
		User user1 = new User();
		user1.setUserName(username);
		user1.setPassword(password);
		//User user = userService.login(username, password);
		User user = userService.login(user1.getUserName(),user1.getPassword());
		if (user != null) {
			return "OK";
		} else {
			return "error";
		}
	}
	/*public static void  main(String[] args ){
		Endpoint.publish("http://localhost:8025/loginTestWS", new WSLoginTest());  
        System.out.print("OK!!!");
		System.out.print("25");
	}*/
}
