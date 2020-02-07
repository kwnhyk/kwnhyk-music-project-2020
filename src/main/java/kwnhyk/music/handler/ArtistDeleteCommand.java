package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.util.Prompt;

public class ArtistDeleteCommand implements Command{
	Prompt prompt;
	List<ArtistInfo> artistList;
	public ArtistDeleteCommand(Prompt prompt ,List<ArtistInfo> list) {

		this.prompt = prompt;
		this.artistList = list;


	}
	@Override
	public void excute() {
		  int index =indexOfAritst(prompt.inputInt("번호?"));
		    
		    
		    if (index == -1) {
		      System.out.println("게시글 번호가 유효하지 않습니다.");
		      return;
		    }
		  
		    this.artistList.remove(index);
		    
		    System.out.println(" 삭제했습니다.");
		
	}
	  private int indexOfAritst(int no) {
		    for (int i = 0; i < this.artistList.size(); i++) {
		      if (this.artistList.get(i).getNo() == no) {
		        return i;
		      }
		    }
		    return -1;
		  


}
}

