package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.MusicInfo;
import kwnhyk.music.util.Prompt;

public class MusicAddCommand implements Command{
	Prompt prompt;
	List<MusicInfo> musicList;
	public MusicAddCommand(Prompt prompt ,List<MusicInfo> list) {

		this.prompt = prompt;
		this.musicList = list;


	}
	@Override
	public void excute() {
		
		MusicInfo music = new MusicInfo();

		music.setNo(prompt.inputInt("번호?"));


		music.setTitle(prompt.inputString("음악제목?"));

		music.setArtist(prompt.inputString("아티스트명"));
		music.setWriter(prompt.inputString("작곡가? "));
		music.setGenre(prompt.inputString("장르? "));


		music.setStartDate(prompt.inputDate("출시일?"));

		musicList.add(music);
		
		System.out.println("저장하였습니다");
	}
	
}

