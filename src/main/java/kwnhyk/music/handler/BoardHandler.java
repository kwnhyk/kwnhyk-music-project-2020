package kwnhyk.music.handler;

import java.util.Scanner;


import kwnhyk.music.domain.BoardInfo;

public class BoardHandler {
	  Scanner input ;
	ArrayList boardList;
	 public BoardHandler(Scanner input) {
			this.input = input;
			 this.boardList = new ArrayList();
		}
	
	public   void addBoard( ) {
		
		
		
	  BoardInfo board = new BoardInfo();
	  System.out.println("번호>");
	  board.setNum(Integer.parseInt(input.nextLine()));
	  
	  System.out.println("제목>");
	  board.setTitle(input.nextLine());
	  System.out.println("내용>");
		  board.setContents(input.nextLine());
		  
		  boardList.add(board);
	  System.out.println("저장");
	  
	}
	
	public  void listBoard() {
		Object[] boards = boardList.toArray();

		for(Object obj : boards) {
			BoardInfo b = (BoardInfo)obj;
		System.out.printf("%d %s %s ", b.getNum(), b.getTitle(), b.getContents());
		
		
		
	}
}
}