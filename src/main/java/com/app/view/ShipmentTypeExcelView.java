package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// File name Change
				response.addHeader("Content-Disposition", "attachment;filename=Shipment.xlsx");

				// create sheet with name
				Sheet sheet = workbook.createSheet("Shipment");

				// create Head
				setHead(sheet);

				// read data
				@SuppressWarnings("unchecked")
				List<ShipmentType> st =  (List<ShipmentType>) model.get("shipment");

				// set Body
				setBody(sheet, st);

			}

			private void setHead(Sheet sheet) {
				Row row = sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("MODE");
				row.createCell(2).setCellValue("CODE");
				row.createCell(3).setCellValue("ENABLED");
				row.createCell(4).setCellValue("GRADE");
				row.createCell(5).setCellValue("DESCRIPTION");
				

			}

			private void setBody(Sheet sheet, List<ShipmentType> st) {

				int rowNum = 1;
				for (ShipmentType s: st) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(s.getId());
					row.createCell(1).setCellValue(s.getMode());
					row.createCell(2).setCellValue(s.getCode());
					row.createCell(3).setCellValue(s.getEnable());
					row.createCell(4).setCellValue(s.getGrade());
					row.createCell(5).setCellValue(s.getDcpt());
				

				}
			}

	}


