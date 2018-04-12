package com.bridgeit.programs;

import java.util.Comparator;

 class SortByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getLastName()==o2.getLastName()) {
			return 0;
		}else {
			if(o1.getLastName().compareTo(o2.getLastName())>0) {
				return 1;
			}else
				return -1;
		}
		
	}

	

}
