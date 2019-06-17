package io.virtusa.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.virtusa.test.NumbertoWordConverter;
import com.virtusa.test.service.NumbertoWordConverterService;

public class NumberToWordCovertedTest {
	
	
	NumbertoWordConverter  numbertoWordConverter;
		 @Test  
		    public void testNumberToWord1(){  
			 	String value= NumbertoWordConverterService.covertNmToString(123);
			 	assertNotNull(value);
		    }  
		 @Test(expected = NumberFormatException.class)
		    public void testNumberToWord2(){  
			 	 NumbertoWordConverterService.covertNmToString(Integer.parseInt("!@@"));
		    }  
		 @Test(expected = NumberFormatException.class)
		    public void testNumberToWord3(){  
				 NumbertoWordConverterService.convertLessThanOneThousand(Integer.parseInt("abc"));
		    }  
		@Test  
		    public void testNumberToWord4(){  
			 	String value= NumbertoWordConverterService.convertLessThanOneThousand(324);
			 	assertNotNull(value);
		    }  
		
		 
		 @Test  
		    public void testNumberToWord6(){  
			 	String value= NumbertoWordConverterService.covertNmToString(999999999);
			 	assertNotNull(value);
		    }  
		 
		 @Test  
		    public void testNumberToWord7(){  
			 	String value= NumbertoWordConverterService.covertNmToString(99999999);
			 	assertNotNull(value);
		    }  
		
		
		 
		 
	 
}
