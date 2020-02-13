package kwnhyk.music.Handler;

import java.util.Iterator;
import java.util.List;

import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.util.Prompt;

public class BoardListCommand implements Command {
	Prompt prompt;
	List<BoardInfo> boardList;
	public BoardListCommand(List<BoardInfo> list) {


		this.boardList = list;
	}
	@Override
	public void excute() {
		Iterator<BoardInfo> iterator = boardList.iterator();
		while(iterator.hasNext()) {
			BoardInfo b = iterator.next();
			
		System.out.printf("%d %s %s \n", 
				b.getNum(), b.getTitle(), b.getContents());
		
		
		
	}
	}
	
	
	
}
