package utilityPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class DDTConcept {
	
	//static public String username;
	//static public String pass;
	public String credentialsUsername(String Sheetname, int row , int Cell) throws EncryptedDocumentException, IOException
	{

		FileInputStream f1=new FileInputStream("C:\\Users\\NEEKI KUMARI\\eclipse-workspace\\SeleniumProjectArch\\DDT\\amazon_login.xlsx");
		Workbook w1=WorkbookFactory.create(f1);
		String username=NumberToTextConverter.toText(w1.getSheet(Sheetname).getRow(row).getCell(Cell).getNumericCellValue());
		//pass=w1.getSheet("login").getRow(0).getCell(1).getStringCellValue();
		return username;
	}
	
	public String credentialsPass(String Sheetname, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream f1=new FileInputStream("C:\\Users\\NEEKI KUMARI\\eclipse-workspace\\SeleniumProjectArch\\DDT\\amazon_login.xlsx");
		Workbook w1=WorkbookFactory.create(f1);
		//username=NumberToTextConverter.toText(w1.getSheet("login").getRow(1).getCell(0).getNumericCellValue());
		String pass=w1.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
		return pass;
	}
}
