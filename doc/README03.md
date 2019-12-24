#버전5- 기본 문법의 활용

##  목표

- 변수, 상수, 연산자, 조건문, 반복문, 블록, 배열 등의 문법을 활용할 수 있다.

## 실습 소스 및 결과

- src/main/java/kwnhyk/music/App.java 변경
- src/main/java/kwnhyk/music/App2.java 삭제


## 실습

### 작업1) 사용자의 명령에 따라 음악 정보 등록 및 목록 출력을 처리하도록 변경하라.

- App.java (App.java.01)
    - 사용자로부터 명령을 입력 받는 부분을 추가한다.
    - 조건문을 사용하여 명령어 따라 처리를 분기하도록 변경한다.
    - `quit` 명령이 입력 될 때 실행을 종료하게 한다.
    - 일치하는 명령이 없을 경우 안내 메시지를 출력하게 한다.

#### 실행 결과

```
명령>

명령> /music/add
번호? 1
음악제목? cheap thrills
아티스트명? sia
작곡가? sia
장르? pop
출시일? 2016
저장하였습니다

명령> /music/list
1, cheap thrills, sia , pop,sia,2016
2, i like me better, lauv , pop,lauv,2017
명령>ss
실행할 수 없는 명령입니다.

명령> quit
안녕!
```

### 작업2) 사용자의 명령에 따라 회원 등록 및 목록 출력을 처리하도록 변경하라.

- App.java (App.java.02)
    - `App2.java` 클래스에 있는 코드를 `App.java` 로 옮긴다.
    - `App2.java` 는 삭제한다.

#### 실행 결과

```
명령> /artist/add
번호? 1
아티스트명? lauv
본명?  Ari Staprans Leff
출생일? 1994-08-08
저장하였습니다

명령> /artist/list
1, lauv,  Ari Staprans Leff, 1994-08-08
```

