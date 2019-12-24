package kwnhyk.music.handler;

import java.sql.Date;
import java.util.Scanner;

import kwnhyk.music.domain.ArtistInfo;

public class ArtistHandler {

	
	final static int ARTIST_SIZE = 100;
	 ArtistInfo [] artists = new ArtistInfo[ARTIST_SIZE];

	 int artistCount = 0;
	public static Scanner keyboard ;
	public static void listArtist(ArtistHandler artisthandler) {
		for (int i = 0; i < artisthandler.artistCount; i++) {
			ArtistInfo a = artisthandler.artists[i];
			System.out.printf("%d, %s, %s, %s\n", 
					a.no, a.artist, a.realName, a.bornDate);
		}
	}

	public static void addArtist(ArtistHandler artisthandler) {
		ArtistInfo artist = new ArtistInfo();
		System.out.print("번호? ");
		artist.no = keyboard.nextInt();
		keyboard.nextLine(); // 줄바꿈 기호 제거용

		System.out.print("아티스트명? ");
		artist.artist = keyboard.nextLine();

		System.out.print("본명? ");
		artist.realName = keyboard.nextLine();

		System.out.print("출생일? ");

		// "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
		artist.bornDate= Date.valueOf(keyboard.next());
		keyboard.nextLine(); 

		artisthandler.artists[artisthandler.artistCount++]=artist;
		System.out.println("저장하였습니다");

	}

}
