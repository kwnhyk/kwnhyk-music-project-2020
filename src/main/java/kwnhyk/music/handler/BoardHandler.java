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
		BoardInfo[] boards = new BoardInfo[this.boardList.size()];
		this.boardList.toArray(boards);
		for(BoardInfo b : boards) {
		System.out.printf("%d %s %s ", b.getNum(), b.getTitle(), b.getContents());
		
		
		
	}
}
	public void detailBoard() {
	    System.out.print("게시글 번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    int index = indexOfBoard(no);
	
	    
	    if (index ==-1) {
	      System.out.println(" 번호 유효하지 않습니다.");
	      return;
	    }
	    BoardInfo board = this.boardList.get(index);
	    System.out.printf("번호: %d\n", board.getNum());
	    System.out.printf("제목: %s\n", board.getTitle());
	    System.out.printf("내용: %s\n", board.getContents());
	  }
	  
	  public void updateBoard() {
	    System.out.print("게시글 번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
	   int index = indexOfBoard(no);
	    
	    if (index ==-1) {
	      System.out.println("게시글 번호 유효하지 않습니다.");
	      return;
	    }
	    BoardInfo oldBoard = this.boardList.get(index);
	    System.out.printf("내용(%s)? ", oldBoard.getContents());
	    String contents = input.nextLine();
	    
	    if (contents.length() == 0) {
	      System.out.println("게시글 변경을 취소했습니다.");
	      return;
	    }
	    
	    BoardInfo newBoard = new BoardInfo();
	    newBoard.setNum(oldBoard.getNum());
	    newBoard.getTitle();
	    newBoard.setContents(contents);
	    this.boardList.set(index, newBoard);
	    
	    System.out.println("게시글을 변경했습니다.");
	  }
	  
	  public void deleteBoard() {
	    System.out.print("게시글 인덱스? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    int index = indexOfBoard(no);
	
	    
	    if (index == -1) {
	      System.out.println("게시글 인덱스가 유효하지 않습니다.");
	      return;
	    }
	   
	    this.boardList.remove(index);
	    
	    System.out.println("게시글을 삭제했습니다.");
	  }
	  private int indexOfBoard(int no) {
		  for(int i =0;i<this.boardList.size();i++) {
			  if(this.boardList.get(i).getNum()==no) {
				  return i;
			  }
		  }
		  return -1;
	  }

}