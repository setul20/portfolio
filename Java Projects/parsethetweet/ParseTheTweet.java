import java.util.Scanner;
public class ParseTheTweet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ParseTheTweet.java
		 * Author: Setul Patel
		 * Submission Date: 9-6-2013
		 * 
		 * Prupose: to use methods of the String class to process messages similar to TtT tweets.
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
		
	Scanner theScanner = new Scanner(System.in);
	String tweet = "";
	String type;
	String detail;
	String location;
	String latitudeString;
	String longitudeString;
	double latitude;
	double longitude;
	
	tweet = theScanner.nextLine();
	int start, finish;
	start = tweet.indexOf("#typ") + 5;
	finish = tweet.indexOf(";");
	type = tweet.substring(start,finish);
	type = type.trim();
	type = type.toUpperCase ();
	System.out.println("Type:" + "\t" + "\t" + type);
	tweet = tweet.substring(finish + 1);
	
	start = tweet.indexOf("#det") + 5;
	finish = tweet.indexOf(";");
	detail = tweet.substring(start,finish);
	detail = detail.trim();
	detail = detail.replace(',' , '-');
	System.out.println("Detail:" + "\t" + "\t" + detail);
	tweet = tweet.substring(finish + 1);
	
	start = tweet.indexOf("#loc") + 5;
	finish = tweet.indexOf(";");
	location = tweet.substring(start,finish);
	location = location.trim();
	location = location.replace(',' , '-');
	System.out.println("Location:" + "\t" + location);
	tweet = tweet.substring(finish + 1);
	
	start = tweet.indexOf("#lat") + 5;
	finish = tweet.indexOf(";");
	latitudeString = tweet.substring(start,finish);
	latitudeString = latitudeString.trim();
	System.out.println("Latitude:" + "\t" + latitudeString);
	tweet = tweet.substring(finish + 1);
	
	start = tweet.indexOf("#lng") + 5;
	finish = tweet.indexOf(";");
	longitudeString = tweet.substring(start,finish);
	longitudeString = longitudeString.trim();
	System.out.println("Longitude:" + "\t" + longitudeString);
	tweet = tweet.substring(finish + 1);
	
	theScanner = new Scanner(latitudeString);
	latitude = theScanner.nextDouble();
	
	theScanner = new Scanner(longitudeString);
	longitude = theScanner.nextDouble();
		
		
	}

}
