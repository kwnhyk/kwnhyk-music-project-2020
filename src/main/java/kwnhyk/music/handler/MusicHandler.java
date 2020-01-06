package kwnhyk.music.handler;

import java.util.Scanner;

import kwnhyk.music.domain.MusicInfo;




public class MusicHandler {

	ArrayList musicList;

	  Scanner input;
	public MusicHandler(Scanner input) {
		this.input = input;
		this.musicList = new ArrayList();
	}
	public MusicHandler(Scanner input,int capacity) {
		this.input = input;
		this.musicList = new ArrayList(capacity);
	}
	public  void listMusic( ) {
		Object[] lists = musicList.toArray();
		for(Object list : lists){
			MusicInfo m = (MusicInfo) list;

			System.out.printf("%d, %s, %s , %s,%s,%d\n",
					m.getNo(), m.getTitle(),
					m.getArtist(), m.getGenre(), m.getWriter(),
					m.getStartDate()
					);
		}
	}
	
	public  void addMusic(){
			MusicInfo music = new MusicInfo();

			System.out.print("번호? ");
			music.setNo(Integer.parseInt(input.nextLine()));


			System.out.print("음악제목? ");
			music.setTitle(input.nextLine());

			System.out.print("아티스트명? ");
			music.setArtist(input.nextLine());
			System.out.print("작곡가? ");
			music.setWriter(input.nextLine());
			System.out.print("장르? ");
			music.setGenre(input.nextLine());

			System.out.print("출시일? ");

			music.setStartDate(Integer.parseInt(input.nextLine()));

			musicList.add(music);
			
			System.out.println("저장하였습니다");
		}

}

