# 20 - 자바 컬렉션 API 사용하기

##  목표

- 자바에서 제공하는 자료구조 구현체를 활용할 수 있다.


## 실습 소스 및 결과

- src/main/java/kwnhyk/music/util/List.java 삭제
- src/main/java/kwnhyk/music/util/AbstractList.java 삭제
- src/main/java/kwnhyk/music/util/ArrayList.java 삭제
- src/main/java/kwnhyk/music/util/LinkedList.java 삭제
- src/main/java/kwnhyk/music/util/Iterator.java 삭제
- src/main/java/kwnhyk/music/util/Stack.java 삭제
- src/main/java/kwnhyk/music/util/Queue.java 삭제
- src/main/java/kwnhyk/music/handler/ArtistHandler.java 변경
- src/main/java/kwnhyk/music/handler/MusicHandler.java 변경
- src/main/java/kwnhyk/music/handler/BoardHandler.java 변경
- src/main/java/kwnhyk/music/App.java 변경

## 실습

### 훈련1. ArrayList, LinkedList, Stack, Queue 클래스를 자바 컬렉션 API로 교체하라.

- ArtistHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체한다.
- MusicHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체한다.
- BoardHandler.java
    - `List` 를 `java.util.List` 인터페이스로 교체한다.
- App.java
    - 핸들러를 생성할 때 자바 컬렉션 API에서 제공하는 `java.util.List`의 구현체를 넘겨준다.
    - 명령 내역을 저장할 때도 자바 컬렉션 API의 Stack과 Queue 구현체를 사용한다.