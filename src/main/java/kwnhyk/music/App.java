//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.sql.Date;
import java.util.Scanner;

public class App {
	static Scanner keyboard = new Scanner(System.in);

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
	static  class ArtistInfo {
		int no;
		String artist;
		String realName;
		Date bornDate;
	}

	final static int ARTIST_SIZE = 100;
	static ArtistInfo [] artists = new ArtistInfo[ARTIST_SIZE];

	static int artistCount = 0;



	public static void main(String[] args) {


		String command ;

		do{
			System.out.print("명령> ");
			command = keyboard.nextLine();

			switch (command){
			case "/music/add":
				addMusic();

				// 정보를 담고 있는 인스턴스의 주소를 나중에 사용할 수 있도록
				// 레퍼런스 배열에 보관해 둔다.
				break;
			case "/music/list":
				listMusic();


				break;
			case "/artist/add":
				addArtist();
				break;

			case"/artist/list":
				listArtist();
				break;

			default:
				if(!command.equalsIgnoreCase("quit")){
					System.out.println("실행할 수 없는 명령입니다.");
				}
			}
		}while(!command.equalsIgnoreCase("quit"));
		System.out.println("GoodBye!");
		keyboard.close();

	}
	static void listArtist() {
		for (int i = 0; i < artistCount; i++) {
			ArtistInfo a = artists[i];
			System.out.printf("%d, %s, %s, %s\n", 
					a.no, a.artist, a.realName, a.bornDate);
		}
	}
	static void listMusic() {
		for (int i = 0; i < musicCount; i++) {
			MusicInfo m = musics[i];

			System.out.printf("%d, %s, %s , %s,%s,%d\n",
					m.no, m.title,
					m.artist, m.genre,m.writer,
					m.startDate
					);
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
	static void addMusic(){
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





