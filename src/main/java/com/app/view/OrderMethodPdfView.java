package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// download option with file name
		response.addHeader("Content-Disposition","attachment;filename=Order.pdf");

		// create element
		Paragraph p = new Paragraph("WELCOME TO PDF");

		// add to document
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<OrderMethod> om = (List<OrderMethod>) model.get("order");

		// create Table
		PdfPTable t = new PdfPTable(6);

		// Add to heading Column
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("METHOD");
		t.addCell("ACCEPT");
		t.addCell("DESCRIPTION");

		// Add to DB Table
		for (OrderMethod d :om) {
			t.addCell(d.getId()+"");
			t.addCell(d.getMode());
			t.addCell(d.getCode());
			t.addCell(d.getMethod());
			t.addCell(d.getAccept().toString());
			t.addCell(d.getDcpt());

		}
		document.add(t);

		document.add(new Paragraph(new Date().toString()));

	}

}
