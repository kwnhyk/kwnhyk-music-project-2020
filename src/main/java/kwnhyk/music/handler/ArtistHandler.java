package kwnhyk.music.handler;

import java.sql.Date;
import java.util.Scanner;

import kwnhyk.music.domain.ArtistInfo;

public class ArtistHandler {

	
	final static int ARTIST_SIZE = 100;
	 ArtistInfo [] artists ;

	 int artistCount = 0;
	public  Scanner input ;
	public ArtistHandler(Scanner input) {
		this.input = input;
		 this.artists = new ArtistInfo[ARTIST_SIZE];
	}
	public  void listArtist() {
		for (int i = 0; i < this.artistCount; i++) {
			ArtistInfo a = this.artists[i];
			System.out.printf("%d, %s, %s, %s\n", 
					a.getNo(), a.getArtist(), a.getRealName(), a.getBornDate());
		}
	}

	public  void addArtist() {
		ArtistInfo artist = new ArtistInfo();
		System.out.print("번호? ");
		artist.setNo(input.nextInt());
		input.nextLine(); // 줄바꿈 기호 제거용

		System.out.print("아티스트명? ");
		artist.setArtist(input.nextLine());

		System.out.print("본명? ");
		artist.setRealName(input.nextLine());

		System.out.print("출생일? ");

		// "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
		artist.setBornDate(Date.valueOf(input.next()));
		input.nextLine(); 

		this.artists[this.artistCount++]=artist;
		System.out.println("저장하였습니다");

	}

}
