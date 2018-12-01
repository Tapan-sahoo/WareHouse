package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=Shipment.pdf");

		// create element
		Paragraph p = new Paragraph("WELCOME TO PDF");

		// add to document
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<ShipmentType> st = (List<ShipmentType>) model.get("shipment");

		// create Table
		PdfPTable t = new PdfPTable(6);

		// Add to heading Column
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLED");
		t.addCell("GRADE");
		t.addCell("DESCRIPTION");

		// Add to DB Table
		for (ShipmentType s : st) {
			t.addCell(s.getId().toString());
			t.addCell(s.getMode());
			t.addCell(s.getCode());
			t.addCell(s.getEnable());
			t.addCell(s.getGrade());
			t.addCell(s.getDcpt());

		}
		document.add(t);

		document.add(new Paragraph(new Date().toString()));

	}

}
