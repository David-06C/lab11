/**
* File: Lab11Prob03.java
* Class: CSCI 1302
* Author: Malachi Carter & David Camp
* Created on: Nov 20, 2026
* Last Modified: Nov 20, 2026
* Description: reads person and stores them in an array to sort salary
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {
	public static void main(String[] args) {
		
		//create our files 
		File source = new File("people.dat");
		File target = new File("people-salary-sorted.dat");
		File object = new File("people-salary-sorted-objects.dat");
		
		ArrayList<Person> people = new ArrayList<>();
		
		//read file
		try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(source)))) {
			
			//while loop to read values
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();
				
				Person one = new Person(age, name, address, zipCode, salary);
				people.add(one);
			}
			
		//exceptions	
		} catch (EOFException e) {
		
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}
		
		//sort by salary
		Collections.sort(people);
		try (PrintWriter output = new PrintWriter(target)) {
			for (Person p : people) {
				output.println(p.toString());
			}
			
		//exception
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		//write objects to file
		try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(object)))) {
			
			for (Person p : people) {
				output.writeObject(p);
			}
			
		//exception
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

