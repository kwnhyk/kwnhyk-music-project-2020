//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import kwnhyk.music.Handler.ArtistHandler;
import kwnhyk.music.Handler.BoardAddCommand;
import kwnhyk.music.Handler.BoardDeleteCommand;
import kwnhyk.music.Handler.BoardDetailCommand;
import kwnhyk.music.Handler.BoardListCommand;
import kwnhyk.music.Handler.BoardUpdateCommand;
import kwnhyk.music.Handler.Command;
import kwnhyk.music.Handler.MusicHandler;
import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.domain.MusicInfo;
import kwnhyk.music.util.Prompt;



public class App {
	static Scanner keyboard = new Scanner(System.in);
	static Deque<String> commandStack = new ArrayDeque<>();
	static Queue<String> commandQueue = new LinkedList<>();



	public static void main(String[] args) {
		Prompt prompt = new Prompt(keyboard);
		ArrayList<MusicInfo> musicList = new ArrayList<>();
		MusicHandler musicHandler = new MusicHandler(prompt,musicList);
		LinkedList<ArtistInfo> artistList = new LinkedList<>(); 
		ArtistHandler artistHandler = new ArtistHandler(prompt,artistList);
		LinkedList<BoardInfo> boardList = new LinkedList<>();
		
		Command boardAddCommand = new BoardAddCommand(prompt, boardList);
		 Command boardListCommand = new BoardListCommand(boardList);
		    Command boardDetailCommand = new BoardDetailCommand(prompt, boardList);
		    Command boardUpdateCommand = new BoardUpdateCommand(prompt, boardList);
		    Command boardDeleteCommand = new BoardDeleteCommand(prompt, boardList);

		String command ;

		do{
			System.out.print("명령> ");
			command = keyboard.nextLine();
			if(command.length() ==0)
				continue;
			commandStack.push(command);
			commandQueue.offer(command);
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
				boardAddCommand.excute();
				break;
			case "/board/list":
				boardListCommand.excute();
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
				printCommandHistory(commandStack.iterator());
			case"history2":
				printCommandHistory(commandQueue.iterator());
			default:
				if(!command.equalsIgnoreCase("quit")){
					System.out.println("실행할 수 없는 명령입니다.");

				}
			}
		}while(!command.equalsIgnoreCase("quit"));
		System.out.println("GoodBye!");
		keyboard.close();

	}

	private static void printCommandHistory(Iterator<String> iterator) {
		
		int count = 0;
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
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





