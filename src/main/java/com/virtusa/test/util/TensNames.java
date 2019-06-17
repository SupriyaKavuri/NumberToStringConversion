package com.virtusa.test.util;
public enum TensNames 
{ 
	 	
	    ten(1),twenty(2),thirty(3),forty(4),fifty(5),sixty(6),seventy(7),eighty(8),ninety(9);
	    
	    private int tenValue;

        private TensNames (int tenValue) {
                this.tenValue = tenValue;
        }

		public int getValue() {
			 return tenValue;
		}
} 
