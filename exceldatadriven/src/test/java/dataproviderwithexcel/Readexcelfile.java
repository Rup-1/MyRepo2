package dataproviderwithexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Readexcelfile {

	public Object[][] readexcel() throws IOException {
		DataFormatter df = new DataFormatter();
		String filepath = "C:\\Users\\harsha\\Desktop\\Automationsamplefile.xlsx";
		String sheetname = "exceldata";
		FileInputStream fis = new FileInputStream(filepath); // to access file
		XSSFWorkbook wbook = new XSSFWorkbook(fis); // to access/read excel located at this filepath
		int sheetcount = wbook.getNumberOfSheets(); // getting number of sheets present in excel
		Object[][] data = null;
		for (int i = 0; i < sheetcount; i++) {
			if (wbook.getSheetName(i).equalsIgnoreCase(sheetname)) { // searching for exceldata sheetname

				XSSFSheet she = wbook.getSheet(sheetname); // getting exceldata sheet access to she vraible
				int rowscount = she.getPhysicalNumberOfRows(); // get count of rows
				// we dont ahev column in apache POI. we ahev to consider one row(0th row here)
				// and each cell in that row is a column
				XSSFRow rows = she.getRow(0); // get 0th row data access into rows variable
				int colcount = rows.getLastCellNum(); // gives count of column
				Object[][] ob = new Object[rowscount - 1][colcount];
				for (int i1 = 0; i1 < rowscount - 1; i1++) {
					rows = she.getRow(i1 + 1);

					for (int j = 0; j < colcount; j++) {
						XSSFCell cell = rows.getCell(j);
						// System.out.println(rows.getCell(j));
						ob[i1][j] = df.formatCellValue(cell);
						System.out.println("copying to ob" + ob[i1][j]);

					}
				}
				data = ob;

			}

		}
		return data;

	}

}
