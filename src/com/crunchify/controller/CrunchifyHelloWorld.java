package com.crunchify.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CrunchifyHelloWorld {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		String message = "Hello SMVC";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
    @RequestParam("name") String description,
    @RequestParam("file") MultipartFile file) throws Exception {
		System.out.println(description);
		if (!file.isEmpty()) {
			String path = request.getServletContext().getRealPath("/images/");
			String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
          //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
		}
		return "error";
	}
}
