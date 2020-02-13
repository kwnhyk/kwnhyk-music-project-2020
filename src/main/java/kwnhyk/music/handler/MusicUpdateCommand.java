package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.MusicInfo;
import kwnhyk.music.util.Prompt;

public class MusicUpdateCommand implements Command{
	Prompt prompt;
	List<MusicInfo> musicList;
	public MusicUpdateCommand(Prompt prompt ,List<MusicInfo> list) {

		this.prompt = prompt;
		this.musicList = list;


	}
	@Override
	public void excute() {
	    int index =indexOfMusic(prompt.inputInt("번호?"));
	    
	    
	    if (index == -1) {
	      System.out.println("게시글 번호 유효하지 않습니다.");
	      return;
	    }
	    MusicInfo oldMusic = this.musicList.get(index);
	    MusicInfo newMusic = new MusicInfo();
	    newMusic.setNo(oldMusic.getNo());
		
		newMusic.setTitle(prompt.inputString(String.format("음악제목(%s)?", oldMusic.getTitle())
		,oldMusic.getTitle())
		);
			
		newMusic.setArtist(prompt.inputString(String.format("아티스트명(%s)?", oldMusic.getArtist())
		,oldMusic.getArtist())
		);
			
		newMusic.setWriter(prompt.inputString(String.format("작곡가(%s)?", oldMusic.getWriter())
		,oldMusic.getWriter())
		);
			
		newMusic.setGenre(prompt.inputString(String.format("장르(%s)?", oldMusic.getGenre())
		,oldMusic.getGenre())
		);
			
		newMusic.setStartDate(prompt.inputDate(String.format("출시일(%s)?", oldMusic.getStartDate())
		,oldMusic.getStartDate())
		);
	     
	  
	  
	   /* System.out.printf("장르(%s)? ", oldMusic.getGenre());
	    promptStr = prompt.nextLine();
	    if (promptStr.length() == 0) {
	    	newMusic.setGenre(oldMusic.getGenre());
	      System.out.println("장르 변경을 취소했습니다.");
	     
	    }  else {
	    	newMusic.setGenre(promptStr);
	    
		}
		*/
		/*System.out.printf("출시일(%s)? ", oldMusic.getStartDate());
		promptStr = prompt.nextLine();
		if (promptStr.length() == 0) {
			newMusic.setStartDate(oldMusic.getStartDate());
		  System.out.println("출시일 변경을 취소했습니다.");
		 
		}  else {
			newMusic.setStartDate(Date.valueOf(promptStr));
		
		}
		*/
		if(oldMusic.equals(newMusic)){
			return;
		}
	    
	  
	    this.musicList.set(index, newMusic);
	    
	    System.out.println(" 변경했습니다.");
	  }
	private int indexOfMusic(int no) {
		for (int i = 0; i < this.musicList.size(); i++) {
			if (this.musicList.get(i).getNo() == no) {
				return i;
			}
		}
		return -1;
	}
}

