package ws;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.ljk.service.UserService;
import com.ljk.yc.User;
@WebService
public class WSLoginTest {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	public boolean login( String username,String password) {
		// 根据登录名和密码查找用户，判断用户登录
		User user1 = new User();
		user1.setUserName(username);
		user1.setPassword(password);
		User user = userService.login(user1.getUserName(),user1.getPassword());
		if (user != null) {
			return true; 
		} else {
			// 登录失败，设置失败提示信息，并跳转到登录页面
			return false;
		}
	}
	public static void  main(String[] args ){
		/*WSLoginTest ws =new WSLoginTest();
		boolean f=ws.login("root", "1");*/
		Endpoint.publish("http://localhost:8093/jdkwsdemo/ws", new WSLoginTest());  
        System.out.print("OK!!!");
		System.out.print("ok12345");
	}

}
