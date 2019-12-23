//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    class MusicInfo {
        int no;
        String title;
        String artist;
    
        String writer;
        String genre;
        int startDate;
        
      }
    final int SIZE = 100;
  // Lesson 인스턴스 주소를 담을 레퍼런스 배열을 만든다.
    MusicInfo[] musics = new MusicInfo[SIZE];
   
     
   

    int count = 0;
    for (int i = 0; i < SIZE; i++) {
        count++;
  
        MusicInfo music = new MusicInfo();
        
        System.out.print("번호? ");
        music.no = keyboard.nextInt();
  
        keyboard.nextLine(); // nextInt() 후에 남아 있는 줄바꿈 기호를 제거한다.
  
        System.out.print("음악제목? ");
        music.title = keyboard.nextLine();
  
        System.out.print("아티스트명? ");
        music.artist = keyboard.nextLine();
        System.out.print("작곡가? ");
        music.writer = keyboard.nextLine();
        System.out.print("장르? ");
        music.genre = keyboard.nextLine();
  
        System.out.print("출시일? ");
     
        music.startDate = keyboard.nextInt();
  
        
        keyboard.nextLine(); //  출시일 입력 값 다음에 남아 있는 줄바꿈 값 제거
        
        // 정보를 담고 있는 인스턴스의 주소를 나중에 사용할 수 있도록 
        // 레퍼런스 배열에 보관해 둔다.
        musics[i] = music;
        
        System.out.print("계속 입력하시겠습니까?(Y/n) ");
        String response = keyboard.nextLine();
        if (!response.equalsIgnoreCase("y"))
          break;
      }
      System.out.println();
  
      for (int i = 0; i < count; i++) {
       MusicInfo music = musics[i];
        System.out.printf("%d, %s, %s , %s,%s,%d\n",
            music.no, music.title, 
            music.artist, music.genre,music.writer,
            music.startDate
            );
      }
  
      keyboard.close();
    }
  }
  
  
  