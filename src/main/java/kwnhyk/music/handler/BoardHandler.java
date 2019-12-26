package kwnhyk.music.handler;

import java.util.Scanner;

import kwnhyk.music.domain.BoardInfo;

public class BoardHandler {
	final static int BOARD_SIZE = 100;
	 int boardCount= 0;
	public static Scanner keyboard ;
	 BoardInfo[] boards = new BoardInfo[BOARD_SIZE];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		

	}

	
	public static  void addBoard(BoardHandler boardHandler) {
		
		
		
	  BoardInfo board = new BoardInfo();
	  System.out.println("번호>");
	  board.num = keyboard.nextInt();
	  keyboard.nextLine();
	  System.out.println("제목>");
	  board.title = keyboard.nextLine();
	  System.out.println("내용>");
	  board.contents = keyboard.nextLine();
	  boardHandler.boards[boardHandler.boardCount] = board;
	  boardHandler.boardCount ++;
	  System.out.println("저장");
	  
	}
	
	public static void listBoard(BoardHandler boardHandler) {
		for(int i=0 ; i<boardHandler.boardCount;i++) {
		BoardInfo b = boardHandler.boards[i];
		System.out.printf("%d %s %s ", b.num,b.title,b.contents);
		
		
		
	}
}
}