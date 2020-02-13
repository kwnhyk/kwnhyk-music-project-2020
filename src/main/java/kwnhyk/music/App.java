//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import kwnhyk.music.Handler.ArtistAddCommand;
import kwnhyk.music.Handler.ArtistDeleteCommand;
import kwnhyk.music.Handler.ArtistDetailCommand;
import kwnhyk.music.Handler.ArtistListCommand;
import kwnhyk.music.Handler.ArtistUpdateCommand;
import kwnhyk.music.Handler.BoardAddCommand;
import kwnhyk.music.Handler.BoardDeleteCommand;
import kwnhyk.music.Handler.BoardDetailCommand;
import kwnhyk.music.Handler.BoardListCommand;
import kwnhyk.music.Handler.BoardUpdateCommand;
import kwnhyk.music.Handler.Command;
import kwnhyk.music.Handler.MusicAddCommand;
import kwnhyk.music.Handler.MusicDeleteCommand;
import kwnhyk.music.Handler.MusicDetailCommand;
import kwnhyk.music.Handler.MusicListCommand;
import kwnhyk.music.Handler.MusicUpdateCommand;
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
		LinkedList<ArtistInfo> artistList = new LinkedList<>(); 
		LinkedList<BoardInfo> boardList = new LinkedList<>();
		
			Command boardAddCommand = new BoardAddCommand(prompt, boardList);
			Command boardListCommand = new BoardListCommand(boardList);
		    Command boardDetailCommand = new BoardDetailCommand(prompt, boardList);
		    Command boardUpdateCommand = new BoardUpdateCommand(prompt, boardList);
		    Command boardDeleteCommand = new BoardDeleteCommand(prompt, boardList);
		    Command artistAddCommand = new ArtistAddCommand(prompt,artistList);
		    Command artistListCommand = new ArtistListCommand(artistList);
		    Command artistDetailCommand = new ArtistDetailCommand(prompt,artistList);
		    Command artistDeleteCommand = new ArtistDeleteCommand(prompt,artistList);
			Command artistUpdateCommand = new ArtistUpdateCommand(prompt,artistList);
			Command musicAddCommand = new MusicAddCommand(prompt,musicList);
			Command musicListCommand = new MusicListCommand(musicList);
			Command musicDetailCommand = new MusicDetailCommand(prompt,musicList);
			Command musicDeleteCommand = new MusicDeleteCommand(prompt,musicList);
			Command musicUpdateCommand = new MusicUpdateCommand(prompt,musicList);
			
			
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
			musicAddCommand.excute();


				break;
			case "/music/list":
			musicListCommand.excute();


				break;
			case "/music/detail":
			musicDetailCommand.excute();
				break;
			case "/music/update":
			musicUpdateCommand.excute();
				break;
			case "/music/delete":
			musicDeleteCommand.excute();
				break;


			case "/artist/add":
			artistAddCommand.excute();
				break;
			case"/artist/list":
			artistListCommand.excute();
				break;
			case "/artist/detail":
			artistDetailCommand.excute();
				break;
			case "/artist/update":
			artistUpdateCommand.excute();
				break;
			case "/artist/delete":
			artistDeleteCommand.excute();
				break;
			case "/board/add":
				boardAddCommand.excute();
				break;
			case "/board/list":
				boardListCommand.excute();
				break;
			case "/board/detail":
				boardDetailCommand.excute();
				break;
			case "/board/update":
				boardUpdateCommand.excute();
				break;
			case "/board/delete":
				boardDeleteCommand.excute();
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





