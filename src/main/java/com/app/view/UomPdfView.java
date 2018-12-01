package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=Uom.pdf");

		// create element
		Paragraph p = new Paragraph("WELCOME TO PDF");

		// add to document
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<Uom> um = (List<Uom>) model.get("uom");

		// create Table
		PdfPTable t = new PdfPTable(4);

		// Add to heading Column
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("DESCRIPTION");

		// Add to DB Table
		for (Uom u : um) {
			t.addCell(u.getId().toString());
			t.addCell(u. getType());
			t.addCell(u.getModel());
			t.addCell(u.getDcpt());	
		}
		document.add(t);

		document.add(new Paragraph(new Date().toString()));

	}

}
