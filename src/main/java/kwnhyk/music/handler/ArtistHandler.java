package kwnhyk.music.handler;

import java.sql.Date;
import java.util.Scanner;

import kwnhyk.music.domain.ArtistInfo;


public class ArtistHandler {

	
	ArrayList<ArtistInfo> artistList;

	  Scanner input ;
	public ArtistHandler(Scanner input) {
		this.input = input;
		 this.artistList = new ArrayList<>();
	}
	public  void listArtist() {
		ArtistInfo[] objs = this.artistList.toArray(new ArtistInfo[]{});
			for(ArtistInfo a : objs){
			
			
			System.out.printf("%d, %s, %s, %s\n", 
					a.getNo(), a.getArtist(), a.getRealName(), a.getBornDate());
		}
	}

	public  void addArtist() {
 		ArtistInfo artist = new ArtistInfo();
		System.out.print("번호? ");
		artist.setNo(input.nextInt());
		input.nextLine(); // 줄바꿈 기호 제거용

		System.out.print("아티스트명? ");
		artist.setArtist(input.nextLine());

		System.out.print("본명? ");
		artist.setRealName(input.nextLine());

		System.out.print("출생일? ");

		// "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
		artist.setBornDate(Date.valueOf(input.next()));
		input.nextLine(); 
		artistList.add(artist);
		//this.artists[this.artistCount++]=artist;

		System.out.println("저장하였습니다");

	}
	public void detailArtist() {
	    System.out.print("게시글 인덱스? ");
	    int index = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
	    ArtistInfo Artist = this.artistList.get(index);
	    
	    if (Artist == null) {
	      System.out.println("게시글 인덱스가 유효하지 않습니다.");
	      return;
	    }
	    
	    System.out.printf("번호: %d\n", Artist.getNo());
	    System.out.printf("아티스트명: %s\n", Artist.getArtist());
	    System.out.printf("본명: %s\n", Artist.getRealName());
	    System.out.printf("출생일: %s\n", Artist.getBornDate());
	  }
	  
	  public void updateArtist() {
	    System.out.print("게시글 인덱스? ");
	    int index = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
	    ArtistInfo oldArtist = this.artistList.get(index);
	    
	    if (oldArtist == null) {
	      System.out.println("게시글 인덱스가 유효하지 않습니다.");
	      return;
	    }
	    
	    System.out.printf("아티스트명(%s)? ", oldArtist.getArtist());
	    String artist = input.nextLine();
	    
	    if (artist.length() == 0) {
	      System.out.println("게시글 변경을 취소했습니다.");
	      return;
	    }
	    
	    ArtistInfo newArtist = new ArtistInfo();
	    newArtist.setNo(oldArtist.getNo());
	    newArtist.setArtist(artist);
	    newArtist.setRealName(oldArtist.getRealName());
	    newArtist.setBornDate(oldArtist.getBornDate());
	    this.artistList.set(index, newArtist);
	    
	    System.out.println("게시글을 변경했습니다.");
	  }
	  
	  public void deleteArtist() {
	    System.out.print("게시글 인덱스? ");
	    int index = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    
	    ArtistInfo Artist = this.artistList.get(index);
	    
	    if (Artist == null) {
	      System.out.println("게시글 인덱스가 유효하지 않습니다.");
	      return;
	    }
	    
	    this.artistList.remove(index);
	    
	    System.out.println("게시글을 삭제했습니다.");
	  }


}
