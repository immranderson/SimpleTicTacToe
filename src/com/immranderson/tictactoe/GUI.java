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

	public GUI(){

		board = new Grid();

		master = new JPanel (new GridLayout(3,3));
		buttonarray = new JButton[3][3];

		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				
				if (board.getBoard()[i][j].equals("N"))
				{
					buttonarray[i][j] = new JButton("");
				}
				else
				{
					buttonarray[i][j] = new JButton (board.getBoard()[i][j]);
				}
				
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

		boolean has_N = false;
		boolean check = false;

		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if (board.getBoard()[i][j].equals("N"))
					check = true;

				has_N = has_N || check;
			}
		}

		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{

				if (has_N)
				{
					if (event.getSource().equals(buttonarray[i][j]))
					{
						System.out.println("Player Move");
						board.Set("X", i, j);					
						board.Display();
						System.out.println("--------");

						System.out.println("Computer Move");
						Logic.computer_move("O", board);
						board.Display();
						System.out.println("--------");
					}
				}

				else
				{
					Logic.check_if_win(board);
				}
			}
		}

		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if (board.getBoard()[i][j].equals("N"))
				{
					buttonarray[i][j].setText("");
				}
				else
				{
					buttonarray[i][j].setText(board.getBoard()[i][j]);
				}
			}
		}
	}



}


