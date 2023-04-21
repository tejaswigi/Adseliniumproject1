package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hardassert 
{

	/*@Test 
	
		public void createcontact()
		{
			System.out.println("step1");
			System.out.println("step2");
		//SoftAssert st= new SoftAssert();
		//st.assertEquals(false,true);
			Assert.assertEquals(false, true);
		System.out.println("step3");
		System.out.println("step4");
		}
		@Test 
		
		public void deletecontact()
		{
			System.out.println("step5");
			System.out.println("step6");*/
	@Test
	public void m1()
	{
		String expdata="qspiders";
		String actualdata="jspiders";
		Assert.assertEquals(actualdata, expdata);
			
		


}
}