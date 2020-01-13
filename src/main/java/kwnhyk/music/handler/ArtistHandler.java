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
	    System.out.print("번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    int index =indexOfAritst(no);
	    
	    
	    if (index == -1) {
	      System.out.println("게시글 번호 유효하지 않습니다.");
	      return;
	    }
	    ArtistInfo Artist = this.artistList.get(index);
	    System.out.printf("번호: %d\n", Artist.getNo());
	    System.out.printf("아티스트명: %s\n", Artist.getArtist());
	    System.out.printf("본명: %s\n", Artist.getRealName());
	    System.out.printf("출생일: %s\n", Artist.getBornDate());
	  }
	  
	  public void updateArtist() {
	    System.out.print(" 번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    int index =indexOfAritst(no);
	    
	    
	    if (index == -1) {
	      System.out.println(" 번호 유효하지 않습니다.");
	      return;
	    }
	    ArtistInfo oldArtist = this.artistList.get(index);
	    String inputStr = null;
	    ArtistInfo newArtist = new ArtistInfo();
	    newArtist.setNo(oldArtist.getNo());
	    System.out.printf("아티스트명(%s)? ", oldArtist.getArtist());
	    inputStr = input.nextLine();
	    if (inputStr.length() == 0) {
	    	newArtist.setArtist(oldArtist.getArtist());
	      System.out.println("아티스트 변경을 취소했습니다.");
	     
	    }  else {
	    	newArtist.setArtist(inputStr);
	    
	    }
	    System.out.printf("출생일(%s)? ", oldArtist.getBornDate());
	    inputStr = input.nextLine();
	    if (inputStr.length() == 0) {
	    	newArtist.setBornDate(oldArtist.getBornDate());
	      System.out.println("아티스트 변경을 취소했습니다.");
	     
	    }  else {
	    	newArtist.setBornDate(Date.valueOf(inputStr));
	    
	    }
	    System.out.printf("본명(%s)? ", oldArtist.getRealName());
	    inputStr = input.nextLine();
	    if (inputStr.length() == 0) {
	    	newArtist.setRealName(oldArtist.getRealName());
	      System.out.println("아티스트 변경을 취소했습니다.");
	     
	    }  else {
	    	newArtist.setRealName(inputStr);
	    
	    }
	 
	    
	  
	    this.artistList.set(index, newArtist);
	    
	    System.out.println(" 변경했습니다.");
	  }
	  
	  public void deleteArtist() {
	    System.out.print(" 번호? ");
	    int no = input.nextInt();
	    input.nextLine(); // 숫자 뒤의 남은 공백 제거
	    int index =indexOfAritst(no);
	    
	    
	    if (index == -1) {
	      System.out.println("게시글 번호가 유효하지 않습니다.");
	      return;
	    }
	  
	    this.artistList.remove(index);
	    
	    System.out.println(" 삭제했습니다.");
	  }
	  private int indexOfAritst(int no) {
		    for (int i = 0; i < this.artistList.size(); i++) {
		      if (this.artistList.get(i).getNo() == no) {
		        return i;
		      }
		    }
		    return -1;
		  


}
}
