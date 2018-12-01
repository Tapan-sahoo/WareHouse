package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=Customer.pdf");

		// create element
		Paragraph p = new Paragraph("WELCOME TO PDF");

		// add to document
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<Customer> cs = (List<Customer>) model.get("customer");

		// create Table
		PdfPTable t = new PdfPTable(7);

		// Add to heading Column
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("ADDRESS");
		t.addCell("LOCATION");
		t.addCell("ENABLED");
		t.addCell("EMAIL");
		t.addCell("CONTACT");

		// Add to DB Table
		for (Customer c : cs) {
			t.addCell(c.getCustId().toString());
			t.addCell(c. getCustCode());
			t.addCell(c.getCustAddr());
			t.addCell(c.getCustLocs());
			t.addCell(c. getCustEnabled());
			t.addCell(c.getCustEmail());
			t.addCell(c.getCustContact());
		}
		document.add(t);

		document.add(new Paragraph(new Date().toString()));

	}

}
