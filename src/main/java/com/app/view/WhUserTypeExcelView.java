package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	

		// File name Change
				response.addHeader("Content-Disposition", "attachment;filename=User.xlsx");

				// create sheet with name
				Sheet sheet = workbook.createSheet("user");

				// create Head
				setHead(sheet);

				// read data
				@SuppressWarnings("unchecked")
				List<WhUserType> wu =  (List<WhUserType>) model.get("user");

				// set Body
				setBody(sheet, wu);

			}

			private void setHead(Sheet sheet) {
				Row row = sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("TYPE");
				row.createCell(2).setCellValue("CODE");
				row.createCell(3).setCellValue("FORTYPE");
				row.createCell(4).setCellValue("EMAIL");
				row.createCell(5).setCellValue("CONTACT");
				row.createCell(6).setCellValue("IDTYPE");
				row.createCell(7).setCellValue("IFOTHER");
				row.createCell(8).setCellValue("IDNUM");

			}

			private void setBody(Sheet sheet, List<WhUserType> wu) {

				int rowNum = 1;
				for (WhUserType w: wu) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(w.getId());
					row.createCell(1).setCellValue(w.getType());
					row.createCell(2).setCellValue(w.getCode());
					row.createCell(3).setCellValue(w.getForType());
					row.createCell(4).setCellValue(w.getEmail());
					row.createCell(5).setCellValue(w.getContact());
					row.createCell(6).setCellValue(w.getIdType());
					row.createCell(7).setCellValue(w.getIfOther());
					row.createCell(8).setCellValue(w.getIdNum());
				

				}
			}

	}


