import java.util.Scanner;

public class pallindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int n = 545;
		int temp, r, sum=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number you want to check is a pallindrome or not");
		int n = in.nextInt();
		
		temp = n;
		while(n>0)
		{
			r = n % 10; // gets the remainder of the number when divided by 10
			sum = (sum*10) + r;
			n = n / 10;
		}

		System.out.println(sum);
		
		if(temp == sum)
		  System.out.println("The number " +sum+ " is a pallindrome");
		else
			System.out.println("The number " +sum+ " is not a pallindrome");
		
	}

}
