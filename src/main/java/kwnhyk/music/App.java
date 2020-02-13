//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
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
		HashMap<String,Command> commandMap = new HashMap<>();
		
		
		ArrayList<MusicInfo> musicList = new ArrayList<>();
		commandMap.put("/music/add",new MusicAddCommand(prompt,musicList));
		commandMap.put("/music/list",new MusicListCommand(musicList));
		commandMap.put("/music/detail",new MusicDetailCommand(prompt,musicList));
		commandMap.put("/music/delete",new MusicDeleteCommand(prompt,musicList));
		commandMap.put("/music/update",new MusicUpdateCommand(prompt,musicList));
		LinkedList<ArtistInfo> artistList = new LinkedList<>(); 
		 commandMap.put("/artist/add", new ArtistAddCommand(prompt, artistList));
		    commandMap.put("/artist/list", new ArtistListCommand(artistList));
		    commandMap.put("/artist/detail", new ArtistDetailCommand(prompt, artistList));
		    commandMap.put("/artist/update", new ArtistUpdateCommand(prompt, artistList));
		    commandMap.put("/artist/delete", new ArtistDeleteCommand(prompt, artistList));
		LinkedList<BoardInfo> boardList = new LinkedList<>();
		commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
	    commandMap.put("/board/list", new BoardListCommand(boardList));
	    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
	    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
	    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));
			
			
			String command ;
			while(true) {
				System.out.print("명령> ");
				command = keyboard.nextLine();
				if(command.length() ==0)
					continue;
				
				if(!command.equalsIgnoreCase("quit")){
				System.out.println("GoodBye!");
				break;
				}else if(command.equals("history")) {
				printCommandHistory(commandStack.iterator());
				continue;
				}else if (command.equals("history2")) {
				printCommandHistory(commandQueue.iterator());
				continue;
			}
			
				commandStack.push(command);
				commandQueue.offer(command);
			
			
			Command commandHandler = commandMap.get(command);
			if(commandHandler!=null) {
				commandHandler.excute();
			}	else {
			
			
					System.out.println("실행할 수 없는 명령입니다.");

				}
			}
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





