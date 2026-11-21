/**
* File: Lab11Prob03.java
* Class: CSCI 1302
* Author: Malachi Carter & David Camp
* Created on: Nov 20, 2026
* Last Modified: Nov 20, 2026
* Description: Copies a file and outputs the data to the console
*/
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab11Prob01 {
	public static void main(String[] args) {
		
		//Create a file of our current and a copy of it
		File source = new File("people.dat");
		File target = new File("people-copy.dat");
		
		//try catch block to read and write data
		try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(source)));
				DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
			
			
			//While loop to read specific values and write them based on value
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();
				
				System.out.printf("%d %s  %s %d %.0f%n", age, name, address, zipCode, salary);
				
				
				output.writeInt(age);
				output.writeUTF(name);
				output.writeInt(zipCode);
				output.writeDouble(salary);
				
			}
			
		//Exceptions
		} catch (EOFException e) {
			
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
			
	}
}
