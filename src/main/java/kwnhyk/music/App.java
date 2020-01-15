//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.Scanner;

import kwnhyk.music.Handler.ArtistHandler;
import kwnhyk.music.Handler.BoardHandler;
import kwnhyk.music.Handler.MusicHandler;
import kwnhyk.music.util.Prompt;
import kwnhyk.music.util.Stack;



public class App {
	static Scanner keyboard = new Scanner(System.in);
	static Stack<String> commandStack = new Stack<>();




	public static void main(String[] args) {
		Prompt prompt = new Prompt(keyboard);
		MusicHandler musicHandler = new MusicHandler(prompt);
		ArtistHandler artistHandler = new ArtistHandler(prompt);
		BoardHandler boardHandler = new BoardHandler(prompt);


		String command ;

		do{
			System.out.print("명령> ");
			command = keyboard.nextLine();
			if(command.length() ==0)
				continue;
			commandStack.push(command);
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
			case"history":
				printCommandHistory();
			default:
				if(!command.equalsIgnoreCase("quit")){
					System.out.println("실행할 수 없는 명령입니다.");

				}
			}
		}while(!command.equalsIgnoreCase("quit"));
		System.out.println("GoodBye!");
		keyboard.close();

	}




	private static void printCommandHistory() {
		Stack<String> historyStack = commandStack.clone();
		int count = 0;
		while(!historyStack.empty()) {
			System.out.println(historyStack.pop());
			count++;
//5개씩 끊어서
			if((count%5)==0) {
				System.out.print(":");
				String str = keyboard.nextLine();
				if(str.equalsIgnoreCase("q")) {
					break;
				}
			}
		}

	}


}





