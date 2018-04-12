
package com.bridgeit.programs;
//import row.AddressBookManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

@SuppressWarnings({})
public class AddressBook {
	static Scanner sc = new Scanner(System.in);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static ArrayList<Person> list = new ArrayList();

	public void addNewPerson() throws Exception {
		Address add = new Address();
		Person person = new Person();
		System.out.print("person first Name: ");
		person.setFiStName(sc.next());
		System.out.print("person Last Name: ");
		person.setLastName(sc.next());
		System.out.print("person Phone Number: ");
		person.setPhoneNo(Integer.parseInt(sc.next()));
		System.out.print("person State Name: ");
		add.setState(sc.next());
		System.out.print("person City Name: ");
		add.setCity(sc.next());
		System.out.print("City's zip code: ");
		add.setZip(sc.nextInt());
		person.setAddress(add);
		list.add(person);
		for (Person p : list) {
			System.out.println(p.toString());
		}
	}

	public  void edit() throws Exception, IOException, Exception {
		System.out.println("Enter the person name: ");
		String name = sc.next();

		Iterator<Person> itr = list.iterator();
		while (itr.hasNext()) {
			Person persn = itr.next();
			if (persn.getFiStName().equals(name)) {
				System.out.println("Which field you wants to edit: 1.Phoneno 2.addresss ");
				int field = sc.nextInt();
				switch (field) {
				case 1:
					System.out.println("Enter new phonenumber: ");
					int newnumber = sc.nextInt();
					persn.setPhoneNo(newnumber);
					break;
				case 2:
					System.out.println("Enter new state: ");
					String newstate = sc.next();
					Address add1 = persn.getAddress();
					add1.setState(newstate);
					System.out.println("Enter new city: ");
					String newcity = sc.next();
					Address add2 = persn.getAddress();
					add2.setCity(newcity);
					System.out.println("Enter zipcode: ");
					int newzip = sc.nextInt();
					Address add3 = persn.getAddress();
					add3.setZip(newzip);
					System.out.println();
					break;
				}
				System.out.println(persn);

			}
		}

	}

	public  void delete() {
		System.out.println("Enter the person name: ");
		String name = sc.next();

		Iterator<Person> itr = list.iterator();
		Person persn;
		while (itr.hasNext()) {
			persn = itr.next();
			if (persn.getFiStName().equals(name)) {
				list.remove(persn);
				break;
			}
		}
		for (Person p : list) {
			System.out.println(p.toString());
		}
	}

	public void sortingByName() {
		Collections.sort(list, new SortByName());
		for (Person p3 : list) {
			System.out.println(p3.toString());
		}
	}

	public  void sortingByZip() {
		Collections.sort(list, new SortByZip());
		for (Person p3 : list) {
			System.out.println(p3.toString());
		}

	}

	public  void opration() throws Exception {
		list = ManagerOfAdressBook.listReturn();
		AddressBook addbook = new AddressBook();
		boolean status = true;
		while (status) {
			System.out.println(
					"enter the choose: 1.AddAddress 2.EditAddress  3.Delete 4.sortingByName 5.sortingByZip 6.Back ");
			
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				addbook.addNewPerson();
				break;
			case 2:
				addbook.edit();
				break;
			case 3:
				addbook.delete();
				break;
			case 4:
				addbook.sortingByName();
				break;
			case 5:
				addbook.sortingByZip();
				break;
			case 6:
				System.out.println("Back to addressbookmanager class:");
				status = false;
				break;
			}
		}
	
	}

	public ArrayList<Person> list() {
		return list;
	}

}
