package kwnhyk.music.handler;

import java.util.Scanner;


import kwnhyk.music.domain.BoardInfo;

public class BoardHandler {
	final static int BOARD_SIZE = 100;
	 int boardCount= 0;
	  Scanner input ;
	 BoardInfo[] boards ;
	
	 public BoardHandler(Scanner input) {
			this.input = input;
			 this.boards = new BoardInfo[BOARD_SIZE];
		}
	
	public   void addBoard( ) {
		
		
		
	  BoardInfo board = new BoardInfo();
	  System.out.println("번호>");
	  board.setNum(Integer.parseInt(input.nextLine()));
	  
	  System.out.println("제목>");
	  board.setTitle(input.nextLine());
	  System.out.println("내용>");
	  	board.setContents(input.nextLine());
	  this.boards[this.boardCount] = board;
	  this.boardCount ++;
	  System.out.println("저장");
	  
	}
	
	public  void listBoard() {
		for(int i=0 ; i<this.boardCount;i++) {
		BoardInfo b = this.boards[i];
		System.out.printf("%d %s %s ", b.getNum(), b.getTitle(), b.getContents());
		
		
		
	}
}
}