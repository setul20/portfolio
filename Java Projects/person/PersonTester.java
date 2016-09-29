/*
		 * Person.java
		 * Author: Setul Patel
		 * Submission Date: 11-3-2013
		 * 
		 * Purpose: the driving file that takes information from the other and uses to print out results. 
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
public class PersonTester {

	public static void main(String[] args) {

		Person person1 = new Person("Marcus Smith", 23, false);
		Person person2 = new Person("Mary Brown", 21, true);
		Person person3 = new Person("Pat", 40, false);
		Person person4 = new Person("Marcus Smith", 25, false);
		
		System.out.println("person1 = \n" + person1 + "\n"); 
		System.out.println("person2 = \n" + person2 + "\n");
		System.out.println("person3 = \n" + person3 + "\n"); 
		System.out.println("person4 = \n" + person4 + "\n");
		
		person1.setAge(25);
		
		System.out.println("person1's age is " + person1.getAge());
		
		person2.setAge(-12);
		
		System.out.println("person2's age is " + person2.getAge());
		
		person3.setName(null);
		person3.setIsFemale(true);
		
		System.out.println();
		System.out.println("person3 = \n" + person3 + "\n");
		
		System.out.println("person4 younger then person3? " + person4.isYounger(person3));
		System.out.println();
		
		System.out.println("person1 equals person4? " + person1.equals(person4));
		System.out.println();
		
		System.out.println("# of People:\t" + Person.howManyPeople());
		
		System.out.println("# of Females:\t" + Person.howManyFemales());
		System.out.println();
		
		System.out.println("Avg Age: " + Person.aveAge());
		
	}

}
