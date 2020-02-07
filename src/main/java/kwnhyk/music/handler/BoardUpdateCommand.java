package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.util.Prompt;

public class BoardUpdateCommand implements Command {
	Prompt prompt;
	List<BoardInfo> boardList;
	public BoardUpdateCommand(Prompt prompt ,List<BoardInfo> list) {

		this.prompt = prompt;
		this.boardList = list;


	}



	@Override
	public void excute() {

	    
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
		  
	

	private int indexOfBoard(int no) {
		for (int i = 0; i < this.boardList.size(); i++) {
			if (this.boardList.get(i).getNum() == no) {
				return i;
			}
		}
		return -1;
	}

}