package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Customer;


public class CustomerExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		// File name Change
				response.addHeader("Content-Disposition", "attachment;filename=Customer.xlsx");

				// create sheet with name
				Sheet sheet = workbook.createSheet("customer");

				// create Head
				setHead(sheet);

				// read data
				@SuppressWarnings("unchecked")
				List<Customer> cs =  (List<Customer>) model.get("customer");

				// set Body
				setBody(sheet, cs);

			}

			private void setHead(Sheet sheet) {
				Row row = sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("CODE");
				row.createCell(2).setCellValue("ADDRESS");
				row.createCell(3).setCellValue("LOCATION");
				row.createCell(4).setCellValue("ENABLED");
				row.createCell(5).setCellValue("EMAIL");
				row.createCell(6).setCellValue("CONTACT");
				
				

			}

			private void setBody(Sheet sheet, List<Customer> cs) {

				int rowNum = 1;
				for (Customer c: cs) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(c.getCustId());
					row.createCell(1).setCellValue(c.getCustCode());
					row.createCell(2).setCellValue(c.getCustAddr());
					row.createCell(3).setCellValue(c.getCustLocs());
					row.createCell(4).setCellValue(c.getCustEnabled());
					row.createCell(5).setCellValue(c.getCustEmail());
					row.createCell(6).setCellValue(c.getCustContact());
				
				

				}
			}

	}


