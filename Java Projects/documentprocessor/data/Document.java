/*
		 * Document.java
		 * Author: Setul Patel
		 * Submission Date: 10-18-2013
		 * 
		 * Purpose: does all the calculations and organizing stuff.
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

import project5.documentprocessing.reader.DocumentReader;

public class Document {


	Word[] words;	 		// An array of Word objects representing the words in this document.
	String[] ignore;	 	// An array of Strings that should be ignored when this document is processed.
	DocumentReader docReader;	// A DocumentReader from which to read the lines of the document.
	int unique=0;	 	// An integer which counts the number of unique words seen.
	int numberoflines=0;	// An integer that stores the numbers of lines in the document.


	public Document(String url) 
	{
		//put your constructor definition here
		unique=0;	//different words
		numberoflines=0;	//number of lines
		words = new Word[10];	//word array
		ignore=new String[0];	//ignore list array
		docReader=new DocumentReader(url);

		processDocument();
		shrink();
		sort();
	}

	public Document(String url, String[] ignore) 
	{
		//put your constructor definition here
		
		//ignore list section
		this.ignore=ignore;
		docReader = new DocumentReader(url);
		words = new Word[10];
		numberoflines=0;
		unique=0;

		processDocument();
		shrink();
		sort();


	}


	public int getWordsSize() 
	{
		//put your method definition here

		int size;
		size = this.words.length;
		return size;	//returning size
	}

	public int getWordCount() 
	{
		//put your method definition here
		//returns wordCount
		return this.unique;	//returning word count
	}

	public int getLineCount() 
	{
		//put your method definition here
		return this.numberoflines;	//returning number of lines

	}

	private void expandWords() 
	{
		//put your method definition here
		Word[] expand = new Word[2*(words.length)];	//making the array twice as long
		for (int i=0; i<words.length; i++)
		{
			expand[i]=words[i];
		}
		this.words = expand;
	}

	private void shrink() 
	{
		//put your method definition here
		Word[] dubplicate;	//helps finding the values of null
		int finder=0;
		for(int j=0; j<words.length; j++)
		{
			if(words[j]==null)
			{
				finder++;
			}
		}
		dubplicate=new Word[words.length-finder];
		for(int j=0; j<dubplicate.length; j++)
		{
			dubplicate[j]=words[j];
		}
		this.words=dubplicate;
	}


	private String stripPunctuation(String w) //takes out all the punctuation 
	{
		//put your method definition here
		String strip="";
		for (int i=0; i < w.length(); i++)
		{
			char a = w.charAt(i);
			if (Character.isLetterOrDigit(a))
			{
				strip += a;
			}
		}
		return strip;
	}

	public boolean seenWord(String w) //checks to see if the value is used before
	{	
		//put your method definition here
		for (int i=0; i < this.words.length; i++)
		{
			if (this.words[i] != null)
			{
				String seenbefore = this.words[i].getWordValue();
				if (w.equalsIgnoreCase(seenbefore))
					return true;
			}
		}
		return false;
	}

	private void sort() //sorts the array
	{
		int min;
		Word temporary;
		this.shrink();
		for (int i = 0; i < this.words.length; i++) 
		{
			min = i;
			for (int j = i+1;j < this.words.length;j++) 
			{
				if (this.words[j].compareTo(this.words[min]) < 0) 
				{
					min = j ;
				}
			}
			temporary = this.words[min];
			this.words[min] = this.words[i];
			this.words[i] = temporary;
		}
	}


	private int findWord(String w) //compares all the values in the array
	{
		//put your method definition here
		for (int i=0; i < words.length; i++)
		{
			if (words[i]!= null)
			{
				if(w.equalsIgnoreCase(words[i].getWordValue()))
					return i;
			}
		}
		return -1;
	}
	
	private void addWord(String w) //adds a word
	{
		//put your method definition here
		if(w.length() == 0 || w.equals(""))
		{
			return;
		}
		for(int i=0; i<words.length; i++)
		{
			if(seenWord(w) == true)
			{
				int index = findWord(w);
				words[index].incrementFrequency();
				return;
			}
		}

		Word [] newwords = new Word[this.words.length+1];
		
		for(int i=0; i<this.words.length; i++)
		{
			newwords[i] = words[i];
		}
		
		newwords[newwords.length-1] = new Word(w);
		this.words = newwords;
		this.unique++;
	}

	private void processDocument() //processes the document
	{
		//put your method definition here
		shrink(); 
		while(docReader.hasLines()){
			String line = docReader.getLine().trim();
			this.numberoflines++;
			String temp = "[ ]";
			String[] inline = line.split(temp);
			for (int i=0; i < inline.length; i++)
			{
				inline[i] = stripPunctuation(inline[i]).toLowerCase().trim();
				int finding = findWord(inline[i]);
				addWord(inline[i]);
			}
		}
	}

	public String toString() //prints out everything
	{
		//put your method definition here
		String returnstring="Line Count: " + this.numberoflines + " Word Count: " + this.unique;
		shrink();
		for (int i=0; i < words.length; i++)
		{
			if (words[i].getFrequency()==1)
			{
				returnstring += "\nWord: " + words[i].getWordValue() + " Frequency: " + words[i].getFrequency();
			}
			else
			{
				returnstring += "\nWord: " + words[i].getWordValue() + " Frequency: " + (words[i].getFrequency());
			}
		}
		returnstring+="\nWords Size: " + this.unique;	
		return returnstring;

	}


}