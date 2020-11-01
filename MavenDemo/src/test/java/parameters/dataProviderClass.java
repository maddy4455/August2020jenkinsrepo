package parameters;

import org.testng.annotations.DataProvider;

public class dataProviderClass {
	
	@DataProvider(name="searchProvider")
	public static Object[][]getDataFromDataProvider(){
		return new Object[][] {
			{"Maddy","England"},
			{"Kiran","Canada"},
			{"King","India"}
			
		};
	}
		
}
