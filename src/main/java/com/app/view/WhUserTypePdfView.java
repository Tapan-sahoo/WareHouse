package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=User.pdf");

		// create element
		Paragraph p = new Paragraph("WELCOME TO PDF");

		// add to document
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<WhUserType> wu = (List<WhUserType>) model.get("user");

		// create Table
		PdfPTable t = new PdfPTable(9);

		// Add to heading Column
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("FORTYPE");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		t.addCell("IDTYPE");
		t.addCell("IFOTHER");
		t.addCell("IDNUM");
		

		// Add to DB Table
		for (WhUserType u : wu) {
			t.addCell(u.getId().toString());
			t.addCell(u. getType());
			t.addCell(u.getCode());
			t.addCell(u.getForType());	
			t.addCell(u. getEmail());
			t.addCell(u.getContact());
			t.addCell(u.getIdType());
			t.addCell(u.getIfOther());
			t.addCell(u.getIdNum());
		}
		document.add(t);

		document.add(new Paragraph(new Date().toString()));

	}

}
