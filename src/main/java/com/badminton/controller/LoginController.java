package com.badminton.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.badminton.util.CheckUtil;

@Controller
public class LoginController {
	@RequestMapping("/show")
	public String show(Model model){
		model.addAttribute("msg", "thymeleaf");
		return "/hellow";
	}
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("msg", "thymeleaf");
		return "/index";
	}
	
	@RequestMapping(value = "wx",method=RequestMethod.GET)
	public void login(HttpServletRequest request,HttpServletResponse response){
		System.out.println("success");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = null;
		try {
			  out = response.getWriter();
			if(CheckUtil.checkSignature(signature, timestamp, nonce)){
				out.write(echostr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}

}