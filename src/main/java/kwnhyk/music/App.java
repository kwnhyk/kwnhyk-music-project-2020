//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.Scanner;



public class App {
	static Scanner keyboard = new Scanner(System.in);




	public static void main(String[] args) {
		MusicHandler.keyboard = keyboard;
		ArtistHandler.keyboard = keyboard;

		String command ;

		do{
			System.out.print("명령> ");
			command = keyboard.nextLine();

			switch (command){
			case "/music/add":
				MusicHandler.addMusic();

				// 정보를 담고 있는 인스턴스의 주소를 나중에 사용할 수 있도록
				// 레퍼런스 배열에 보관해 둔다.
				break;
			case "/music/list":
				MusicHandler.listMusic();


				break;
			case "/artist/add":
				ArtistHandler.addArtist();
				break;

			case"/artist/list":
				ArtistHandler.listArtist();
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
	
	
}





