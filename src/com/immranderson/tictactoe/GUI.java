package com.immranderson.tictactoe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {

	private JButton[][] buttonarray;
	private JPanel master;
	private Grid board;
	private Logic logic;

	public GUI(){

		board = new Grid();
		logic = new Logic(board);

		master = new JPanel (new GridLayout(3,3));
		buttonarray = new JButton[3][3];

		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				buttonarray[i][j] = new JButton (board.getBoard()[i][j]);

				buttonarray[i][j].addActionListener(this);

				master.add(buttonarray[i][j]);
			}
		}



		this.setResizable(false);
		this.setSize(600, 600);
		this.add(master);
		this.setVisible(true);

	}

	public static void main(String[] args){

		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub

		if (logic.can_move())
		{		
			for (int i=0; i<3; i++)
			{
				for (int j=0; j<3; j++)
				{
					if (event.getSource().equals(buttonarray[i][j]))
					{
						System.out.println("Player Move");
						board.Set("X", i, j);					
						board.Display();
						System.out.println("--------");
					}
				}
			}

			for (int i=0; i<3; i++)
			{
				for (int j=0; j<3; j++)
				{
					buttonarray[i][j].setText(board.getBoard()[i][j]);
				}
			}

			if (logic.can_move())
			{

				for (int i=0; i<3; i++)
				{
					for (int j=0; j<3; j++)
					{
						if (event.getSource().equals(buttonarray[i][j]))
						{
							System.out.println("Computer Move");
							logic.computer_move("O");
							board.Display();
							System.out.println("--------");
						}
					}
				}
				
				for (int i=0; i<3; i++)
				{
					for (int j=0; j<3; j++)
					{
						buttonarray[i][j].setText(board.getBoard()[i][j]);
					}
				}
			}

			else
			{
				if(logic.check_if_win())
				{
					System.out.println("WIN!");
				}
			}
		}


	}



}


