package com.bridgeit.programs;

import java.util.Comparator;

	public class SortByZip implements Comparator<Person>{
		public int compare(Person o1, Person o2) {
			Address address1=o1.getAddress();
			Address address2=o2.getAddress();
			if(address1.getZip()==address2.getZip()) {
				return 0;
			}else {
				if(address1.getZip()>address2.getZip()) {
					return 1;
				}else
					return -1;
			}
			
		}
		
	
}
