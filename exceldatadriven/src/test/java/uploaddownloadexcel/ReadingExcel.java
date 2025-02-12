package uploaddownloadexcel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ReadingExcel {
	
	static String fruit;
	
	ReadingExcel(String fruit){
		this.fruit= fruit;
		
	}
	
	public int[] getvaluefromexcel() throws IOException {
		
		String filelocation ="C:\\Users\\harsha\\Downloads\\download.xlsx";
		String sheetname="Sheet1";
		int fruitnamecol=0;
		int pricecol=0;
		double price=0;
		int fruitnamerow=0;
		int a[]=new int[2]; 
		FileInputStream file= new FileInputStream(filelocation);
		XSSFWorkbook wb= new XSSFWorkbook(file);
		int sheetcnt= wb.getNumberOfSheets();
		for (int i=0; i<sheetcnt;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				XSSFSheet sheet= wb.getSheetAt(i);
				XSSFRow firstrow= sheet.getRow(0);
				int totalrows= sheet.getLastRowNum();
				int totalcolumns= firstrow.getLastCellNum();
				for(int c=0;c<totalcolumns;c++) {
					XSSFCell cell= firstrow.getCell(c);
					if(cell.getStringCellValue().equals("fruit_name")) {
						fruitnamecol= c;	
					}
					else if(cell.getStringCellValue().equals("price")) {
						pricecol=c;
					}
				}
				System.out.println("fuitcol"+fruitnamecol);
				System.out.println("pricecol"+pricecol);
				
				for(int r=1;r<totalrows;r++){
					XSSFRow allrows= sheet.getRow(r);
					
					
						XSSFCell allcells= allrows.getCell(fruitnamecol);
						if(allcells.getStringCellValue().equalsIgnoreCase(this.fruit)) {
							fruitnamerow=r;
							System.out.println("apple is presnt in row"+fruitnamerow);
							 XSSFCell pricecell= allrows.getCell(pricecol);
							  price= pricecell.getNumericCellValue();
							  a[0]=fruitnamerow;
							  a[1]=pricecol;
						}
					}
				
					
				}
				
			}
		
		
			return a;
		}
	
	public static void main(String[] args) throws IOException {
		ReadingExcel re= new ReadingExcel("apple");
		
		int b[]= re.getvaluefromexcel();
		 System.out.println("row"+ b[0] +"column"+b[1]);
		 
		 FileInputStream f= new FileInputStream("C:\\Users\\harsha\\Downloads\\download.xlsx");
		 XSSFWorkbook wb= new XSSFWorkbook(f);
		 XSSFSheet sheet= wb.getSheet("sheet1");
		 Row r= sheet.getRow(b[0]);
		 Cell c= r.getCell(b[1]);
		 System.out.println("current proce is"+ c.getNumericCellValue());
		 c.setCellValue(100);
		 FileOutputStream fo= new FileOutputStream("C:\\Users\\harsha\\Downloads\\download.xlsx"); //to write upated value to excel
		 wb.write(fo); //write it back to excel
		 wb.close();
		  Assert.assertEquals(c.getNumericCellValue(), 100);
		  System.out.println("updated proce is"+ c.getNumericCellValue());
		 
		 
		 
				 
	}
	
	
	}


