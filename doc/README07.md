# 버전9 - 인스턴스 필드와 인스턴스 메서드가 필요한 이유

##  목표

- 인스턴스 필드와 인스턴스 메서드를 사용할 수 있다.
- 스태틱 필드와 인스턴스 필드의 차이점과 용도를 설명할 수 있다.
- 스태틱 메서드와 인스턴스 메서드의 차이점과 용도를 설명할 수 있다.

## 실습 소스 및 결과


- src/main/java/kwnhyk/music/handler/MusicHandler.java 변경
- src/main/java/kwnhyk/music/handler/ArtistHandler.java 변경


- src/main/java/kwnhyk/music/handler/App.java 변경

## 실습

### 작업1) 인스턴스 멤버를 활용하여 새 뮤직,아티스트 정보들을 추가하라.

- ArtistHandler.java
    - 개별적으로 다룰 수 있도록 필드를 인스턴스 멤버로 전환한다.
    - 인스턴스 필드를 다루기 위해 클래스 메서드를 인스턴스 메서드로 전환한다.
- App.java (App.java.01)
    - `ArtistHandler` 클래스의 변화에 맞추어 코드를 변경한다.
- MusicHandler.java
    - 개별적으로 다룰 수 있도록 필드를 인스턴스 멤버로 전환한다.
    - 인스턴스 필드를 다루기 위해 클래스 메서드를 인스턴스 메서드로 전환한다.
.


### 작업2) 핸들러의 스태틱 멤버를 인스턴스 필드와 인스턴스 메서드로 전환하라.

- MusicHandler.java
    - 필드와 메서드를 인스턴스 멤버로 전환한다.
- ArtistHandler.java    
    - 필드와 메서드를 인스턴스 멤버로 전환한다.
- App.java
    - `MusicHandler`와 `ArtistHandler` 클래스의 변화에 맞추어 코드를 변경한다.
