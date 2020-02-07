package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.util.Prompt;

public class BoardDeleteCommand implements Command {
	Prompt prompt;
	List<BoardInfo> boardList;
	public BoardDeleteCommand(Prompt prompt ,List<BoardInfo> list) {

		this.prompt = prompt;
		this.boardList = list;


	}



	@Override
	public void excute() {

		int index = indexOfBoard(prompt.inputInt("게시글 번호?"));


		if (index == -1) {
			System.out.println("게시글 번호 유효하지 않습니다.");
			return;
		}

		this.boardList.remove(index);

		System.out.println("게시글을 삭제했습니다.");


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