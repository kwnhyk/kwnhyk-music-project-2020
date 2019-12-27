//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.Scanner;

import kwnhyk.music.handler.ArtistHandler;
import kwnhyk.music.handler.BoardHandler;
import kwnhyk.music.handler.MusicHandler;



public class App {
	static Scanner keyboard = new Scanner(System.in);




	public static void main(String[] args) {
		MusicHandler.input = keyboard;
		ArtistHandler.input = keyboard;
		BoardHandler.input = keyboard;
		MusicHandler musicHandler = new MusicHandler();
		MusicHandler musicHandler2 = new MusicHandler();
		ArtistHandler artistHandler = new ArtistHandler();
		ArtistHandler artistHandler2 = new ArtistHandler();
		BoardHandler boardHandler = new BoardHandler();
		
		
		String command ;

		do{
			System.out.print("명령> ");
			command = keyboard.nextLine();

			switch (command){
			case "/music/add":
				musicHandler.addMusic();

				// 정보를 담고 있는 인스턴스의 주소를 나중에 사용할 수 있도록
				// 레퍼런스 배열에 보관해 둔다.
				break;
			case "/music/list":
				musicHandler.listMusic();


				break;
			case "/music2/add":
				musicHandler2.listMusic();
				break;
			case "/music2/list":
				musicHandler2.listMusic();
				break;

			case "/artist/add":
				artistHandler.addArtist();
				break;
			case"/artist/list":
				artistHandler.listArtist();
				break;
			case "/artist2/add":
				artistHandler2.addArtist();
				break;
			
			case"/artist2/list":
				artistHandler2.listArtist();
				break;
			case "/board/add":
				boardHandler.addBoard();
				break;
			case "/board/list":
				boardHandler.listBoard();
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





