package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


import com.app.model.Item;


public class ItemExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		// File name Change
				response.addHeader("Content-Disposition", "attachment;filename=Item.xlsx");

				// create sheet with name
				Sheet sheet = workbook.createSheet("item");

				// create Head
				setHead(sheet);

				// read data
				@SuppressWarnings("unchecked")
				List<Item> it =   (List<Item>) model.get("item");

				// set Body
				setBody(sheet, it);

			}

			private void setHead(Sheet sheet) {
				Row row = sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("CODE");
				row.createCell(2).setCellValue("WIDTH");
				row.createCell(3).setCellValue("LENGTH");
				row.createCell(4).setCellValue("HEIGHT");
				row.createCell(5).setCellValue("COST");
				row.createCell(6).setCellValue("CURRENCY");

			}

			private void setBody(Sheet sheet, List<Item> it) {

				int rowNum = 1;
				for (Item i: it) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(i.getItemId());
					row.createCell(1).setCellValue(i.getItemCode());
					row.createCell(2).setCellValue(i.getWidth());
					row.createCell(3).setCellValue(i.getLength());
					row.createCell(4).setCellValue(i.getHeight());
					row.createCell(5).setCellValue(i.getBaseCost());
					row.createCell(6).setCellValue(i.getBaseCurrency());
				
				}
			}
	}


