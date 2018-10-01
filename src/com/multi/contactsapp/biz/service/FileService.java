package com.multi.contactsapp.biz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.contactsapp.biz.dao.FileDAO;
import com.multi.contactsapp.biz.util.FileUtils;

@Service
public class FileService {
	
	@Resource(name="fileUtils")
    private FileUtils fileUtils;
	
	@Autowired
	private FileDAO fileDAO;
	
	public Map<String, Object> addImage(HttpServletRequest request) throws Exception {
	     
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(map, request);
        for(int i=0, size=list.size(); i<size; i++){
        	fileDAO.insertImage(list.get(i));
        }
        
        return list.get(0);
	}
	
	public Map<String, Object> getFile(int idx) {
		return fileDAO.selectFile(idx);
	}
}
