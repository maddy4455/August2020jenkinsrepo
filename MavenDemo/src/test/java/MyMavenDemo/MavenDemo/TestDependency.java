package MyMavenDemo.MavenDemo;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestDependency 
{
	
  @Test(priority = 1)
  public void orange() {
	  
	  System.out.println("orange");
  }
  @Test(priority = 2, dependsOnMethods = {"orange"})
  public void pears() {
	  
	  System.out.println("pears");
  }
  
  @Test (priority = 3, dependsOnMethods = {"pears"})
  public void grape() {
	  System.out.println("grape");
	  
	 // Assert.fail("grape test is failed");
	  throw new SkipException("grape test is skipped");
  } 
  
	  @Test (priority = 4, dependsOnMethods = {"grape"})
	  public void mango() {
		
		  System.out.println("mango");
		  
	  }
	  
	  
  }
  

