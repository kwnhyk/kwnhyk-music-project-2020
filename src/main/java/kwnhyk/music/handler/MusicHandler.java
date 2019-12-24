package kwnhyk.music.handler;

import java.util.Scanner;

public class MusicHandler {


	static class MusicInfo {
		int no;
		String title;
		String artist;

		String writer;
		String genre;
		int startDate;

	}
	final static int  MUSIC_SIZE = 100;
	// Lesson 인스턴스 주소를 담을 레퍼런스 배열을 만든다.
	static MusicInfo[] musics = new MusicInfo[MUSIC_SIZE];
	static int musicCount = 0;
	public static Scanner keyboard;
	
	public static void listMusic() {
		for (int i = 0; i < musicCount; i++) {
			MusicInfo m = musics[i];

			System.out.printf("%d, %s, %s , %s,%s,%d\n",
					m.no, m.title,
					m.artist, m.genre,m.writer,
					m.startDate
					);
		}
	}
	public static void addMusic(){
			MusicInfo music = new MusicInfo();

			System.out.print("번호? ");
			music.no = keyboard.nextInt();

			keyboard.nextLine(); // nextInt() 후에 남아 있는 줄바꿈 기호를 제거한다.

			System.out.print("음악제목? ");
			music.title = keyboard.nextLine();

			System.out.print("아티스트명? ");
			music.artist = keyboard.nextLine();
			System.out.print("작곡가? ");
			music.writer = keyboard.nextLine();
			System.out.print("장르? ");
			music.genre = keyboard.nextLine();

			System.out.print("출시일? ");

			music.startDate = keyboard.nextInt();


			keyboard.nextLine(); //  출시일 입력 값 다음에 남아 있는 줄바꿈 값 제거

			musics[musicCount++] = music;
			System.out.println("저장하였습니다");
		}

}

