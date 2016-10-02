public class randCFL {
	
	public static String replace(String s)
	{
		String rep = "";
		String [] p = {"N ","A P "};

		
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == 'P')
			{
				int p1 = (Math.random()<0.5)?0:1;
				if (p1 == 0)
				{
					rep = rep.concat(p[0]);
				}
				if (p1 == 1)
				{
					rep = rep.concat(p[1]);
				}
			}
			else if (s.charAt(i) != ' ')
			{
				rep = rep.concat(Character.toString(s.charAt(i))) + " ";	
			}
		}
		return rep;
		
	}
	
	public static String replaceterm(String m)
	{
		String result = "";
		String [] a = {"big ", "green "};
		String [] n = {"cheese ", "Jim "};
		String v = "ate ";
		for (int i = 0; i < m.length(); i++)
		{
			if (m.charAt(i) == 'A')
			{
				int r1 = (Math.random()<0.5)?0:1;
				if (r1 == 0)
				{
					result = result.concat(a[0]);
				}
				if (r1 == 1)
				{
					result = result.concat(a[1]);
				}
			}
			if (m.charAt(i) == 'N')
			{
				int r2 = (Math.random()<0.5)?0:1;
				if (r2 == 0)
				{
					result = result.concat(n[0]);
				}
				if (r2 == 1)
				{
					result = result.concat(n[1]);
				}
			}
			if (m.charAt(i) == 'V')
			{
				result = result.concat(v);
			}
		}
		
		
		
		return result;
	}
	
	public static boolean hasp(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == 'P')
			{
				return true;
			}
		}
		return false;
	}
	
	public static String elreplace(String s)
	{
		String rep = "";
		String [] p = {"N ","A P "};

		
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == 'P')
			{
				int p1 = (Math.random()<0.5)?0:1;
				if (p1 == 0)
				{
					rep = rep.concat(p[0]);
				}
				if (p1 == 1)
				{
					rep = rep.concat(p[1]);
				}
			}
			else if (s.charAt(i) != ' ')
			{
				rep = rep.concat(Character.toString(s.charAt(i))) + " ";	
			}
				System.out.print(rep + s.substring(i) + " => ");
		}
		return rep;
		
	}
	
	public static String elreplaceterm(String m)
	{
		String result = "";
		String [] a = {"big ", "green "};
		String [] n = {"cheese ", "Jim "};
		String v = "ate ";
		for (int i = 0; i < m.length(); i++)
		{
			if (m.charAt(i) == 'A')
			{
				int r1 = (Math.random()<0.5)?0:1;
				if (r1 == 0)
				{
					result = result.concat(a[0]);
				}
				if (r1 == 1)
				{
					result = result.concat(a[1]);
				}
			}
			if (m.charAt(i) == 'N')
			{
				int r2 = (Math.random()<0.5)?0:1;
				if (r2 == 0)
				{
					result = result.concat(n[0]);
				}
				if (r2 == 1)
				{
					result = result.concat(n[1]);
				}
			}
			if (m.charAt(i) == 'V')
			{
				result = result.concat(v);
			}
			
			System.out.print(result + m.substring(i) + " => ");
			
		}
		
		
		
		return result;
	}
	
	public static void elaborate(String s)
	{
		while(hasp(s))
		{
			s = elreplace(s);
		}
		s = elreplaceterm(s);
		System.out.print(s);
	}
	
	public static void printsent(String s)
	{
		while(hasp(s))
		{
			s = replace(s);
		}
		s = replaceterm(s);
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		String arg1 = args[0];
		String arg2 = args[1];
		int num;

		if(args.length == 3)
		{
			String arg3 = args[2];
			num = Integer.parseInt(arg3);
		}
		else
			num = Integer.parseInt(arg2);

		
				
		String sam = "P V P";
		if (arg1.equals("-t"))
		{
			System.out.print("Start ");
			elaborate(sam);
		}
		
		for (int i = 0; i < num; i++)
		{
			if (arg1.equals("-t"))
			{
				System.out.print("Start ");
				elaborate(sam);
				System.out.println();
			}
			else
				printsent(sam);
		}
		
	}

}
