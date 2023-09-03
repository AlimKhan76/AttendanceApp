package com.attendance.excel;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.attendance.model.Record;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelGenerator {

	private List<Record> attendanceReport;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelGenerator(List<Record> attendanceReport) {
		this.attendanceReport = attendanceReport;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Attendance-Report");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "Name", style);
		createCell(row, 1, " Date", style);
		createCell(row, 2, "Time", style);
		createCell(row, 3, "Status", style);
	}

	private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (valueOfCell instanceof Integer) {
			cell.setCellValue((Integer) valueOfCell);
		} else if (valueOfCell instanceof Long) {
			cell.setCellValue((Long) valueOfCell);
		} else if (valueOfCell instanceof Boolean) {
			cell.setCellValue((Boolean) valueOfCell);
		} else if (valueOfCell instanceof java.sql.Date) {
			cell.setCellValue((java.sql.Date) valueOfCell);
		} else if (valueOfCell instanceof java.sql.Time) {
			cell.setCellValue((java.sql.Time) valueOfCell);
		} else {
			cell.setCellValue((String) valueOfCell);
		}
		cell.setCellStyle(style);
	}

	private void write() {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		CreationHelper createHelper = workbook.getCreationHelper();
		
		CellStyle dateStyle = workbook.createCellStyle();
		short dateFormat = createHelper.createDataFormat().getFormat("dd-mm-yyyy");
		dateStyle.setDataFormat(dateFormat);

		CellStyle timeStyle = workbook.createCellStyle();
		short timeFormat = createHelper.createDataFormat().getFormat("hh:mm:ss");
		timeStyle.setDataFormat(timeFormat);
		
		for (Record record : attendanceReport) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getUname(), style);
			createCell(row, columnCount++, record.getLogdate(), dateStyle);
			createCell(row, columnCount++, record.getLogtime(), timeStyle);
			createCell(row, columnCount++, record.getStatus(), style);
		}
	}

	public void generateExcelFile(HttpServletResponse response) throws IOException {
		writeHeader();
		write();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}