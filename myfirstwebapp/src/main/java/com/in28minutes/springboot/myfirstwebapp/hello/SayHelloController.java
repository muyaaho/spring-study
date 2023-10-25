package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	// "say-hello" => "Hello! What are you learning today?"
	// sey-hello를 url에 매핑
	@RequestMapping("say-hello")
	@ResponseBody	// 리턴한 메시지를 출력함
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb= new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My First html page with body - Changed");
		sb.append("</body>");
		sb.append("</html>");
//		sb.append("");
		
		return sb.toString();
	}
}
