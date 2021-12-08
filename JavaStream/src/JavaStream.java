import java.util.ArrayList;

public class JavaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Pratishtha");
		names.add("Diksha");
		names.add("Astha");
		names.add("Charu");
		names.add("Aashsish");

		
		
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.startsWith("A")).sorted().forEach(s->System.out.println(s));
		
	}

}
