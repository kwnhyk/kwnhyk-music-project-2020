package kwnhyk.music.handler;

import java.util.Scanner;


import kwnhyk.music.domain.MusicInfo;

public class MusicHandler {


	final static int  MUSIC_SIZE = 100;
	// Lesson 인스턴스 주소를 담을 레퍼런스 배열을 만든다.
	 MusicInfo[] musics ;
	 int musicCount = 0;
	public  Scanner input;
	public MusicHandler(Scanner input) {
		this.input = input;
		 this.musics = new MusicInfo[MUSIC_SIZE];
	}
	public  void listMusic( ) {
		for (int i = 0; i <this.musicCount; i++) {
			MusicInfo m = this.musics[i];

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

			this.musics[this.musicCount++] = music;
			System.out.println("저장하였습니다");
		}

}

