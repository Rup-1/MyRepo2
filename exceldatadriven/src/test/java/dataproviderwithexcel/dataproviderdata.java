package dataproviderwithexcel;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderdata {
	
	Readexcelfile ef= new Readexcelfile();
	@Test(dataProvider= "dataprovidermthd")
	public void datamethod(String sno, String tc,String desc, String cno, String IA, String rec) {
		System.out.println(sno+" "+tc+ " "+ desc+ " "+cno+" "+IA+" "+rec);
	}

	
	@DataProvider
	public Object[][] dataprovidermthd() throws IOException {
		
		//create multidimensional object
		Object[][] ob1 = ef.readexcel();
		return ob1;
		
	}
}
