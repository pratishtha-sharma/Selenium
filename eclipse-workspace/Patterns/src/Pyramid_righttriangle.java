
public class Pyramid_righttriangle {

	  
	    public static void pyramidPattern(int n) 
	    {  
	        for (int i=1; i<=3; i++) //outer loop for number of rows(n)
	        { 
	         for (int j=3-i; j>=1; j--) //inner loop for spaces
	            { 
	                System.out.print(" "); //print space
	            }  
	            for (int j=1; j<=i; j++ ) //inner loop for number of columns
	            { 
	                System.out.print("* "); //print star
	            } 
	  
	            System.out.println(); //ending line after each row
	        } 
	    } 
	  
	    public static void main(String args[]) //driver function
	    { 
	         
	        pyramidPattern(3); 
	    } 
	}


