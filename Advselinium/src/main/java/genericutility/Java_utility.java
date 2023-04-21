package genericutility;

import java.util.Random;

/**
 * this method is used to avoid duplicates
 * @return
 * @author suhas
 *
 */

public class Java_utility 
{
   public int getRandomNum()
   {
	   Random ran=new Random();
			   int RanNum=ran.nextInt(1000);
	   return RanNum;
	   
   }
}
