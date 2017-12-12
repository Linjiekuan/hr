package com.ljk.controller;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.webxml.*;
@Controller
public class WebserviceTestController {
	
	@RequestMapping(value = "/testWebservice")
	@ResponseBody//必须加入的注解，经过验证，不加这个会导致数据不能返回前台
	public String testWebservice(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String data = null;
		String city = request.getParameter("city");
		TestWebservice ws = new TestWebservice();
		data = (String)ws.getWeather(city);
		String info = data;
		request.getSession().setAttribute("info", info);
		System.out.println(info);
		return info;
	}
}
