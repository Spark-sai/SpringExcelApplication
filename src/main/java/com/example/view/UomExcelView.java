package com.example.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.example.model.Uom;

public class UomExcelView extends AbstractXlsxView
{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response
			)
					throws Exception {
				
		response.addHeader("Content-Disposition", "attachment;filename=uoms.xlsx");
		
		List<Uom> list=(List<Uom>) model.get("list");
		
		// 1. create Sheet
		Sheet sheet=workbook.createSheet("Uoms");
		
		setHeader(sheet);
		setBody(sheet, list);
		
	}
	private void setBody(Sheet sheet, List<Uom> list)
	{
		int RowNum=1;	
		for(Uom uom:list)
		{
			Row row=sheet.createRow(RowNum ++);
			row.createCell(0).setCellValue(uom.getUomId());
			row.createCell(1).setCellValue(uom.getUomModel());
			row.createCell(2).setCellValue(uom.getUomType());
			row.createCell(3).setCellValue(uom.getUomDescription());
		}
		
	}
	private void setHeader(Sheet sheet)
	{
		//2. sheet containes rows
		Row row =sheet.createRow(0);
			
		//3. create one cell and data in cell
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Type");
		row.createCell(2).setCellValue("Model");
		row.createCell(3).setCellValue("Description");
		
	}

}
