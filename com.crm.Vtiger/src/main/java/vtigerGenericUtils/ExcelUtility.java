package vtigerGenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of excel related methods like insert data,fetch data, get RowNumber etc..
 * @author SanjayBabu
 *
 */
public class ExcelUtility {
/**
 * this method is used to insert data into excel sheet
 * @param SheetName
 * @param rowNum
 * @param cellNum
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public void insertDataIntoExcel(String SheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(IPathConstants.excelPath);
		workbook.write(fileOutputStream);
		workbook.close();
	}
	/**
	 * this method is used to fetch data from excel sheet
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String SheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}
	/**
	 * this method is used to get count of rows created in excel sheet
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowNumber(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		int row = sheet.getLastRowNum();
		return row;
	}
}
