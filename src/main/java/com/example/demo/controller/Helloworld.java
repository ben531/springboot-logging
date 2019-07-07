package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annotation.Logtime;

@RestController
public class Helloworld {
	@GetMapping("/test1")
	@Logtime
	public String test1() throws InterruptedException {
		Thread.sleep(5000);
		return "hello world";
	}
}
