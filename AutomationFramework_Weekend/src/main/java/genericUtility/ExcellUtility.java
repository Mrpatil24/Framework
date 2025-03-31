package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
	
	/**
	 * This method will read data from Excel file for specified index and return the value
	 * @param SheetName
	 * @param RowIndex
	 * @param ColIndex
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getStringDatafromExcel(String SheetName,int RowIndex, int ColIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestWorkBook.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(SheetName).getRow(RowIndex).getCell(ColIndex).getStringCellValue();
		
	}
	
	public boolean getBooleanDataFromExcel(String SheetName,int RowIndex, int ColIndex) throws IOException {
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData/TestWorkBook.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		 return wb1.getSheet(SheetName).getRow(RowIndex).getCell(ColIndex).getBooleanCellValue();
		
		 
	}
	}


