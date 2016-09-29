/*
		 * Word.java
		 * Author: Setul Patel
		 * Submission Date: 10-18-2013
		 * 
		 * Purpose: does all the things with words. 
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
package project5.documentprocessing.data;

public class Word implements Comparable<Word> {


	private String word=new String(); 
	private int frequency = 0;
	
	// Add the constructor and other instance methods
	public Word(String word) //constructor of the class
	{
		this.word = word;
		frequency = 1;
	}
	
	public boolean equals(Word w) //equals method 
	{
		this.word.toLowerCase();
		if (word.equals(w))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getWordValue() //retrieves all the word values
	{
		return this.word;
	}

	public int getFrequency() //gets the frequency of the value
	{
		return this.frequency;
	}

	public void incrementFrequency() //gets the increment frequency
	{
		this.frequency++;
	}

	public int compareTo(Word w) //compares the values
	{
		return(this.getWordValue().compareToIgnoreCase(w.getWordValue()));
	}

}
