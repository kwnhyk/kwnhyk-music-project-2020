# 버전14 - 제네릭 사용 및 CRUD(Create/Retrieve/Update/Delete) 기능 완성


##  목표
- 제네릭 문법을 이용하여 타입 정보를 파라미터로 주고 받을 수 있다.
- 제네릭 문법으로 특정 타입의 값만 다루도록 제한할 수 있다.

- 데이터를 등록/조회/수정/삭제하는 기능(CRUD)을 구현할 수 있다.


## 실습 소스 및 결과

- src/main/java/kwnhyk/music/util/ArrayList.java 변경
- src/main/java/kwnhyk/music/handler/MusicHandler.java 변경
- src/main/java/kwnhyk/music/handler/ArtistHandler.java 변경
- src/main/java/kwnhyk/music/handler/BoardHandler.java 변경
- src/main/java/kwnhyk/music/domain/MusicInfo.java 변경
- src/main/java/kwnhyk/music/domain/ArtistInfo.java 변경
- src/main/java/kwnhyk/music/domain/BoardInfo.java 변경
- src/main/java/kwnhyk/music/App.java 변경

## 실습

### 작업1) ArrayList 클래스에 항목 값을 조회하고 변경하고 삭제하는 기능을 추가하라.

- ArrayList.java
  - 목록의 특정 위치에 저장된 항목을 꺼내주는 get()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 바꾸는 set()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 삭제하는 remove()를 정의한다.


### 작업2) 음악 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- MusicHandler.java 
  - 상세조회 기능을 수행하는 detailMusic()을 정의한다.
  - 변경 기능을 수행하는 updateMusic()을 정의한다.
  - 삭제 기능을 수행하는 deleteMusic()을 정의한다.
- App.java
  - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /Music/list


명령> /Music/detail
번호? 2


명령> /Music/detail
번호? 20
해당 음악을 찾을 수 없습니다.

명령> /Music/update
번호? 2


명령> /Music/update
번호? 20
해당 음악을 찾을 수 없습니다.

명령> /Music/delete
번호? 2
음악을 삭제했습니다.

명령> /Music/delete
번호? 20
해당 음악을 찾을 수 없습니다.
```

### 작업3) MusicHandler 코드를 리팩토링하라.

- MusicHandler.java
    - 저장된 목록에서 수업 번호로 항목을 찾는 코드를 indexOfMusic() 메서드로 분리한다.
- MusicInfo.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.


### 작업4) 아티스트 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- ArtistHandler.java
    - 상세조회 기능을 수행하는 detailArtist()을 정의한다.
    - 변경 기능을 수행하는 updateArtist()을 정의한다.
    - 삭제 기능을 수행하는 deleteArtist()을 정의한다.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfArtist()를 정의한다.
- ArtistInfo.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /Artist/list


명령> /Artist/detail
번호? 2


명령> /Artist/detail
번호? 20
해당 아티스트을 찾을 수 없습니다.

명령> /Artist/update
번호? 1

아티스트를 변경했습니다.

명령> /Artist/update
번호? 20
해당 아티스트를 찾을 수 없습니다.

명령> /Artist/delete
번호? 2
아티스트을 삭제했습니다.

명령> /Artist/delete
번호? 20
해당 아티스트을 찾을 수 없습니다.
```

### 작업5) 게시글 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- BoardHandler.java
    - 상세조회 기능을 수행하는 detailBoard()을 정의한다.
    - 변경 기능을 수행하는 updateBoard()을 정의한다.
    - 삭제 기능을 수행하는 deleteBoard()을 정의한다.
    - 저장된 목록에서 회원 번호로 항목을 찾는 indexOfBoard()를 정의한다.
- BoardInfo.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /board/list
1, 게시글입니다.                , q
2, 두 번째 게시글입니다.        , q
3, 세 번째 게시글입니다.        , q

명령> /board/detail
번호? 1
제목:게시글입니다.
내용: q

명령> /board/detail
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/update
번호? 1
내용?      <=== 입력하지 않으면 기존 값 사용
게시글을 변경했습니다.

명령> /board/update
번호? 20
해당 게시글을 찾을 수 없습니다.

명령> /board/delete
번호? 2
게시글을 삭제했습니다.

명령> /board/delete
번호? 20
해당 게시글을 찾을 수 없습니다.
```
