package kwnhyk.music.handler;

import java.sql.Date;
import java.util.Scanner;

import kwnhyk.music.domain.MusicInfo;




public class MusicHandler {

	ArrayList<MusicInfo> musicList;

	  Scanner input;
	public MusicHandler(Scanner input) {
		this.input = input;
		this.musicList = new ArrayList<>();
	}
	public MusicHandler(Scanner input,int capacity) {
		this.input = input;
		this.musicList = new ArrayList<>(capacity);
	}
	public  void listMusic( ) {
		MusicInfo[] lists = this.musicList.toArray(new MusicInfo[] {});
		for(MusicInfo m : lists){


			System.out.printf("%d, %s, %s , %s,%s,%d\n",
					m.getNo(), m.getTitle(),
					m.getArtist(), m.getWriter(),m.getGenre(), 
					m.getStartDate()
					);
		}
	}
	
	public  void addMusic(){
			MusicInfo music = new MusicInfo();

			System.out.print("번호? ");
			music.setNo(Integer.parseInt(input.nextLine()));


			System.out.print("음악제목? ");
			music.setTitle(input.nextLine());

			System.out.print("아티스트명? ");
			music.setArtist(input.nextLine());
			System.out.print("작곡가? ");
			music.setWriter(input.nextLine());
			System.out.print("장르? ");
			music.setGenre(input.nextLine());

			System.out.print("출시일? ");

			music.setStartDate(Date.valueOf(input.next()));
			input.nextLine();

			musicList.add(music);
			
			System.out.println("저장하였습니다");
		}
	public void detailMusic() {
	    System.out.print("번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    int index =indexOfMusic(no);
	    
	    
	    if (index == -1) {
	      System.out.println("번호가 유효하지 않습니다.");
	      return;
	    }
	    MusicInfo music = this.musicList.get(index);
	    System.out.printf("번호: %d\n", music.getNo());
	    System.out.printf("음악제목: %s\n", music.getTitle());
	    System.out.printf("아티스트명: %s\n", music.getArtist());
	    System.out.printf("작곡가: %s\n", music.getWriter());
	    System.out.printf("장르: %s\n", music.getGenre());
	    System.out.printf("출시일: %s\n", music.getStartDate());
	  }
	  
	  public void updateMusic() {
	    System.out.print(" 번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    int index =indexOfMusic(no);
	    
	    
	    if (index == -1) {
	      System.out.println("게시글 번호 유효하지 않습니다.");
	      return;
	    }
	    MusicInfo oldMusic = this.musicList.get(index);
	    String inputStr = null;
	    MusicInfo newMusic = new MusicInfo();
	    newMusic.setNo(oldMusic.getNo());
	    
	    System.out.printf("음악제목(%s)? ", oldMusic.getTitle());
	    inputStr = input.nextLine();
	    if (inputStr.length() == 0) {
	    	newMusic.setTitle(oldMusic.getTitle());
	      System.out.println("아티스트 변경을 취소했습니다.");
	     
	    }  else {
	    	newMusic.setTitle(inputStr);
		}
	    System.out.printf("아티스트명(%s)? ", oldMusic.getArtist());
	    inputStr = input.nextLine();
	    if (inputStr.length() == 0) {
	    	newMusic.setArtist(oldMusic.getArtist());
	      System.out.println("아티스트 변경을 취소했습니다.");
	     
	    }  else {
	    	newMusic.setArtist(inputStr);
		}

			System.out.printf("작곡가(%s)? ", oldMusic.getWriter());
			inputStr = input.nextLine();
			if (inputStr.length() == 0) {
				newMusic.setWriter(oldMusic.getWriter());
			  System.out.println("작곡가 변경을 취소했습니다.");
			 
			}  else {
				newMusic.setWriter(inputStr);
			
			}
	  
	    System.out.printf("장르(%s)? ", oldMusic.getGenre());
	    inputStr = input.nextLine();
	    if (inputStr.length() == 0) {
	    	newMusic.setGenre(oldMusic.getGenre());
	      System.out.println("장르 변경을 취소했습니다.");
	     
	    }  else {
	    	newMusic.setGenre(inputStr);
	    
	    }
		System.out.printf("출시일(%s)? ", oldMusic.getStartDate());
		inputStr = input.nextLine();
		if (inputStr.length() == 0) {
			newMusic.setStartDate(oldMusic.getStartDate());
		  System.out.println("출시일 변경을 취소했습니다.");
		 
		}  else {
			newMusic.setStartDate(Date.valueOf(inputStr));
		
		}
	 
	    
	  
	    this.musicList.set(index, newMusic);
	    
	    System.out.println(" 변경했습니다.");
	  }
	  
	  public void deleteMusic() {
	    System.out.print(" 번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
   int index =indexOfMusic(no);
	    
	    
	    if (index == -1) {
	      System.out.println("번호  유효하지 않습니다.");
	      return;
	    }
	    this.musicList.remove(index);
	    
	    System.out.println(" 삭제했습니다.");
	  }
	  private int indexOfMusic(int no) {
		  for(int i =0;i<this.musicList.size();i++) {
			  if(this.musicList.get(i).getNo()==no) {
				  return i;
			  }
		  }
				  return -1;
		  }
		  
	  }




