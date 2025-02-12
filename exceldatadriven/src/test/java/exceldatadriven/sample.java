package exceldatadriven;

import java.io.IOException;
import java.util.ArrayList;

public class sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		datadriven d= new datadriven();
		ArrayList<String> a= d.getdatapool("Logincrede");
		System.out.println(a);
	}

} 
