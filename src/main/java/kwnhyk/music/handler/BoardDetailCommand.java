package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.util.Prompt;

public class BoardDetailCommand implements Command {
	Prompt prompt;
	List<BoardInfo> boardList;
	public BoardDetailCommand(Prompt prompt ,List<BoardInfo> list) {

		this.prompt = prompt;
		this.boardList = list;


	}



	@Override
	public void excute() {

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

	private int indexOfBoard(int no) {
		for (int i = 0; i < this.boardList.size(); i++) {
			if (this.boardList.get(i).getNum() == no) {
				return i;
			}
		}
		return -1;
	}

}