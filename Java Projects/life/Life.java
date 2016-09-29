import java.util.Scanner;
import java.util.Random;
public class Life {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Life.java
		 * Author: Setul Patel
		 * Submission Date: 10-6-2013
		 * 
		 * Prupose: to learn how to use for and while loops and create nested loops. 
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
		
		int gridSize = 200;
		int cellSize = 3;
		int aliveColor = 1;
		int deadColor  = 0;
		int col;
		int row;
		
		boolean forever = true;
		
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life"); 
		grid.setDelay(10);
		
		for (col= 25; col <= 75; col++)
		{
			grid.setPos(10,col,aliveColor);
		}
		grid.update();
		
		grid.clearGrid();
		
		Random r = new Random();
		
		for (row = 0; row < gridSize; row++)
		{
			for (col = 0; col < gridSize; col++)
			{
				if (r.nextInt(200) > 100)
				{
					grid.setPos(row, col, aliveColor);
				}
				else 
				{
					grid.setPos(row, col, deadColor);
				}
				//grid.update();

			}
		}
		grid.update();
		grid.initialize();
		
		while (forever == true) 
		{
			for(row = 0; row < gridSize; row++)
			{
				for(col = 0; col < gridSize; col++)
				{
					if (grid.getPos(row, col) == aliveColor) 
					{
						if (grid.matchingNeighbors(row, col, aliveColor) == 2 || grid.matchingNeighbors(row, col, aliveColor) == 3) 
						{
							grid.setPos(row, col, aliveColor);
						}
						else 
						{
							grid.setPos(row,col, deadColor); 
						}
					}
					else 
					{
						if (grid.matchingNeighbors(row, col, aliveColor) == 3) 
						{
							grid.setPos(row, col, aliveColor);
						}
						else 
						{ 
							grid.setPos(row, col, deadColor);
						}
					}
				}	
			}
			grid.update();
			
		}
		
		
	}

}
