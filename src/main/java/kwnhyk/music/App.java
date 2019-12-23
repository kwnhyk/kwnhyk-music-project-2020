//프로젝트: 음악 정보 사이트
package kwnhyk.music;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] title = new String[SIZE];
    String[] artist = new String[SIZE];
    int[] startDate = new int[SIZE];
    String[] writer = new String[SIZE];
    String[] genre = new String[SIZE];
     
   

    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      count++;
      
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();

      keyboard.nextLine(); // nextInt() 후에 남아 있는 줄바꿈 기호를 제거한다.

      System.out.print("음악제목? ");
      title[i] = keyboard.nextLine(); 

      System.out.print("아티스트명? ");
      artist[i] = keyboard.nextLine();

      System.out.print("작곡가명? ");
      writer[i] = keyboard.nextLine();

      System.out.print("장르? ");
      genre[i] = keyboard.nextLine();

      System.out.print("출시일? ");
     
      startDate[i] = keyboard.nextInt();
      
      keyboard.nextLine();

      
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    System.out.println();

    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %s,%s,%d\n",
          no[i], title[i],artist[i],writer[i],genre[i] ,startDate[i]);
    }

    keyboard.close();
  }
}





