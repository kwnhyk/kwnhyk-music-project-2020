# 24 - CSV 문자열을 객체로 전환하는 기능을 도메인 객체로 이전 

##  목표 

- 코드를 메서드로 추출할 수 있다.(리팩토링)
- 메서드를 역할에 맞춰 다른 클래스로 이동할 수 있다.(리팩토링)
- 스태틱 메서드의 용도를 이해하고 활용할 수 있다.
- 인스턴스 메서드의 용도를 이해하고 활용할 수 있다.

## 실습 소스 및 결과

- src/main/java/kwnhyk/music/App.java 변경
- src/main/java/kwnhyk/music/domain/BoardInfo.java 변경
- src/main/java/kwnhyk/music/domain/ArtistInfo.java 변경
- src/main/java/kwnhyk/music/domain/MusicInfo.java 변경
  
## 실습  

###  1: 게시물 데이터를 CSV 문자열로 다루는 코드를 BoardInfo 클래스로 옮겨라.  

- BoardInfo.java
  - CSV 문자열을 가지고 BoardInfo 객체를 생성하는 valueOf() 를 추가한다.
  - BoardInfo 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadBoardData() 를 변경한다.
  - saveBoardData() 를 변경한다.
  
###  2: 아티스트 데이터를 CSV 문자열로 다루는 코드를/ArtistInfo 클래스로 옮겨라.  

-/ArtistInfo.java
  - CSV 문자열을 가지고/ArtistInfo 객체를 생성하는 valueOf() 를 추가한다.
  -/ArtistInfo 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadArtistData() 를 변경한다.
  - saveArtistData() 를 변경한다.
  
###  3: 음악 데이터를 CSV 문자열로 다루는 코드를 MusicInfo 클래스로 옮겨라.  

- MusicInfo.java
  - CSV 문자열을 가지고 Music 객체를 생성하는 valueOf() 를 추가한다.
  - MusicInfo 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadMusicData() 를 변경한다.
  - saveMusicData() 를 변경한다.
  
  