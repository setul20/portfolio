//*******************************************************
// CircleTester.java
//
//
//  A client to test the functionality of objects
//  of the class Circle
// 
//*******************************************************
public class CircleTester{
	
	public static void main(String[] args) {
		
		Circle circle1= new Circle(0.0,0.0,2);
		Circle circle2= new Circle(2.0,1.0,1);
		
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
		
		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		//
		circle1.setRadius(-2.0); 
		
		//
		// Reset the center of circle1 (-3.0,4.0)
		//
		circle1.setX(-3.0);
		circle1.setY(4.0);
		
		
		// print circle1 characteristics (center and radius), use a statement similar 
		// to the previous println statements. Note that is not necessary to call
		//the method toString, why?
		
		System.out.println("circle1=" + circle1);
		
		// set the circle2 radius to 5.3
		
		circle2.setRadius(5.3);
		
		// print circle2 characteristics (center and radius), use a statement similar to the first and
		// second println statements
		
		System.out.println("circle2=" + circle2);
		
		// print circle1 diameter, area and perimeter
		
		System.out.println();
		System.out.println("circle1: ");
		System.out.println("diameter="+circle1.diameter());
		System.out.println("area="+circle1.area());
		System.out.println("perimeter="+circle1.perimeter());
		
		// print circle2 diameter, area and perimeter
		
		System.out.println();
		System.out.println("circle2: ");
		System.out.println("diameter="+circle2.diameter());
		System.out.println("area="+circle2.area());
		System.out.println("perimeter="+circle2.perimeter());
		
		// display whether circle1 is a unit circle
		
		System.out.println();
		System.out.println("circle1 " + circle1.isUnitCircle());
		
		// display whether circle2 is a unit circle
		
		System.out.println("circle2 " + circle2.isUnitCircle());
		
		// your additional tests should be placed below here
				
		System.out.println();
		if (circle1.isConcentric(circle2) == true)
		{
			System.out.println("Circle1 is not a concentric circle to circle 2.");
		}
		else 
		{
			System.out.println("Circle1 is concentric circle to circle2.");
		}
		
		
		System.out.println("The distance between circle1 and circle2 is: " + circle1.distance(circle2));
		
		if (circle1.intersects(circle2) == true)
		{
			System.out.println("circle1 intersects circle2");
		}
		else
		{
			System.out.println("circle1 does not intersects circle2");
		}
		
		if (circle1.equals(circle2) == true)
		{
			System.out.println("circle1 and circle2 are the same circle.");
		}
		else 
		{
			System.out.println("circle1 and circle2 are not the same circle.");
		}
	}
	
	
}
