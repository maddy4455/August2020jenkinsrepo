package stringClass;

import org.apache.commons.lang.text.StrBuilder;

public class StringReverse {

	public static void main(String[] args) {
		
   String name="maddy";
   String reverse=new StrBuilder(name).reverse().toString();

 System.out.println(reverse);
	}

}
