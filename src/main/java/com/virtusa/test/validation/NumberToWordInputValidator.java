package com.virtusa.test.validation;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.virtusa.test.service.NumbertoWordConverterService;

public class NumberToWordInputValidator {
	private final static Logger LOGGER = Logger.getLogger(NumberToWordInputValidator.class.getName());

	/**
	 * @return int 
	 * this method is used to read value from console
	 */
	public  void readInput() {
		LOGGER.info("Start of readInput method");
		Scanner sc=new Scanner(System.in);
		readValue(sc);
		LOGGER.log(Level.INFO,"End of readInput method");
	}

	private void readValue(Scanner sc) {
		int number=0;
		try {
		      System.out.println("Please Enter value");

			 while ((number = sc.nextInt()) != 0) {
			 	if(number>0) {
				  System.out.println("You entered " + number);
				  String word= NumbertoWordConverterService.covertNmToString(number);
				  System.out.printf(" %d -->  Equilent British english word is '%s' %n",number,word);
			      System.out.println("Please Enter value");
			 	}else {
			 		System.out.println("Please enter valid integer");
			 		 readValue(sc);
			 	}
			 }
		}catch(InputMismatchException e) {
			sc.next();
			LOGGER.log(Level.SEVERE, "error while reading input",e);
             readValue(sc);

			
		}
	
	}


}
