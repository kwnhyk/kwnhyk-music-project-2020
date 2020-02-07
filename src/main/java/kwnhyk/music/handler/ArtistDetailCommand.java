package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.util.Prompt;

public class ArtistDetailCommand implements Command{
	Prompt prompt;
	List<ArtistInfo> artistList;
	public ArtistDetailCommand(Prompt prompt ,List<ArtistInfo> list) {

		this.prompt = prompt;
		this.artistList = list;


	}
	@Override
	public void excute() {
		  int index =indexOfAritst(prompt.inputInt("번호?"));
		    
		    
		    if (index == -1) {
		      System.out.println("게시글 번호 유효하지 않습니다.");
		      return;
		    }
		    ArtistInfo Artist = this.artistList.get(index);
		    System.out.printf("번호: %d\n", Artist.getNo());
		    System.out.printf("아티스트명: %s\n", Artist.getArtist());
		    System.out.printf("본명: %s\n", Artist.getRealName());
		    System.out.printf("출생일: %s\n", Artist.getBornDate());
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

