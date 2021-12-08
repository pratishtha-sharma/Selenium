package test.excelDataD;

import java.util.ArrayList;

public class getDataSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		excelDataD d = new excelDataD();
        ArrayList<String> data = d.getData("Purchase");
        
        System.out.println(data);
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
		
		
	}

}
