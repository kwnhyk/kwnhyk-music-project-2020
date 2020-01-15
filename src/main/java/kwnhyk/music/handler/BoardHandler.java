package kwnhyk.music.Handler;



import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.util.LinkedList;
import kwnhyk.music.util.Prompt;

public class BoardHandler {
	Prompt prompt;
	LinkedList<BoardInfo>boardList;
	 public BoardHandler(Prompt prompt) {
			this.prompt = prompt;
			 this.boardList = new LinkedList<>();
		}
	
	public   void addBoard( ) {
		
		
		
	  BoardInfo board = new BoardInfo();
	  board.setNum(prompt.inputInt("번호>"));
	  
	  board.setTitle(prompt.inputString("제목>"));
		  board.setContents(prompt.inputString("내용>"));
		  
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
	    int index = indexOfBoard(prompt.inputInt("게시글번호?"));
	
	    
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
	    
	   int index = indexOfBoard(prompt.inputInt("번호>"));
	    
	    if (index ==-1) {
	      System.out.println("게시글 번호 유효하지 않습니다.");
	      return;
	    }
	    BoardInfo oldBoard = this.boardList.get(index);
	    BoardInfo newBoard = new BoardInfo();
	    newBoard.setContents(prompt.inputString(String.format("내용(%s)?", oldBoard.getContents())
	    		, oldBoard.getContents()));
	    
	  
	    
	 
	    newBoard.setNum(oldBoard.getNum());
	    newBoard.getTitle();
	    if(newBoard.equals(oldBoard)) {
	    	System.out.println("변경취소");
	    return;	
	    }
	    
	    this.boardList.set(index, newBoard);
	    
	    System.out.println("게시글을 변경했습니다.");
	  }
	  
	  public void deleteBoard() {
	    int index = indexOfBoard(prompt.inputInt("게시글 번호?"));
	
	    
	    if (index == -1) {
	      System.out.println("게시글 번호 유효하지 않습니다.");
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