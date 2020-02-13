package kwnhyk.music.Handler;

import java.util.Iterator;
import java.util.List;

import kwnhyk.music.domain.MusicInfo;

public class MusicListCommand implements Command{
	
	List<MusicInfo> musicList;
	public MusicListCommand(List<MusicInfo> list) {

		
		this.musicList = list;


	}
	@Override
	public void excute() {
		//MusicInfo[] lists = this.musicList.toArray(new MusicInfo[] {});
				//for(MusicInfo m : lists){
					Iterator<MusicInfo> iterator = musicList.iterator();
					while(iterator.hasNext()) {
						MusicInfo m = iterator.next();
				
					System.out.printf("%d, %s, %s , %s,%s,%s\n",
							m.getNo(), m.getTitle(),
							m.getArtist(), m.getWriter(),m.getGenre(), 
							m.getStartDate()
							);
				}
	
}
}

