import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TTT extends JFrame {

	JPanel panel= new JPanel();
	xoButton buttons []= new xoButton[9];
	public int row, column;
	public static Scanner scan= new Scanner(System.in);
	public static char[][] board = new char[3][3];
	static boolean playing=false;
	static char player = 'X';

	public static void main(String[] args) {
		
		for(int i=0;i<board.length;i++){
			for (int j=0;j<board[0].length;j++){
				board[i][j]='_';
			}
		}
		
		
		
		System.out.println("Do you want to begin playing TicTacToe? Hit Y to begin ");
		String inputBegin=scan.next();
		if(inputBegin.equals("Y")|inputBegin.equals("y")){
			new TTT();
			playing=true;
			printBoard();
			System.out.println();
			System.out.println("Beginning Play...");
			Play();
		}
		else if (inputBegin.equals("N")|inputBegin.equals("n")){
			playing=false;
			System.out.println("The game has been terminated");
		}
		else{
			playing=false;
			System.out.println("Doofus. Y or N only.");
		}
	}


	public TTT(){
		super("TTT");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		panel.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++){
			buttons[i]=new xoButton();
			panel.add(buttons[i]);
		}
		add(panel);
		setVisible(true);
		
	}
	
	public static void Play(){
		while(playing){
			System.out.println();
			System.out.println();
			System.out.println("Player "+player+", make your move.");
			System.out.println("Enter row : ");

			int row= scan.nextInt()-1;
			if (row>=board.length){
				System.out.println("Its a 3 x 3 board you, doofus. Can you count?");
				System.out.println("Try entering the row again");
				row=scan.nextInt()-1;
			}
			System.out.println("Enter column : ");
			int column=scan.nextInt()-1;
			if (column>=board[0].length){
				System.out.println("Its a 3 x 3 board you, doofus. Can you count?");
				System.out.println("Try entering the column again");
				column=scan.nextInt()-1;
			}


			if(board[row][column]!='_'){
				System.out.println("Sorry, cannot place in this column.");
				System.out.println("Re-enter row ");
				row=scan.nextInt()-1;
				System.out.println("Re-enter column ");
				column=scan.nextInt()-1;
				board[row][column]=player;
			}
			else{
				board[row][column]= player;
			}

			if(!isGameOver(row,column)&&!isSpaceOver()){
				printBoard();

				if(player=='X'){
					player='O';
				}
				else{
					player='X';
				}
			}

			else{
				printBoard();
				System.out.println();
				if (isSpaceOver()){
					System.out.println("Outta space kids! You're both losers");
					playing = false;
				}
				else{
				System.out.println("GAME OVER! Player "+player+" whooped someone's behind!");
				playing=false;
				}
			}
		}
	}


	private static boolean isSpaceOver() {
		//test if all spaces have been filled
				int count=0;
				for(int i=0;i<board.length;i++){
					for (int j=0;j<board.length;j++){
						if (board[i][j]=='_'){
							count=count+1;
						}
						
					}
				}
				if (count<=0){
					return true;
				}
		return false;
	}


	public static void printBoard(){
		for (int i=0; i<board.length;i++){
			System.out.println();
			for(int j=0;j<board[0].length;j++){
				if(j==0){
					System.out.print(" | ");
				}
				System.out.print(board[i][j]+" | ");

			}
		}
	}

	public static boolean isGameOver(int row, int column){

		//for horizontal win
		if(board[row][0]==board[row][1] && board[row][0]==board[row][2]){
			return true;
		}

		//for vertical win
		if(board[0][column]==board[1][column] && board[0][column]==board[2][column]){
			return true;
		}

		//for diag win
		if(board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[1][1]!='_'){
			return true;
		}

		return false;
	}


}
