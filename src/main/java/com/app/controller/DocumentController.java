package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	
	//1. To show document Upload Page
	@RequestMapping("/show")
	public String showDocument(ModelMap map) {
		//read all docs Id, names from DB
		List<Object[]> docs=service.getDocumentAndNames();
		map.addAttribute("docs",docs);
		return "Document";
	}
	
	//2. To upload Document
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadDocument(@RequestParam CommonsMultipartFile file, ModelMap map) {
		
		if(file!=null) {
			Document doc=new Document();
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			int fileId =service.saveDocument(doc);
			map.addAttribute("message", "Uploaded '"+fileId+"' successfully");
			List<Object[]> docs=service.getDocumentAndNames();
			map.addAttribute("docs",docs);
		}
		return "Document";
	}
	
	//Download Document
	@RequestMapping("/download")
	public void downloadDocument(@RequestParam("fileId") int fileId, HttpServletResponse res) {
		
		Document doc=service.getDocumentById(fileId);
		
		res.addHeader("Content-Disposition","attachment;filename="+doc.getFileName());
		
		try {
			FileCopyUtils.copy(doc.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
