package kwnhyk.music.Handler;

import java.util.Iterator;
import java.util.List;

import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.util.Prompt;

public class ArtistListCommand implements Command{
	Prompt prompt;
	List<ArtistInfo> artistList;
	public ArtistListCommand(Prompt prompt ,List<ArtistInfo> list) {

		this.prompt = prompt;
		this.artistList = list;


	}
	@Override
	public void excute() {
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
	 



}

