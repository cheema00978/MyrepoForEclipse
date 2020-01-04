package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

@RestController
@RequestMapping("/empService")
public class EmployeeController {

	@RequestMapping("/test")
	public String test() {
		return "Test";
	}
	
	@RequestMapping(value="/login/{userName}/{password}",method=RequestMethod.GET)
	public String login(@PathVariable String userName, @PathVariable String password) {
		System.out.println(userName);
		System.out.println(password);
		return userName+" Login Successful with "+password;
	}
	
	@RequestMapping("/testRequestParam")
	@ResponseBody
	public String testRequestParam(@RequestParam("name") String name,@RequestParam("mobile") String mobile) {
		return "User has name : "+name+" and mobile :"+mobile;
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int addEmployee(@RequestBody Employee emp) {
		return 1;
	}
}
