package com.multi.contactsapp.view.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.contactsapp.biz.service.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/form")
	public ModelAndView form() { 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form");
		return mv;
	}
	
	@RequestMapping(value="/upload")
	public ModelAndView addImage(HttpServletRequest request) throws Exception { 
		
		Map<String, Object> map = fileService.addImage(request);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.setViewName("detail");
		return mv;
	}
	
	@RequestMapping(value="/download")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String idx = request.getParameter("idx");
		
		Map<String, Object> map = fileService.getFile(Integer.parseInt(idx));
	    String storedFileName = (String)map.get("STORED_FILE_NAME");
	    String originalFileName = (String)map.get("ORIGINAL_FILE_NAME");
	     
	    byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\file\\"+storedFileName));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
	
}
