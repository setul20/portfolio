import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;

public class assignment1 
{
	
	public int number_embed(ArrayList a)
	{
		//if (size(a) == 1)
		return 0;
	}
	
	public static ArrayList my_difference(ArrayList a, ArrayList b)
	{
		if(b.size()>=a.size())
		{
			b.removeAll(a);
			System.out.println(b);
			return b;
		}
		a.removeAll(b);
		System.out.println(a);
		return a;
	}
	
	public static void occurences(ArrayList a)
	{
		Set<String> unique = new HashSet(a);
		for(String temp : unique)
		{
			System.out.println(temp + ": "+ Collections.frequency(a,temp));
		}
		
	}
	
	public static boolean my_palindrome(ArrayList a)
	{
		int start = 0;
		int end = a.size()-1;
		
		while (start < end)
		{
			if(!a.get(start++).equals(a.get(end--)))
			{
				System.out.println("F");
				return false;
			}
		}
		System.out.println("T");
		return true;
	}
	
	public static void subset(ArrayList a)
	{				
		if (!a.isEmpty())
		{
			System.out.println(a.subList(0, 5));
			for(int i = 0; i < a.size(); i++)
			{
				System.out.print("(" + a.get(i)+ ")");
			}
		}
		
		
	}

	public static void main(String[] args) 
	{
		ArrayList test = new ArrayList();
		ArrayList test1 = new ArrayList();
		
		test.add("a");
		test.add("d");
		test.add("c");
		test.add("d");
		test.add("a");
		
		test1.add("a");
		test1.add("s");
		test1.add("b");
		test1.add("x");
		test1.add("c");

				
		System.out.print("Is test a palindrome: ");
		my_palindrome(test);
		System.out.println();
		
		System.out.println("subsets: ");
		subset(test);
		
		System.out.println();
		System.out.println();
		System.out.println("Occurences: ");
		occurences(test);
		
		System.out.println();
		System.out.println("Differences: ");
		my_difference(test, test1);
		
		
	}
}
