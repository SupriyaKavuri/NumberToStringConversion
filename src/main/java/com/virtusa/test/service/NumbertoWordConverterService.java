package com.virtusa.test.service;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.virtusa.test.exception.NumberConversionException;
import com.virtusa.test.util.NumNames;
import com.virtusa.test.util.TensNames;

public class NumbertoWordConverterService {
	private final static Logger LOGGER = Logger.getLogger(NumbertoWordConverterService.class.getName());

	
	 /**
	 * @param number
	 * @return String
	 *  this method is used to convert given number which less than thousand to String
	 */
	public static String convertLessThanOneThousand(int number) {
		 LOGGER.log(Level.INFO, "Start of convertLessThanOneThousand");
		
		 try {
		    String soFar;
		    if (number % 100 < 20) {
		    	
		    	soFar =retrieveNumEnums(number % 100);
		      number /= 100;
		    }
		    else {
		      soFar = retrieveNumEnums(number % 10);
		      number /= 10;

		      soFar = retrieveTenEnums(number % 10) + soFar;
		      number /= 10;
		    }
		    if (number == 0) return soFar;
		    
			 LOGGER.log(Level.INFO, "End of convertLessThanOneThousand");

		    return retrieveNumEnums(number) + " hundred " + soFar;
		 }catch(NumberConversionException e) {
				LOGGER.log(Level.SEVERE, "error while convertLessThanOneThousand",e);
				 throw new NumberConversionException(e.getMessage());

		 }
		}
	
	
	public static String retrieveNumEnums(int number) {
		for (NumNames n : NumNames.values()) {
			if(number == n.getValue()) {
				return n.name();
			}
		}
		return "";
			

	}
	
	public static String retrieveTenEnums(int number) {
		for (TensNames n : TensNames.values()) {
			if(number == n.getValue()) {
				return n.name();
			}
		}
		return "";
			

	}
	 
	 /**
	 * @param number
	 * @return String
	 *  this method used to convert to string
	 */
	public static String covertNmToString(int number) {
		
			LOGGER.log(Level.INFO,"Start of covertNmToString method");
		 try {
		   
		    if (number == 0) { return "zero"; }

		    String snumber = Long.toString(number);

		    
		    String mask = "000000000000";
		    DecimalFormat df = new DecimalFormat(mask);
		    snumber = df.format(number);

		    // XXXnnnnnnnnn
		    int billions = Integer.parseInt(snumber.substring(0,3));
		    // nnnXXXnnnnnn
		    int millions  = Integer.parseInt(snumber.substring(3,6));
		    // nnnnnnXXXnnn
		    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
		    // nnnnnnnnnXXX
		    int thousands = Integer.parseInt(snumber.substring(9,12));

		    String tradBillions;
		    switch (billions) {
		    case 0:
		      tradBillions = "";
		      break;
		    case 1 :
		      tradBillions = convertLessThanOneThousand(billions)
		      + " billion ";
		      break;
		    default :
		      tradBillions = convertLessThanOneThousand(billions)
		      + " billion ";
		    }
		    String result =  tradBillions;

		    String tradMillions;
		    switch (millions) {
		    case 0:
		      tradMillions = "";
		      break;
		    case 1 :
		      tradMillions = convertLessThanOneThousand(millions)
		         + " million ";
		      break;
		    default :
		      tradMillions = convertLessThanOneThousand(millions)
		         + " million ";
		    }
		    result =  result + tradMillions;

		    String tradHundredThousands;
		    switch (hundredThousands) {
		    case 0:
		      tradHundredThousands = "";
		      break;
		    case 1 :
		      tradHundredThousands = "one thousand ";
		      break;
		    default :
		      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
		         + " thousand ";
		    }
		    result =  result + tradHundredThousands;

		    String tradThousand;
		    tradThousand = convertLessThanOneThousand(thousands);
		    result =  result + tradThousand;
		    
		    LOGGER.log(Level.INFO,"End of covertNmToString method");
		    
		    // remove extra spaces!
		    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
		  
		 }catch(NumberFormatException e) {
				LOGGER.log(Level.SEVERE, "error while covertNmToString",e);
				 throw new NumberConversionException(e.getMessage());
 
		 }

		}


}
