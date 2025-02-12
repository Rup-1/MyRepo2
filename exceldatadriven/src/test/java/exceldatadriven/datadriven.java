package exceldatadriven;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;

import javax.imageio.IIOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {

	
	public ArrayList<String> getdatapool(String sheetname) throws IOException {
			ArrayList<String> datapool= new ArrayList<String>();
		
		// identify testcase-login2 credentials from excel
		// access workbook
		String filepath="C:\\Users\\harsha\\Desktop\\Automationsamplefile.xlsx";
		FileInputStream filename = new FileInputStream(filepath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(filename);
		
		//access worksheet we want
		//get count of worksheets
		int sheetcnt= workbook.getNumberOfSheets();
		
		//loop through each sheet and check if sheet is we looking for
		
		for(int i=0; i<sheetcnt; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetname))
			{
			XSSFSheet wsheet= workbook.getSheetAt(i); // gets sheet at each index ex: at 0, its logincred
			//getting all rows
			Iterator<Row> r= wsheet.iterator(); //sheet has collection of rows 
			Row firstrow= r.next(); //getting 1st row
			Iterator<Cell> c= firstrow.cellIterator(); //getting cell access of 1st row. rows has list of cells
			//checking each cel of st row if testcases name is present
			int k=0;
			int column=0; // it will get the column where testcases is present 
			while(c.hasNext())
			{
				Cell val= c.next();
				if(val.getStringCellValue().equalsIgnoreCase("TestCases")) {
					//we got the column at which testcases col is present. now go to login2 column
					column=k;
					
				}
				k++;
			}
			System.out.println(column);
			//scan the testcase column to search for  testcase"login2"
			while(r.hasNext()) {
				//iterate thru next rows
				Row nextrow= r.next(); //goes to 2nd ,3rd row ect
				if(nextrow.getCell(column).getStringCellValue().equalsIgnoreCase("Login2")){//we are getting values presnt in 1st columnof each row
				Iterator<Cell> cv=nextrow.cellIterator();  //getting cell access of login2 row
				while(cv.hasNext()) {
					Cell ce= cv.next();
					if(ce.getCellType()==CellType.STRING)
					//put in a array
					datapool.add(ce.getStringCellValue());
					else
						datapool.add(NumberToTextConverter.toText(ce.getNumericCellValue()));					
									}
					
				}	
			}
			}
		}
		return datapool;
	}
}
