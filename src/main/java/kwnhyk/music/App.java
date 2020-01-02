//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.Scanner;

import kwnhyk.music.handler.ArtistHandler;
import kwnhyk.music.handler.BoardHandler;
import kwnhyk.music.handler.MusicHandler;



public class App {
	static Scanner keyboard = new Scanner(System.in);




	public static void main(String[] args) {
		MusicHandler musicHandler = new MusicHandler(keyboard);
		MusicHandler musicHandler2 = new MusicHandler(keyboard);
		ArtistHandler artistHandler = new ArtistHandler(keyboard);
		ArtistHandler artistHandler2 = new ArtistHandler(keyboard);
		BoardHandler boardHandler = new BoardHandler(keyboard);
		
		
		String command ;

		do{
			System.out.print("명령> ");
			command = keyboard.nextLine();

			switch (command){
			case "/music/add":
				musicHandler.addMusic();

				
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





