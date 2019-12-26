//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.Scanner;

import kwnhyk.music.handler.ArtistHandler;
import kwnhyk.music.handler.BoardHandler;
import kwnhyk.music.handler.MusicHandler;



public class App {
	static Scanner keyboard = new Scanner(System.in);




	public static void main(String[] args) {
		MusicHandler.keyboard = keyboard;
		ArtistHandler.keyboard = keyboard;
		BoardHandler.keyboard = keyboard;
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
				MusicHandler.addMusic(musicHandler);

				// 정보를 담고 있는 인스턴스의 주소를 나중에 사용할 수 있도록
				// 레퍼런스 배열에 보관해 둔다.
				break;
			case "/music/list":
				MusicHandler.listMusic(musicHandler);


				break;
			case "/music2/add":
				MusicHandler.listMusic(musicHandler2);
				break;
			case "/music2/list":
				MusicHandler.listMusic(musicHandler2);
				break;

			case "/artist/add":
				ArtistHandler.addArtist(artistHandler);
				break;
			case"/artist/list":
				ArtistHandler.listArtist(artistHandler);
				break;
			case "/artist2/add":
				ArtistHandler.addArtist(artistHandler2);
				break;
			
			case"/artist2/list":
				ArtistHandler.listArtist(artistHandler2);
				break;
			case "/board/add":
				BoardHandler.addBoard(boardHandler);
				break;
			case "/board/list":
				BoardHandler.listBoard(boardHandler);
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





