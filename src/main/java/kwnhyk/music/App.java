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
		ArtistHandler artistHandler = new ArtistHandler(keyboard);
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
			case "/music/detail":
				musicHandler.detailMusic();
				break;
			case "/music/update":
				musicHandler.updateMusic();
				break;
			case "/music/delete":
				musicHandler.deleteMusic();
				break;
		

			case "/artist/add":
				artistHandler.addArtist();
				break;
			case"/artist/list":
				artistHandler.listArtist();
				break;
			case "/artist/detail":
				artistHandler.detailArtist();
				break;
			case "/artist/update":
				artistHandler.updateArtist();
				break;
			case "/artist/delete":
				artistHandler.deleteArtist();
				break;
			case "/board/add":
				boardHandler.addBoard();
				break;
			case "/board/list":
				boardHandler.listBoard();
				break;
				case "/board/detail":
				boardHandler.detailBoard();
				break;
			case "/board/update":
				boardHandler.updateBoard();
				break;
				case "/board/delete":
				boardHandler.deleteBoard();
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





