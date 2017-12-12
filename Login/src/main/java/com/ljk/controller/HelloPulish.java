package com.ljk.controller;
import javax.xml.ws.Endpoint;

import org.springframework.stereotype.Controller;

import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
@Controller
public class HelloPulish {
	public String doSomething(@WebParam(name="value", targetNamespace = "http://demo/", mode = WebParam.Mode.IN)String value) {  
        return "Just do it," + value + "!";  
    }  
      
    public static void main(String[] args) {  
        Endpoint.publish("http://localhost:8027/test", new HelloPulish());  
        System.out.print("OK26!!!");
    }  

}
