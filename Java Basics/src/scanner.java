import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 Scanner sc = new Scanner(System.in);
//	        int cases = sc.nextInt();
//	        String []str = new String[cases];
//	        for(int i=0;i<cases;i++)
//	        {
//	        	 str[i]=sc.next(); //It read input from the input device till the space character.	
//	        }
		
//		  Scanner sc = new Scanner(System.in); 
//		  
//	        // Use of the next() method 
//	        String Inpt = sc.nextLine(); //It read input from the input device till the line change.
//	        System.out.println(Inpt); 
		
		
		String s = "Gfg \n Geeks \n GeeksForGeeks";
		
		 // with the specified String Object 
        Scanner scanner = new Scanner(s); 
  
        // print the next line 
        System.out.println(scanner.nextLine()); 
  
        // print the next line again 
        System.out.println(scanner.nextLine()); 
  
        // print the next line again 
        System.out.println(scanner.nextLine()); 
  
        scanner.close(); 
	           
	}          
}	

