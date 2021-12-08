import java.util.Scanner;

public class pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int i, j, k = 0, l;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		l= sc.nextInt();
		
		for(i=1; i<=l; i++)
		{
			for(j=1; j<=i; j++)
			{
				k=k+3;
				System.out.print("   "+k);
				
			}
			
			System.out.println("");
			
		}

	}

}
