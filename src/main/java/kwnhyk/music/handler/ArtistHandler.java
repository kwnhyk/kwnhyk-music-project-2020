package kwnhyk.music.Handler;


import java.util.Iterator;
import java.util.List;

import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.util.Prompt;


public class ArtistHandler {

	
	List<ArtistInfo> artistList;
	Prompt prompt;
	public ArtistHandler(Prompt input,List<ArtistInfo> list) {
		this.prompt = input;
		this.artistList = list;
	}
	public  void listArtist() {
		/*for(int i =0;i <artistList.size();i++) {
			ArtistInfo a = artistList.get(i);
		}*/
		//ArtistInfo[] objs = this.artistList.toArray(new ArtistInfo[]{});
			//for(ArtistInfo a : objs){
			Iterator<ArtistInfo> iterator = artistList.iterator();
			while(iterator.hasNext()) {
			ArtistInfo a = iterator.next();
			
			System.out.printf("%d, %s, %s, %s\n", 
					a.getNo(), a.getArtist(), a.getRealName(), a.getBornDate());
		}
	}

	public  void addArtist() {
 		ArtistInfo artist = new ArtistInfo();
		artist.setNo(prompt.inputInt("번호?"));

		System.out.print("아티스트명? ");
		artist.setArtist(prompt.inputString("아티스트명?"));

		System.out.print("본명? ");
		artist.setRealName(prompt.inputString("본명?"));

		System.out.print("출생일? ");

		// "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
		artist.setBornDate(prompt.inputDate("출생일?"));
		artistList.add(artist);
		//this.artists[this.artistCount++]=artist;

		System.out.println("저장하였습니다");

	}
	public void detailArtist() {
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
	  
	  public void updateArtist() {
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
	  
	  public void deleteArtist() {
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
