package com.virtusa.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.virtusa.test.validation.NumberToWordInputValidator;

public class NumbertoWordConverter {
	private final static Logger LOGGER = Logger.getLogger(NumbertoWordConverter.class.getName());

	
public static void main(String[] args) {
	LOGGER.log(Level.INFO, "Start of Main method in NumbertoWordConverter");
	NumberToWordInputValidator nwInputVal =new NumberToWordInputValidator();
	nwInputVal.readInput();
	LOGGER.log(Level.INFO, "End of Main method in NumbertoWordConverter");


	 
	
}




}
