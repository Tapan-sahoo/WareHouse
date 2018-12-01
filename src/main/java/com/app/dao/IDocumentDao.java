package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {
	
	public int saveDocument (Document doc);
	public List<Object[]> getDocumentAndNames();
	public Document getDocumentById(int fileId);
}
