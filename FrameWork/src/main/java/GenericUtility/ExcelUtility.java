package GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	@DataProvider(name = "MovieData")
	public Object[][] read(String name, String last)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream file = new FileInputStream("./Excel/Movies.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet data=book.getSheet("sheet1");
		int rowcount=data.getPhysicalNumberOfRows();
		int cellcount=data.getRow(0).getPhysicalNumberOfCells();
		
		Object [][] info=new Object[rowcount][cellcount];
		for (int row = 0; row < rowcount; row++) {
			
			Row actualrow=data.getRow(rowcount);
			
			for (int cell = 0; cell < actualrow.getLastCellNum(); cell++) {
				
				info [row][cell]=data.getRow(row).getCell(cell).toString();
			}
		}

		return info;

	}
}
