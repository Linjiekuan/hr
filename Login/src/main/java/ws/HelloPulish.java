package ws;
import javax.xml.ws.Endpoint;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public class HelloPulish {
	public String doSomething(@WebParam(name="value", targetNamespace = "http://demo/", mode = WebParam.Mode.IN)String value) {  
        return "Just do it," + value + "!";  
    }  
      
    public static void main(String[] args) {  
        Endpoint.publish("http://localhost:8000/jdkwsdemo/demo.JdkWebService", new HelloPulish());  
        System.out.print("OK!!!");
    }  

}
