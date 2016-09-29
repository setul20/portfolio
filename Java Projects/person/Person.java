	/*
		 * Person.java
		 * Author: Setul Patel
		 * Submission Date: 11-3-2013
		 * 
		 * Purpose: to get comfortable with using constructors, instance variables, modifiers and methods. 
		 * 
		 * 
		 * Statement of Academic Honesty:
		 * 
		 * The following code represents my own work. I have neither
		 * received nor given inappropriate assistance. I have not copied
		 * or modified code from any source other than the course webpage
		 * or the course textbook. I recognize that any unauthorized
		 * assistance or plagiarism will be handled in accordance with
		 * the University of Georgia's Academic Honesty Policy and the
		 * policies of this course. I recognize that my work is based
		 * on an assignment created by the Department of Computer
		 * Science at the University of Georgia. Any publishing
		 * or posting of source code for this project is strictly
		 * prohibited unless you have written consent from the Department
		 * of Computer Science at the University of Georgia.
		 */

public class Person {

	private int age;
	private String name;
	private boolean isFemale;
	
	public static int totalPerson = 0;
	public static int totalFemales = 0;
	public static int totalAge = 0;
	
	
	public Person(String name, int age, boolean isfemale)
	{
		if (name == null) 
		{
			this.name = "unknown";
		}
		else
		{
			this.name = name;
		}
		
		if (age < 0)
		{
			this.age = 0;
		}
		else
		{
			this.age = age;
			totalAge += age;
		}
		
		if (isfemale == true)
		{
			this.isFemale = isfemale;
			totalFemales++;
			totalPerson++;
		}
		else
		{
			totalPerson++;
		}
		
	}
	
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		if (age > 0)
		{
			totalAge = totalAge - this.age;
			this.age = age;
			totalAge += age;
		}
	}
	
	public boolean getIsFemale()
	{
		return isFemale;
	}
	
	public void setIsFemale(boolean isFemale)
	{
		if (isFemale == true)
		{
			this.isFemale = isFemale;
			totalFemales++;
		}
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}
	
	public boolean equals(Person anotherPerson)
	{
		if (this.getAge() == anotherPerson.getAge() && this.getName() == anotherPerson.getName() && this.getIsFemale() == anotherPerson.getIsFemale())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean isYounger(Person anotherPerson)
	{
		if (this.getAge() < anotherPerson.getAge())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		String female;
		if (this.getIsFemale() == true)
		{
			female = "Female";
		}
		else 
		{
			female = "Male";
		}
		return "Name: " + this.getName() + "\nAge: " + this.getAge() + "\n" + female;
	}
	
	public static double aveAge()
	{
		return (double) totalAge/totalPerson;
	}
	
	public static int howManyPeople()
	{
		return totalPerson;
	}
	
	public static int howManyFemales()
	{
		return totalFemales;
	}
	
	
}
