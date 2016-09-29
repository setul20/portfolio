/*
		 * Stat.java
		 * Author: Setul Patel
		 * Submission Date: 10-25-2013
		 * 
		 * Purpose: learn how to use constructors, access modifiers, instance variables, methods, and mutators and accessors. 
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

import java.util.Arrays;
public class Stat {
	
	private double[] data;
	
	public Stat()
	{
		data = new double[1];
		data[1] = 0.0;
	}
	
	public Stat(double [] d)
	{
		double[] arrayD = new double[d.length];
		for (int i = 0; i < d.length; i++) 
		{
			arrayD[i] = d[i];
		}
		data = arrayD;
	}
	
	public double[] getData()
	{
		double[] arraydata = new double[data.length];
		for (int i = 0; i < data.length; i++) 
		{
			arraydata[i] = data[i];
		}
		return arraydata;
	}
	
	public void setData(double[] d) 
	{
		double[] arrayD = new double[d.length];
		for (int i = 0; i < d.length; i++) 
		{
			arrayD[i] = d[i];
		}
		data = arrayD;
	}
	
	public boolean equals(Stat s) 
	{
		if (this != null && this.getData() != null && s != null && s.getData() != null) 
		{
			if (this.getData().length != s.getData().length) 
			{
				return false;
			} 
			else 
			{
				for (int i = 0; i < this.getData().length; i++) 
				{
					if (this.getData()[i] != s.getData()[i]) 
					{
						return false;
					}
				}
				return true;
			}
		} 
		else 
		{
			return false;
		}
	}
		
	@Override
	public String toString() 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (int i = 0; i < this.getData().length; i++) 
		{
			buffer.append(this.getData()[i]);
			if (i != this.getData().length - 1) 
			{
				buffer.append(", ");
			} 
			else 
			{
				buffer.append("]\n");
			}
		}
		return buffer.toString();
	}
	
	public double min() 
	{
		double minValue = this.getData()[0];
		for (int i = 1; i < this.getData().length; i++) 
		{
			if (this.getData()[i] < minValue) 
			{
				minValue = this.getData()[i];
			}
		}
		return minValue;
	}
	
	public double max() 
	{
		double maxValue = this.getData()[0];
		for (int i = 1; i < this.getData().length; i++) 
		{
			if (this.getData()[i] > maxValue) 
			{
				maxValue = this.getData()[i];
			}
		}
		return maxValue;
	}
	
	public double average() 
	{
		double sum = 0;
		for (int i = 0; i < this.getData().length; i++) 
		{
			sum = sum + this.getData()[i];
		}
		double average = sum / this.getData().length;
		return average;
	}
	
	public double mode() 
	{
		Arrays.sort(data);

		int co2 = 0;
		int co1 = 0;
		double p1 = 0;
		double p2 = 0;

		for (int i = 0; i < data.length; i++) 
		{
			p1 = data[i];
			co1 = 1;

			for (int j = i + 1; j < data.length; j++) 
			{
				if (p1 == data[j])
					co1++;
			}

			if (co1 > co2) 
			{
				p2 = p1;
				co2 = co1;
			}

			else if (co1 == co2) 
			{
				p2 = Double.NaN;
			}
		}

		return p2;
	}
	

}	
