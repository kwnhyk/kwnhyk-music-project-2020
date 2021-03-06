//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
import kwnhyk.music.context.ApplicationContextListener;
import kwnhyk.music.domain.ArtistInfo;
import kwnhyk.music.domain.BoardInfo;
import kwnhyk.music.domain.MusicInfo;
import kwnhyk.music.util.Prompt;



public class App {
	 Scanner keyboard = new Scanner(System.in);
	 Deque<String> commandStack = new ArrayDeque<>();
	 Queue<String> commandQueue = new LinkedList<>();
		List<MusicInfo> musicList = new ArrayList<>();
	
		List<ArtistInfo> artistList = new LinkedList<>(); 
		List<BoardInfo> boardList = new LinkedList<>();
		Set<ApplicationContextListener> listeners = new HashSet<>();
		 public void addApplicationContextListener(ApplicationContextListener listener) {
			    listeners.add(listener);
			  }

			  // 옵저버를 제거하는 메서드이다.
			  public void removeApplicationContextListener(ApplicationContextListener listener) {
			    listeners.remove(listener);
			  }

			  // 애플리케이션이 시작되면, 등록된 리스너에게 알린다.
			  private void notifyApplicationInitialized() {
			    for (ApplicationContextListener listener : listeners) {
			      listener.contextInitialized();
			    }
			  }

			  // 애플리케이션이 종료되면, 등록된 리스너에게 알린다.
			  private void notifyApplicationDestroyed() {
			    for (ApplicationContextListener listener : listeners) {
			      listener.contextDestroyed();
			    }
			  }

	public  void service() {
		notifyApplicationInitialized();

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
			
			 notifyApplicationDestroyed();
		
	}

	private  void printCommandHistory(Iterator<String> iterator) {
		
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
	
	@SuppressWarnings("unchecked")
	private  void loadMusicData() {
		File file = new File("./music.ser");
		
		
		
			try (ObjectInputStream in =
			        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
				
				musicList = (List<MusicInfo>) in.readObject();
				
				
			
				System.out.printf("총%d개의 음악 데이터를 로딩했습니다\n",musicList.size());
			
			
			
			}catch (Exception e) {
			System.out.println("파일 읽기 중 오류 발생!-" + e.getMessage());
			}
			}
	
			
		
		
	
	private  void saveMusicData() {
		File file = new File("./music.ser");
		
		
		try (ObjectOutputStream out =
		        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
		      out.writeObject(musicList);
		    
			System.out.printf("총 %d개의 음악 데이터를 저장했습니다.\n",musicList.size());
		
		
					
		
		
		}catch (Exception e) {
				System.out.println("파일쓰기중오류발생"+e.getMessage());
		}
			
		
				
					
					
		}
		
		
	
	
	@SuppressWarnings("unchecked")
	private  void loadArtistData() {
		File file = new File("./artist.ser");
		
		
		try(ObjectInputStream in =
		        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
     
        artistList = (List<ArtistInfo>) in.readObject();
      
      
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
		
	}catch(Exception e) {
		System.out.println("파일 읽기 중 오류 발생" +e.getMessage());
		
	}
	}


	
	private  void saveArtistData() {
		File file = new File("./artist.ser");
		try(ObjectOutputStream out =
		        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(artistList);
    
		//out.write(new Gson().toJson(artistList));
      
		System.out.printf("총%d개의 아티스트 데이터를 저장했습니다\n",artistList.size());
		
	}catch(Exception e) {
		System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
	}
		
	}
		
	
	@SuppressWarnings("unchecked")
	private  void loadBoardData() {
		File file = new File("./board.ser");
		
		
		try(ObjectInputStream in =
		        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
    
      boardList = (List<BoardInfo>) in.readObject();
		
			
		System.out.printf("총%d개의 게시물 데이터를 로딩했습니다\n",boardList.size());
		
		
	}catch(Exception e) {
		System.out.println("파일읽기중 오류 발생" + e.getMessage());
	}
	
		
	}
	private  void saveBoardData() {
		File file = new File("./board.ser");
		try(ObjectOutputStream out =
		        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(boardList);
      
		System.out.printf("총 %d개의 게시물 데이터를 저장했습니다\n",boardList.size());
		
			
			
			
		}catch(Exception e) {
			System.out.println("파일 쓰기 중 오류 발생"+ e.getMessage());
		}
		
	}
	



	public static void main(String[] args) {
	App app = new App();
	app.service();
	
}

}





