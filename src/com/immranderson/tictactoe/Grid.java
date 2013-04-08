package com.immranderson.tictactoe;

public class Grid {

	String[][] grid;
	
	public Grid(){
		this.grid = new String[3][3];
		
		for (int i = 0; i<3; i++)
			for (int j = 0; j<3; j++)
				this.grid[i][j] = "N";
	}
	
	public void Set(String input, int i, int j){
		
		if (input.equals("X") || input.equals("O"))
			this.grid[i][j] = input;
		else
			System.out.println("Not Valid Input");		
	}
	
	public void Set(String[][] input){
		this.grid = input;
	}
	
	public void Display(){
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				System.out.print(this.grid[i][j]);
			}
			System.out.println();
		}
	}
	
	public String[][] getBoard(){
		return this.grid;		
	}
	
	public String getMarkAt(int i, int j){
		
		return this.grid[i][j];
		
	}
	
	public static void main(String[] args) {
		

	}

}
