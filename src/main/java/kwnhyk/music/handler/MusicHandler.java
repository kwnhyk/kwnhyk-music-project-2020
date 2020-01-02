package kwnhyk.music.handler;

import java.util.Scanner;

import kwnhyk.music.domain.MusicInfo;




public class MusicHandler {

	MusicList musicList;

	  Scanner input;
	public MusicHandler(Scanner input) {
		this.input = input;
		this.musicList = new MusicList();
	}
	public MusicHandler(Scanner input,int capacity) {
		this.input = input;
		this.musicList = new MusicList(capacity);
	}
	public  void listMusic( ) {
		MusicInfo[] list = this.musicList.toArray();
		for(MusicInfo m : list)
	

			System.out.printf("%d, %s, %s , %s,%s,%d\n",
					m.getNo(), m.getTitle(),
					m.getArtist(), m.getGenre(), m.getWriter(),
					m.getStartDate()
					);
		}
	
	public  void addMusic(){
			MusicInfo music = new MusicInfo();

			System.out.print("번호? ");
			music.setNo(input.nextInt());

			input.nextLine(); // nextInt() 후에 남아 있는 줄바꿈 기호를 제거한다.

			System.out.print("음악제목? ");
			music.setTitle(input.nextLine());

			System.out.print("아티스트명? ");
			music.setArtist(input.nextLine());
			System.out.print("작곡가? ");
			music.setWriter(input.nextLine());
			System.out.print("장르? ");
			music.setGenre(input.nextLine());

			System.out.print("출시일? ");

			music.setStartDate(input.nextInt());


			input.nextLine(); //  출시일 입력 값 다음에 남아 있는 줄바꿈 값 제거
			this.musicList.add(music);
			
			System.out.println("저장하였습니다");
		}

}

