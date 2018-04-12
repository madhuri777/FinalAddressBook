package com.bridgeit.programs;

public class Address {
	private String state;
	private String city;
	private int zip;
/*
	private void Address(String state, String city, int zip) {
		this.state = state;
		this.city = city;
		this.zip = zip;
	}
*/
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", zip=" + zip + "]";
	}

	/*
	 * public String toString() { return
	 * ("State Name :"+getState()+"City Name :"+getCity()+"Zip code :"+getZip()); }
	 */

}
