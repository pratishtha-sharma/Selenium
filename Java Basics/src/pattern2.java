import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j, k=1, l;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		l= sc.nextInt();
		
		for(i=1; i<=l; i++)
		{
			for(j=1; j<=i; j++)
			{
				System.out.print("   "+j);
//				System.out.print("   "+k);
//				k++;
			}
			
			System.out.println("");
			
		}

	}

}
