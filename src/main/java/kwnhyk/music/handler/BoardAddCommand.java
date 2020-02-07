package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.util.Prompt;

public class BoardAddCommand implements Command{
	Prompt prompt;
	List<BoardInfo> boardList;
	public BoardAddCommand(Prompt prompt ,List<BoardInfo> list) {

		this.prompt = prompt;
		this.boardList = list;


	}
	@Override
	public void excute() {
		
		
		  BoardInfo board = new BoardInfo();
		  board.setNum(prompt.inputInt("번호>"));
		  
		  board.setTitle(prompt.inputString("제목>"));
			  board.setContents(prompt.inputString("내용>"));
			  
			  boardList.add(board);
		  System.out.println("저장");
		  
		
	}
	
}

