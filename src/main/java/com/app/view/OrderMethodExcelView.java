package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// File name Change
				response.addHeader("Content-Disposition", "attachment;filename=ORDER.xlsx");

				// create sheet with name
				Sheet sheet = workbook.createSheet("ORDERMETHOD");

				// create Head
				setHead(sheet);

				// read data
				@SuppressWarnings("unchecked")
				List<OrderMethod> om =  (List<OrderMethod>) model.get("order");

				// set Body
				setBody(sheet, om);

			}

			private void setHead(Sheet sheet) {
				Row row = sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("MODE");
				row.createCell(2).setCellValue("CODE");
				row.createCell(3).setCellValue("METHOD");
				row.createCell(4).setCellValue("ACCEPT");
				row.createCell(5).setCellValue("DESCRIPTION");
				

			}

			private void setBody(Sheet sheet, List<OrderMethod> om) {

				int rowNum = 1;
				for (OrderMethod d : om) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(d.getId());
					row.createCell(1).setCellValue(d.getMode());
					row.createCell(2).setCellValue(d.getCode());
					row.createCell(3).setCellValue(d.getMethod());
					row.createCell(4).setCellValue(d.getAccept().toString());
					row.createCell(5).setCellValue(d.getDcpt());
				

				}
			}

	}


