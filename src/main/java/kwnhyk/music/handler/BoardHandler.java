package kwnhyk.music.handler;

import java.util.Scanner;


import kwnhyk.music.domain.BoardInfo;

public class BoardHandler {
	  Scanner input ;
	ArrayList<BoardInfo>boardList;
	 public BoardHandler(Scanner input) {
			this.input = input;
			 this.boardList = new ArrayList<>();
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
	public void detailBoard() {
	    System.out.print("게시글 인덱스? ");
	    int index = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
	    BoardInfo board = this.boardList.get(index);
	    
	    if (board == null) {
	      System.out.println("게시글 인덱스가 유효하지 않습니다.");
	      return;
	    }
	    
	    System.out.printf("번호: %d\n", board.getNum());
	    System.out.printf("제목: %s\n", board.getTitle());
	    System.out.printf("내용: %s\n", board.getContents());
	  }
	  
	  public void updateBoard() {
	    System.out.print("게시글 인덱스? ");
	    int index = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
	    BoardInfo oldBoard = this.boardList.get(index);
	    
	    if (oldBoard == null) {
	      System.out.println("게시글 인덱스가 유효하지 않습니다.");
	      return;
	    }
	    
	    System.out.printf("내용(%s)? ", oldBoard.getTitle());
	    String title = input.nextLine();
	    
	    if (title.length() == 0) {
	      System.out.println("게시글 변경을 취소했습니다.");
	      return;
	    }
	    
	    BoardInfo newBoard = new BoardInfo();
	    newBoard.setNum(oldBoard.getNum());
	    newBoard.setTitle(title);
	    newBoard.getContents();
	    this.boardList.set(index, newBoard);
	    
	    System.out.println("게시글을 변경했습니다.");
	  }
	  
	  public void deleteBoard() {
	    System.out.print("게시글 인덱스? ");
	    int index = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
	    BoardInfo board = this.boardList.get(index);
	    
	    if (board == null) {
	      System.out.println("게시글 인덱스가 유효하지 않습니다.");
	      return;
	    }
	    
	    this.boardList.remove(index);
	    
	    System.out.println("게시글을 삭제했습니다.");
	  }

}