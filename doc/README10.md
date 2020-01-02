# 버전12 - UI 코드와 데이터 처리 코드를 분리하기

##  목표

- 캡슐화 기법을 이용하여 데이터 처리 코드를 별개의 클래스로 분리할 수 있다.
- 배열 복제를 통해 배열의 크기를 늘릴 수 있다.
- 역할에 따라 클래스를 분리하는 방법과 이점을 이해한다.  

## 실습 소스 및 결과

- src/main/java/kwnhyk/music/handler/MusicList.java 추가
- src/main/java/kwnhyk/music/handler/ArtistList.java 추가
- src/main/java/kwnhyk/music/handler/BoardList.java 추가
- src/main/java/kwnhyk/music/handler/MusicHandler.java 변경
- src/main/java/kwnhyk/music/handler/ArtistHandler.java 변경
- src/main/java/kwnhyk/music/handler/BoardHandler.java 변경

## 실습

### 작업1) MusicHandler에서 데이터 처리 코드를 분리하라.

- MusicList.java
    - `MusicHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    -음악 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    -음악 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- MusicHandler.java
    - `MusicList` 클래스를 사용하여 데이터를 처리한다.

### 작업2) ArtistHandler에서 데이터 처리 코드를 분리하라.

- ArtistList.java
    - `ArtistHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 아티스트 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    - 아티스트 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- ArtistHandler.java
    - `ArtistList` 클래스를 사용하여 데이터를 처리한다.

### 작업3) BoardHandler에서 데이터 처리 코드를 분리하라.

- BoardList.java
    - `BoardHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 게시물 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    - 게시물 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- BoardHandler.java
    - `BoardList` 클래스를 사용하여 데이터를 처리한다.
