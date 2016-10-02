package Relation;

/*****************************************************************************************
 * @file  TestTupleGenerator.java
 *
 * @author   Sadiq Charaniya, John Miller
 */

import static java.lang.System.out;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/*****************************************************************************************
 * This class tests the TupleGenerator on the Student Registration Database defined in the
 * Kifer, Bernstein and Lewis 2006 database textbook (see figure 3.6).  The primary keys
 * (see figure 3.6) and foreign keys (see example 3.2.2) are as given in the textbook.
 */
public class TestTupleGenerator
{
	/*************************************************************************************
	 * The main method is the driver for TestGenerator.
	 * @param args  the command-line arguments
	 */
	public static void main (String [] args)
	{
		TupleGenerator test = new TupleGeneratorImpl ();

		test.addRelSchema ("Student", 
				"id name address status",
				"Integer String String String",
				"id",
				null);
		// create a Table for Student...
		Table Student = new Table("Student", "id name address status", "Integer String String String", "id");
		//------------------------------------------------------------------------------------------------------------
		test.addRelSchema ("Professor",
				"id name dId",
				"Integer String String",
				"id",
				null);
		// create a Table for Professor...
		Table Professor = new Table("Professor", "id name dId", "Integer String String", "id");
		//------------------------------------------------------------------------------------------------------------
		test.addRelSchema ("Course",
				"crsCode deptId crsName descr",
				"String String String String",
				"crsCode",
				null);
		// create a Table for Course...
		Table Course = new Table("Course", "crsCode deptId crsName descr", "String String String String", "crsCode");
		//------------------------------------------------------------------------------------------------------------
		test.addRelSchema ("Teaching",
				"crsCode semester profId",
				"String String Integer",
				"crcCode semester",
				new String [][] {{ "profId", "Professor", "id" },
				{ "crsCode", "Course", "crsCode" }});
		// create a Table for Teaching...
		Table Teaching = new Table("Teaching", "crsCode semester profId", "String String Integer", "crsCode semester");
		//------------------------------------------------------------------------------------------------------------		
		test.addRelSchema ("Transcript",
				"studId crsCode semester grade",
				"Integer String String String",
				"studId crsCode semester",
				new String [][] {{ "studId", "Student", "id"},
				{ "crsCode", "Course", "crsCode" },
				{ "crsCode semester", "Teaching", "crsCode semester" }});
		// create a Table for Transcript...
		Table Transcript = new Table("Transcript", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");

		
		
		String [] tables = { "Student", "Professor", "Course", "Teaching", "Transcript" };

		double startTime = 0;										
		double endTime = 0;
		double deltaTime = 0;
		int count = 0;														
		Random rando = new Random();										// to produce random integers


		for(int a = 100000; a <= 2000000; a += 100000){						// 20 iterations from 100,000 to 2,000,000
																			// change if desired

			// Change size of tups to 'a' when testing respective tables
			// Otherwise, 1 tuple will be generated for their respective table
			int tups [] = new int [] { a, 1, 1, 1, 1 };
			Comparable [][][] resultTest = test.generate (tups);			// generates tuples


			for (int i = 0; i < resultTest[0].length; i++) {				
				Student.insert(resultTest[0][count]);						// inserts tuples into Student
				//Professor.insert(resultTest[1][count]);					// inserts tuples into Professor
				//Course.insert(resultTest[2][count]); 						// inserts tuples into Course
				//Teaching.insert(resultTest[3][count]);					// inserts tuples into Teaching
				//Transcript.insert(resultTest[4][count]);					// inserts tuples into Transcript
				count++;
			}
			count = 0;


			// UNCOMMENT THIS FOR LIN HASH MAP JOIN TESTING
			//			Comparable[] tup1 = { 1, "Jayesh", "Athens", "Senior"};
			//			Comparable[] tup2 = { 1, "CSCI 4370", "Summer", "A"};
			//			
			//			for(int d = 0; d < resultTest[0].length; d++){
			//				Student.insert(tup1);
			//				Transcript.insert(tup2);
			//			}


			// UNCOMMENT THIS FOR RANGE QUERY TESTING
			//			int rand1;
			//			int rand2;
			//
			//			do{
			//				rand1 = rando.nextInt(a);
			//				rand2 = rando.nextInt(a);
			//				int temp = 0;
			//
			//				if(rand1 < rand2){
			//					break;
			//				}
			//				else if(rand1 > rand2){
			//					temp = rand2;
			//					rand2 = rand1;
			//					rand1 = temp;
			//					break;
			//				}
			//
			//			}while(rand1 == rand2);
			//
			//			for(int d = 0; d < 10; d++){
			//
			//				startTime = System.nanoTime();
			//				for(int i = rand1; i <= rand2; i++){
			//					Student.select (new KeyType (resultTest[0][i][0]));
			//					int z = i;
			//					//Student.select( t -> t[Student.col("id")].equals ( String.valueOf(z) ) );
			//				}
			//				
			//				endTime = System.nanoTime();
			//				deltaTime = (endTime - startTime) / 1000000;
			//				System.out.println(deltaTime + ", " + a);
			//			}


			// THIS IS FOR POINT QUERY TESTING AND JOIN TESTING
			for(int i = 0; i < 10; i++){	
				
				int randomStudent = rando.nextInt(a);							// use for select, produces random int
				startTime = System.nanoTime();									// start timer

				Student.select (new KeyType (resultTest[0][randomStudent][0]));
				// Student.join("id" , "studId", Transcript);
				// Student.select( t -> t[Student.col("id")].equals ( String.valueOf(randomStudent) ) );

				endTime = System.nanoTime();									// end timer
				deltaTime = (endTime - startTime) / 1000000;					// divide by million to get millisecond
				System.out.println(deltaTime + ", " + a);						// print out time (ms) and size of table
				
			}

			// PRINTS INDEX OF STUDENT TABLE
			// USE FOR WHATEVER TABLE DESIRED
			// Student.printIndex(); 
			
		}






	} // main

} // TestTupleGenerator
