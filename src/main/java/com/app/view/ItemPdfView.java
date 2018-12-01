package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=Item.pdf");

		// create element
		Paragraph p = new Paragraph("WELCOME TO PDF");

		// add to document
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<Item> it = (List<Item>) model.get("item");

		// create Table
		PdfPTable t = new PdfPTable(6);

		// Add to heading Column
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("DIMENSION");
		t.addCell("COST");
		t.addCell("CURRENCY");
		t.addCell("DESCRIPTION");

		// Add to DB Table
		for (Item i : it) {
			t.addCell(i.getItemId().toString());
			t.addCell(i. getItemCode());
			t.addCell(i.getWidth()+"");
			t.addCell(i.getLength()+"");
			t.addCell(i.getHeight()+"");
			t.addCell(i.getBaseCost()+"");
			t.addCell(i. getBaseCurrency());
			t.addCell(i. getDcpt());
		}
		document.add(t);

		document.add(new Paragraph(new Date().toString()));

	}

}
