/**
* File: Lab11Prob03.java
* Class: CSCI 1302
* Author: Malachi Carter & David Camp
* Created on: Nov 20, 2026
* Last Modified: Nov 20, 2026
* Description: Sorts salaries of the people.dat file
*/
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {
	public static void main(String[] args) {
		
		//Make our original file and a new one sorting salary
		File source = new File("people.dat");
		File target = new File("people-salary-sorted.dat");
		
		//array list to help sort
		ArrayList<Person> people = new ArrayList<>();
		
		try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(source)))) {
			
			//while loop to read values
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();
				
				//Create person containing this info
				Person one = new Person(age, name, address, zipCode, salary);
				people.add(one);
			}
			
		//Exceptions	
		} catch (EOFException e) {
		
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}
		
		//sort by salary and write into file
		Collections.sort(people);
		try (PrintWriter output = new PrintWriter(target)) {
			for (Person p : people) {
				output.println(p.toString());
			}
		//Exception
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
