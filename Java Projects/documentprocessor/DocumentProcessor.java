/*
		 * DocumentProcessor.java
		 * Author: Setul Patel
		 * Submission Date: 10-18-2013
		 * 
		 * Purpose: the running program.
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
package project5.documentprocessing;

import project5.documentprocessing.data.Document;

public class DocumentProcessor {

	public static void main(String[] args) {
		if (args.length == 1) 
		{
			Document d = new Document(args[0]);					
			System.out.println(d);
		}
		else 
		{
			System.out.println("Must provide an url as command-line argument.");
		}

	}

}