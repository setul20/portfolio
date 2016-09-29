/*
		 * Circle.java
		 * Author: Setul Patel
		 * Submission Date: 10-18-2013
		 * 
		 * Prupose: to classify the message category after the input.
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
public class Circle {
	

	private double radius;       // declare the private double instance  radius
	private double x;       // declare the private double instance  x
	private double y;       // declare the private double instance  y
	
	//----------------------------------------------
	// Class Constructor: set the initial values of
	//                    the instance variables
	//                    for this circle
	//----------------------------------------------	
	public Circle(double x, double y,double  radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;  	   	
	}
	
	
	//----------------------------------------------
	// getX - returns the value of x
	//----------------------------------------------
	public double getX() {
		return x;
		// Your code goes here	
	}
	

	//----------------------------------------------
	// getY - returns the value of y
	//----------------------------------------------
	public double getY() {
		return y;
		// Your code goes here	
	}
	
	//----------------------------------------------
	// getRadius - returns the value of radius
	//----------------------------------------------
	public double getRadius() {
		return radius;
		// Your code goes here	
	}

	//----------------------------------------------
	// setX - assigns a new value to x
	//----------------------------------------------
	public void setX(double xx) {
		x = xx;
		// Your code goes here	
	}
	

	//----------------------------------------------
	// setY - assigns a new value to y
	//----------------------------------------------
	public void setY(double yy) {
		y = yy;
		// Your code goes here	
	}	
	
	
	//----------------------------------------------
	// setRadius - assigns a new value to radius
	//----------------------------------------------
	public void setRadius(double radius1) {
		if (radius1 >= 0)
			radius = radius1;
		else 
			radius = radius;
		// Your code goes here	
	}
	
	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------
	public double diameter() {
		double diameter1;
		diameter1 = Math.abs(radius * 2);
		return diameter1;
		// Your code goes here	
	}
	

	//--------------------------------------------------------
	// area - returns the area of the circle
	//--------------------------------------------------------
	public double area() {
		double area1;
		area1 = Math.PI * (radius*radius);
		return area1;
		// Your code goes here	
	}

	//--------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	//--------------------------------------------------------
	public double perimeter() {
		double perimeter1;
		perimeter1 = 2 * Math.PI * (radius*radius);
		return perimeter1;
		// Your code goes here	
	}
	
	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	//                is 1 and its center is (0,0) and false
	//      	      otherwise.
	//--------------------------------------------------------
	public String isUnitCircle() {
		String unitcircle;
		if (radius == 1 && x==0 && y==0)
		{
			unitcircle = "is a unit circle";
			return unitcircle;
		}
		else 
		{
			unitcircle = "is not a unit circle";
			return unitcircle;
		}
		
			
		// Your code goes here	
	}
	
	
	//--------------------------------------------------------
	// toString - return a String representation of
	//            this circle in the following format:
	//            center:(x,y)
	//            radius: r
	//--------------------------------------------------------
	public String toString() 
	{
	
		return "center: (" + x + "," + y + ") \n radius: " + radius;
		
		// Your code goes here	
	}
	
	public boolean equals(Circle anotherCircle) 
	{
		if (this.getX() == anotherCircle.getX() && this.getY() == anotherCircle.getY() && this.getRadius() == anotherCircle.getRadius())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public boolean isConcentric(Circle anotherCircle)

	{
		if (this.getX() == anotherCircle.getX() && this.getY() == anotherCircle.getY() && this.getRadius() != anotherCircle.getRadius())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public double distance(Circle anotherCircle)
	{
		double xdistance = Math.pow(this.getX() - anotherCircle.getX(), 2);
		double ydistance = Math.pow(this.getY() - anotherCircle.getY(), 2);
		double circledistance = Math.sqrt(xdistance + ydistance);
		return circledistance;
	}
	
	public boolean intersects(Circle anotherCircle)
	{
		if (this.distance(anotherCircle) < (this.radius + anotherCircle.radius))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
		
		
	}


