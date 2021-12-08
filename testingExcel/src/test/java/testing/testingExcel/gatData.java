package testing.testingExcel;

import java.util.ArrayList;

public class gatData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		testingExcel d = new testingExcel();
		ArrayList<String> data = d.getDataD("Login");
		 
		System.out.println(data);
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
	}

}
