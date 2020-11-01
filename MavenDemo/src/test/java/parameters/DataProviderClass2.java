package parameters;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderClass2 {
	
@DataProvider(name="searchProvider")	
public static Object[][]getDataFromDataProvider(Method m){
if(m.getName().equalsIgnoreCase("testMethodA")) {
	return new Object[][] { 
		
		{"Maddy","England"},
		{"Kiran","Canada"},
		{"King","India"}
	};
}
else{
    return new Object[][] {
            { "Canada" },
            { "Russia" },
            { "Japan" }

};
}
}
}
