package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// File name Change
		response.addHeader("Content-Disposition", "attachment;filename=Vendor.xlsx");

		// create sheet with name
		Sheet sheet = workbook.createSheet("vendor");

		// create Head
		setHead(sheet);

		// read data
		@SuppressWarnings("unchecked")
		List<Vendor> vd = (List<Vendor>) model.get("vendor");

		// set Body
		setBody(sheet, vd);

	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("DESIGNATION");
		row.createCell(4).setCellValue("PRESERVE");

	}

	private void setBody(Sheet sheet, List<Vendor> vd) {

		int rowNum = 1;
		for (Vendor v : vd) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(v.getVenId());
			row.createCell(1).setCellValue(v.getVenName());
			row.createCell(2).setCellValue(v.getVenCode());
			row.createCell(3).setCellValue(v.getVenDesg());
			row.createCell(4).setCellValue(v.getVenPreserve().toString());

		}
	}

}
