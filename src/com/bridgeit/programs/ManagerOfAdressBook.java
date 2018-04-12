package com.bridgeit.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class ManagerOfAdressBook {
	AddressBook addressbook = new AddressBook();
	static ArrayList<Person> arrayList = new ArrayList<>();
	private ObjectMapper objectMapper = new ObjectMapper();
	private File file;
	private static Scanner scanner = new Scanner(System.in);
	static ManagerOfAdressBook addbook = new ManagerOfAdressBook();

	public void createAddressBook() throws Exception {
		File path = new File("/home/bridgeit/aaaa/");
		File[] listFile = path.listFiles();
		System.out.println("list of file in folder: ");
		for (File file1 : listFile) {
			System.out.println(file1.getName());
		}
		System.out.println("Give a name to your new address book:");
		file = new File("/home/bridgeit/eclipse-works8/AddressBook/aaaa/" + "" + scanner.next() + ".json");

		try {
			if (file.createNewFile()) {
				System.out.println("Address book is created!");
				saveAddressBook();

			} else {
				System.out.println("Address book is already exists.");
				saveAddressBook();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		addbook.openAddressBook();
	}

	public void openAddressBook() throws Exception {
		File path = new File("/home/bridgeit/eclipse-works8/AddressBook/aaaa/");
		File[] listFile = path.listFiles();
		System.out.println("list of file in folder: ");
		for (File file1 : listFile) {
			System.out.println(file1.getName());
		}
		System.out.println("Enter the name of address book");
		file = new File("/home/bridgeit/eclipse-works8/AddressBook/aaaa/" + "" + scanner.next() + ".json");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String arrayToJson;
			if ((arrayToJson = reader.readLine()) != null) {
				TypeReference<ArrayList<Person>> type = new TypeReference<ArrayList<Person>>() {
				};
				arrayList = objectMapper.readValue(arrayToJson, type);
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		addressbook.opration();
		saveAddressBook();

	}

	public static ArrayList<Person> listReturn() {
		return arrayList;
	}

	public void saveAddressBook() {
		// ArrayList<Person> arrayList=new ArrayList<Person>();
		arrayList = addressbook.list();
		try {
			objectMapper.writeValue(file, arrayList);
			System.out.println(arrayList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// ManagerOfAdressBook addbook=new ManagerOfAdressBook();
		System.out.println("==============Records=============");

		while (true) {
			System.out.println("1.CreateNewAddressBook  2.OpenBook  3.close");

			int ch = scanner.nextInt();
			switch (ch) {
			case 1:
				addbook.createAddressBook();
				break;
			case 2:
				addbook.openAddressBook();
				break;
			case 3:
				System.out.println("Quitted");
				System.exit(0);
				break;
			}
		}
	}
}
