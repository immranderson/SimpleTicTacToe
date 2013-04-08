package com.immranderson.tictactoe;

public class Logic {


	public static boolean check_if_win(Grid board)
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

	public static void computer_move(String input, Grid board){
		
		int i = (int)(3*Math.random());
		int j = (int)(3*Math.random());
		
		if (board.getBoard()[i][j].equals("N"))
		{
			board.Set(input, i, j);
		}
		else
		{
			//System.out.println("Did Nothing");
			computer_move(input, board);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Grid board = new Grid();	

		computer_move("X", board);
		
		computer_move("O", board);
		
		computer_move("X", board);
		
		computer_move("O", board);
		
		computer_move("X", board);
		
		computer_move("O", board);
		
		computer_move("X", board);
		
		computer_move("O", board);
		
		computer_move("X", board);
		
		board.Display();
		
		if (check_if_win(board))
		{
			System.out.println("WINNER");
		}
		else
		{
			System.out.println("TIE");
		}
		

	}

}

