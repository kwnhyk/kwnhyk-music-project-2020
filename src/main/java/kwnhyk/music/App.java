//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
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
	static	ArrayList<MusicInfo> musicList = new ArrayList<>();
	
	static	LinkedList<ArtistInfo> artistList = new LinkedList<>(); 
	static	LinkedList<BoardInfo> boardList = new LinkedList<>();


	public static void main(String[] args) {
		loadMusicData();
		loadArtistData();
		loadBoardData();
		Prompt prompt = new Prompt(keyboard);
		HashMap<String,Command> commandMap = new HashMap<>();
		
		
		commandMap.put("/music/add",new MusicAddCommand(prompt,musicList));
		commandMap.put("/music/list",new MusicListCommand(musicList));
		commandMap.put("/music/detail",new MusicDetailCommand(prompt,musicList));
		commandMap.put("/music/delete",new MusicDeleteCommand(prompt,musicList));
		commandMap.put("/music/update",new MusicUpdateCommand(prompt,musicList));
		 commandMap.put("/artist/add", new ArtistAddCommand(prompt, artistList));
		    commandMap.put("/artist/list", new ArtistListCommand(artistList));
		    commandMap.put("/artist/detail", new ArtistDetailCommand(prompt, artistList));
		    commandMap.put("/artist/update", new ArtistUpdateCommand(prompt, artistList));
		    commandMap.put("/artist/delete", new ArtistDeleteCommand(prompt, artistList));
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
				
				if(command.equalsIgnoreCase("quit")){
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
				try {
				commandHandler.excute();
			}	catch(Exception e){
				System.out.printf("명령어 실행 중 오류 발생:%s\n",e.getMessage());
			}
				
			}
				else {
			
			
					System.out.println("실행할 수 없는 명령입니다.");

				}
			}
			keyboard.close();
			
			
			saveMusicData();
			saveArtistData();
			saveBoardData();
		
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
	
	private static void loadMusicData() {
		File file = new File("./music.data");
		
		
		
			try (DataInputStream in =
			        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
				int size = in.readInt();
				for(int i = 0; i <size;i++) {
					MusicInfo music = new MusicInfo();
					music.setNo(in.readInt());
					music.setTitle(in.readUTF());
					music.setArtist(in.readUTF());
					music.setGenre(in.readUTF());
					music.setWriter(in.readUTF());
					music.setStartDate(Date.valueOf(in.readUTF()));
					musicList.add(music);
				}
				
				
			
				System.out.printf("총%d개의 음악 데이터를 로딩했습니다\n",musicList.size());
			
			
			
			}catch (IOException e) {
			System.out.println("파일 읽기 중 오류 발생!-" + e.getMessage());
			}
			}
	
			
		
		
	
	private static void saveMusicData() {
		File file = new File("./music.data");
		
		
		try (DataOutputStream out =
		        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
		      out.writeInt(musicList.size());
		      for (MusicInfo music : musicList) {
		        out.writeInt(music.getNo());
		        out.writeUTF(music.getTitle());
		        out.writeUTF(music.getGenre());
		        out.writeUTF(music.getArtist());
		        out.writeUTF(music.getWriter());
		        out.writeUTF(music.getStartDate().toString());
		      }
			System.out.printf("총 %d개의 음악 데이터를 저장했습니다.\n",musicList.size());
		
		
					
		
		
		}catch (IOException e) {
				System.out.println("파일쓰기중오류발생"+e.getMessage());
		}
			
		
				
					
					
		}
		
		
	
	
	private static void loadArtistData() {
		File file = new File("./artist.data");
		
		
		try(DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        ArtistInfo artist = new ArtistInfo();
        artist.setNo(in.readInt());
        artist.setArtist(in.readUTF());
        artist.setRealName(in.readUTF());
       
        artist.setBornDate(Date.valueOf(in.readUTF()));
        artistList.add(artist);
      } 
      
		     // 방법1) JSON ===> List
		      // Gson json도구 = new Gson();
		      // music[] 배열 = json도구.fromJson(in, music[].class);
		      // for (music 수업 : 배열) {
		      // musicList.add(수업);
		      // }
			/*ArtistInfo[] artists = new Gson().fromJson(in,ArtistInfo[].class);
			for(ArtistInfo artist : artists) {
				artistList.add(artist);
			}
			*/

		      // 방법2) JSON ===> List
		      // Gson json도구 = new Gson();
		      // music[] 배열 = json도구.fromJson(in, music[].class);
		      // List<music> 읽기전용List구현체 = Arrays.asList(배열);
		      // musicList.addAll(읽기전용List구현체);

		      // 위의 코드를 간략히 줄이면 다음과 같다.
			//artistList.addAll(Arrays.asList(new Gson().fromJson(in, ArtistInfo[].class)));
		
		System.out.printf("총%d개의 아티스트 데이터를 로딩\n",artistList.size());
		
	}catch(IOException e) {
		System.out.println("파일 읽기 중 오류 발생" +e.getMessage());
		
	}
	}


	
	private static void saveArtistData() {
		File file = new File("./artist.data");
		try(DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(artistList.size());
      for (ArtistInfo artist : artistList) {
        out.writeInt(artist.getNo());
        out.writeUTF(artist.getArtist());
        out.writeUTF(artist.getRealName());
        out.writeUTF(artist.getBornDate().toString());
		//out.write(new Gson().toJson(artistList));
      }
		System.out.printf("총%d개의 아티스트 데이터를 저장했습니다\n",artistList.size());
		
	}catch(IOException e) {
		System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
	}
		
	}
		
	
	private static void loadBoardData() {
		File file = new File("./board.data");
		
		
		try(DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        BoardInfo board = new BoardInfo();
        board.setNum(in.readInt());
        board.setTitle(in.readUTF());
        board.setContents(in.readUTF());
        
        String contents = in.readUTF();
        if (contents.length() > 0) {
          board.setContents(contents);
        }
        boardList.add(board);
		}
		
			
		System.out.printf("총%d개의 게시물 데이터를 로딩했습니다\n",boardList.size());
		
		
	}catch(IOException e) {
		System.out.println("파일읽기중 오류 발생" + e.getMessage());
	}
	
		
	}
	private static void saveBoardData() {
		File file = new File("./board.data");
		try(DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(boardList.size());
      for (BoardInfo board : boardList) {
        out.writeInt(board.getNum());
        out.writeUTF(board.getTitle());
        out.writeUTF(board.getContents() == null ? "" : board.getContents());
      }
		System.out.printf("총 %d개의 게시물 데이터를 저장했습니다\n",boardList.size());
		
			
			
			
		}catch(IOException e) {
			System.out.println("파일 쓰기 중 오류 발생"+ e.getMessage());
		}
		
	}
	
}









