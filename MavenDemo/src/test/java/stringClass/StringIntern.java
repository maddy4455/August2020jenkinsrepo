package stringClass;

public class StringIntern {

	public static void main(String[] args) {

 // String s1="maddy";
		String s1=new String("maddy");
  String s2=s1.intern();
 System.out.println(s1==s2);
 System.out.println(s1.contains(s2));
		
		

	}

}
