package practice;

import java.util.ArrayList;

public class uniqueNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {4, 5, 5, 5, 4, 6, 6, 9, 4};
		
		//ArrayList<Integer> al = new ArrayList<Integer>();
		int b[] = new int[10];
		
		for(int i=0; i<a.length; i++)
		{
			b[a[i]]++;
		}
		
		for(int i=0; i<10; i++)
		{
			if(b[i]==1)
				{
				   System.out.println("The number is "+i+" is repeating "+b[i]+" time.");	
				}
		}
		
//		for(int i=0; i<a.length; i++)
//		{
//			int k=0;
//			
//			if(!al.contains(a[i]))
//			{
//				al.add(a[i]);
//				k++;
//				
//				for(int j=i+1; j<a.length; j++)
//				{
//					if (a[j] == a[i])
//					{
//						k++;
//					}
//				}
//				
//			}
//			
//			//System.out.println(a[i]);
//			if(k==1)
//			{
//			   System.out.println("The unique number is "+a[i]);	
//			}
//			
//		}

		
		
	}

}
