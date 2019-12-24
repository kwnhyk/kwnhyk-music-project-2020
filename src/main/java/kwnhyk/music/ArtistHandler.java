package kwnhyk.music;

import java.sql.Date;
import java.util.Scanner;

public class ArtistHandler {

	static  class ArtistInfo {
		int no;
		String artist;
		String realName;
		Date bornDate;
	}

	final static int ARTIST_SIZE = 100;
	static ArtistInfo [] artists = new ArtistInfo[ARTIST_SIZE];

	static int artistCount = 0;
	 static Scanner keyboard ;
	 static void listArtist() {
		for (int i = 0; i < artistCount; i++) {
			ArtistInfo a = artists[i];
			System.out.printf("%d, %s, %s, %s\n", 
					a.no, a.artist, a.realName, a.bornDate);
		}
	}

	 static void addArtist() {
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

		artists[artistCount++]=artist;
		System.out.println("저장하였습니다");

	}

}
