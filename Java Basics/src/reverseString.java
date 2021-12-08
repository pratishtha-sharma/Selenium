
public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "pratishtha";
		String t = "";
		
		for (int i=s.length()-1; i>=0; i--) //-1 is used as the value in string starts from 0
		{
			t = t+s.charAt(i);
			
		}
		
		System.out.println(t);
		
		
		
		
	}

}
