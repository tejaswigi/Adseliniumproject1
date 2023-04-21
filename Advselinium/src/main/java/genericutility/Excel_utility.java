package genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.text.DefaultFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility 
{
	
	/**
	 * This method is used to fetch data from excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
  public String getExcelData(String sheetname,int rownum,int cellnum )throws Throwable
  {
  FileInputStream fes=new FileInputStream("C:\\Users\\suhas\\Desktop\\adselinium.xlsx");
	Workbook book=WorkbookFactory.create(fes);
	Sheet sheet=book.getSheet(sheetname);
	Row row=sheet.getRow(rownum);
  Cell cell=row.getCell(cellnum);
	String value= cell.getStringCellValue();
	return value;
}
  public String getExcelDataformatter(String sheetname,int rownum,int cellnum )throws Throwable
  {
  FileInputStream fes=new FileInputStream("C:\\Users\\suhas\\Desktop\\createcampaign.xlsx");
	Workbook book=WorkbookFactory.create(fes);

DataFormatter format=new DataFormatter();	
 String data=format.formatCellValue(book.getSheet(sheetname).getRow(rownum).getCell(cellnum));
	
	return data;
  
}
  public Object[][] readmultipledata(String sheetname) throws Throwable
  {
	  
		  FileInputStream fis1=new FileInputStream("C:\\Users\\suhas\\Desktop\\dataprovider.xlsx");
			Workbook book=WorkbookFactory.create(fis1);
			
			Sheet sh=book.getSheet(sheetname);
			int lastrow=sh.getLastRowNum()+1;
			  int  lastcell=sh.getRow(0).getLastCellNum();
			  
			//  Sheet sheet=book.getSheet(sheetname);
			//  int numrow=sheet.getPhysicalNumberOfRows();
			// int numcel=sheet.getRow(0).getLastCellNum();
			  
			  Object[][] obj=new Object[lastrow][lastcell];
			  for(int i=0;i<lastrow;i++)
			  {
				  for(int j=0;j<lastcell;j++)
				  {
					  obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
					  
				  }
				  
			  }
			return obj;
			  
	  
  


	
}
}

