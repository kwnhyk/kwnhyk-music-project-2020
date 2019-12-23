
package kwnhyk.music;
import java.sql.Date;
import java.util.Scanner;

public class App2 { 
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    class ArtistInfo {
        int no;
        String artist;
        String realName;
        Date bornDate;
      }

    final int SIZE = 100;
    ArtistInfo [] infos = new ArtistInfo[SIZE];
  
    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      count++;
      ArtistInfo info = new ArtistInfo();
      
      System.out.print("번호? ");
      info.no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("아티스트명? ");
      info.artist = keyboard.nextLine();

      System.out.print("본명? ");
      info.realName = keyboard.nextLine();



      System.out.print("출생일? ");
      // "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
      info.bornDate= Date.valueOf(keyboard.next());
      
      keyboard.nextLine(); // 출시일 입력 값 다음에 남아 있는 줄바꿈 값 제거
      infos[i] = info;
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
    	ArtistInfo info = infos[i];
      System.out.printf("%d, %s, %s, %s\n", 
          info.no, info.artist, info.realName, info.bornDate);
    }
  }
}