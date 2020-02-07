package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.util.Prompt;

public class ArtistAddCommand implements Command{
	Prompt prompt;
	List<ArtistInfo> artistList;
	public ArtistAddCommand(Prompt prompt ,List<ArtistInfo> list) {

		this.prompt = prompt;
		this.artistList = list;


	}
	@Override
	public void excute() {
		
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
	
}

