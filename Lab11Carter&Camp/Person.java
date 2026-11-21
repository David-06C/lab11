/**
* File: Lab11Prob03.java
* Class: CSCI 1302
* Author: Malachi Carter & David Camp
* Created on: Nov 20, 2026
* Last Modified: Nov 20, 2026
* Description: Creates a person object and stores it
*/
import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {

	//variables
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;
	
	//default constructor
	public Person() {
	}
	
	//full constructor
	public Person (int age, String name, String address, int zipCode, double salary) {
		this.age = age;
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.salary = salary;
	}
	
	//accessors 
	public int getAge() { return age; }
	public String getName() { return name; }
	public String getAddress() { return address; }
	public int getZipCode() { return zipCode; }
	public double getSalary() { return salary; }
	
	//mutators
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	//sort in descending order for salary
	@Override
		public int compareTo(Person one) {
			return Double.compare(one.salary, this.salary);
		}
		
		//format as a string based on currency
		@Override
		public String toString() {
			return String.format( "%d %s %s %d $%,.2f", age, name, address, zipCode, salary);
		}
	}

