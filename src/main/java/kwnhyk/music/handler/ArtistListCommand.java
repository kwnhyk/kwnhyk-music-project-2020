package kwnhyk.music.Handler;

import java.util.Iterator;
import java.util.List;

import kwnhyk.music.domain.ArtistInfo;

public class ArtistListCommand implements Command{

	List<ArtistInfo> artistList;
	public ArtistListCommand(List<ArtistInfo> list) {

		
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

