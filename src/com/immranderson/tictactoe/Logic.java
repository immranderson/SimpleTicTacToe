package com.immranderson.tictactoe;

public class Logic {


	Grid board;
	
	public Logic(Grid board){
		this.board = board;
	}
	
	public boolean check_if_win()
	{
		//Winning Logic

		//Vertical Line Check
		for (int i=0; i<3; i++)
		{
			if (board.getMarkAt(i, 0).equals(board.getMarkAt(i, 1)) && board.getMarkAt(i, 0).equals(board.getMarkAt(i, 2)))
			{
				return true;
			}
		}

		//Horizontal Line Check
		for (int j=0; j<3; j++)
		{
			if (board.getMarkAt(0, j).equals(board.getMarkAt(1, j)) && board.getMarkAt(0, j).equals(board.getMarkAt(2, j)))
			{
				return true;
			}
		}

		//Diagonal One Check

		if (board.getMarkAt(0, 0).equals(board.getMarkAt(1, 1)) && board.getMarkAt(0, 0).equals(board.getMarkAt(2, 2)))
		{
			return true;
		}

		//Diagonal Two Check

		if (board.getMarkAt(2, 0).equals(board.getMarkAt(1, 1)) && board.getMarkAt(1, 1).equals(board.getMarkAt(0, 2)))
		{
			return true;
		}

		return false;
	}
	
	public boolean can_move()
	{	
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if (board.getMarkAt(i, j).equals(" "))
				{
					System.out.println("Can Move!");
					return true;
				}
			}
		}
		return false;
	}

	public void computer_move(String input){
		
		int i = (int)(3*Math.random());
		int j = (int)(3*Math.random());

		if (board.getBoard()[i][j].equals(" "))
		{
			board.Set(input, i, j);
		}
		else
		{
			computer_move(input);
		}
	}
}
