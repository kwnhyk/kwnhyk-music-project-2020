package kwnhyk.music.Handler;

import java.util.List;

import kwnhyk.music.domain.MusicInfo;
import kwnhyk.music.util.Prompt;

public class MusicDetailCommand implements Command{
	Prompt prompt;
	List<MusicInfo> musicList;
	public MusicDetailCommand(Prompt prompt ,List<MusicInfo> list) {

		this.prompt = prompt;
		this.musicList = list;


	}
	@Override
	public void excute() {
    int index =indexOfMusic(prompt.inputInt("번호?"));
	    
	    
	    if (index == -1) {
	      System.out.println("번호가 유효하지 않습니다.");
	      return;
	    }
	    MusicInfo music = this.musicList.get(index);
	    System.out.printf("번호: %d\n", music.getNo());
	    System.out.printf("음악제목: %s\n", music.getTitle());
	    System.out.printf("아티스트명: %s\n", music.getArtist());
	    System.out.printf("작곡가: %s\n", music.getWriter());
	    System.out.printf("장르: %s\n", music.getGenre());
	    System.out.printf("출시일: %s\n", music.getStartDate());
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

