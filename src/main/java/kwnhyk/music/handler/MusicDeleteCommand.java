package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.MusicInfo;
import kwnhyk.music.util.Prompt;

public class MusicDeleteCommand implements Command{
	Prompt prompt;
	List<MusicInfo> musicList;
	public MusicDeleteCommand(Prompt prompt ,List<MusicInfo> list) {

		this.prompt = prompt;
		this.musicList = list;


	}
	@Override
	public void excute() {
		 int index =indexOfMusic(prompt.inputInt("번호?"));
		    
		    
		    if (index == -1) {
		      System.out.println("번호  유효하지 않습니다.");
		      return;
		    }
		    this.musicList.remove(index);
		    
		    System.out.println(" 삭제했습니다.");
		  }
		  private int indexOfMusic(int no) {
			  for(int i =0;i<this.musicList.size();i++) {
				  if(this.musicList.get(i).getNo()==no) {
					  return i;
				  }
			  }
					  return -1;
			  }
}

