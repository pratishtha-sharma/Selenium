
public class Pyramid_lefttriangle {

	  
	    public static void pyramidPattern(int n) 
	    {  
	        for (int i=1; i<=n; i++) //outer loop for number of rows(n)
	        { 
	         for (int j=2*(n-i); j>=1; j--) //inner loop for spaces
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
	    	int n = 4; 
	        pyramidPattern(n); 
	    } 
	}


