
package kwnhyk.music;
import java.sql.Date;
import java.util.Scanner;

public class App2 { 
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] artist = new String[SIZE];
   
    
    
    String[] realName = new String[SIZE];
    Date[] bornDate = new Date[SIZE];

    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      count++;
      
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("아티스트명? ");
      artist[i] = keyboard.nextLine();

      System.out.print("본명? ");
      realName[i] = keyboard.nextLine();



      System.out.print("출생일? ");
      // "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
      bornDate[i] = Date.valueOf(keyboard.next());

      keyboard.nextLine(); // 출시일 입력 값 다음에 남아 있는 줄바꿈 값 제거
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %s\n", 
          no[i], artist[i], realName[i], bornDate[i]);
    }
  }
}