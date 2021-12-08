import java.util.Scanner;

public class pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j, l, k=1;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		l= sc.nextInt();
		
		for(i=1; i<=l; i++)// i is for number of rows
		{
			//for(j=1; j<=l-i; j++)
			for(j=i; j<=l; j++)
			{
				System.out.print("   "+k);
				k++;
			}
			
			System.out.println("");
		}

	}

}
