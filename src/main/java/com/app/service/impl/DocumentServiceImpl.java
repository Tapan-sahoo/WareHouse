package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {
	@Autowired
	private IDocumentDao dao;

	@Transactional
	public int saveDocument(Document doc) {

		return dao.saveDocument(doc);
	}
	
	@Transactional(readOnly=true)
	public List<Object[]> getDocumentAndNames() {
		
		return dao.getDocumentAndNames();
	}
	@Transactional(readOnly=true)
	public Document getDocumentById(int fileId) {
		return dao.getDocumentById(fileId);
	}

}
