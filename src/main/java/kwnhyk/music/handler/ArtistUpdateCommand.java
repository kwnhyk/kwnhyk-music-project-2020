package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.util.Prompt;

public class ArtistUpdateCommand implements Command{
	Prompt prompt;
	List<ArtistInfo> artistList;
	public ArtistUpdateCommand(Prompt prompt ,List<ArtistInfo> list) {

		this.prompt = prompt;
		this.artistList = list;


	}
	@Override
	public void excute() {
		 int index =indexOfAritst(prompt.inputInt("번호?"));
		    
		    
		    if (index == -1) {
		      System.out.println(" 번호 유효하지 않습니다.");
		      return;
		    }
		    ArtistInfo oldArtist = this.artistList.get(index);
		    ArtistInfo newArtist = new ArtistInfo();
		    newArtist.setNo(oldArtist.getNo());
		   newArtist.setArtist(prompt.inputString(String.format("아티스트명(%s)", oldArtist.getArtist()),
				   oldArtist.getArtist()));
		   newArtist.setBornDate(prompt.inputDate(String.format("출생일(%s)", oldArtist.getBornDate()),
				   oldArtist.getBornDate()));
		   newArtist.setRealName(prompt.inputString(String.format("본명(%s)", oldArtist.getRealName()),
				   oldArtist.getRealName()));
		    
		  
			if(oldArtist.equals(newArtist)){
				System.out.println("변경취소");
				return;
			}
		 
		    
		  
		    this.artistList.set(index, newArtist);
		    
		    System.out.println(" 변경했습니다.");
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

