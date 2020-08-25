package gtplBankPages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class day3ExcelLogin {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\yavyo\\Desktop\\guruData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Login");

		XSSFRow row = sheet.getRow(1);

		XSSFCell cell = row.getCell(1);

		String str = cell.getStringCellValue();

		System.out.println(str);

		// to close the workbook and path

		wb.close();
		fis.close();

	}

}
