# 버전11 - 인스턴스 연산자와 메서드

##  목표

- 메서드를 활용하여 인스턴스 값을 다루는 연산자를 정의할 수 있다.
- 캡슐화의 의미를 이해하고, 셋터/겟터를 만들 수 있다.

## 소스 및 결과

- src/main/java/kwnhyk/music/domain/MusicInfo.java 변경
- src/main/java/kwnhyk/music/domain/ArtistInfo.java 변경
- src/main/java/kwnhyk/music/domain/BoardInfo.java 변경
- src/main/java/kwnhyk/music/handler/MusicHandler.java 변경
- src/main/java/kwnhyk/music/handler/ArtistHandler.java 변경
- src/main/java/kwnhyk/music/handler/BoardHandler.java 변경

## 실습

### 작업1) Music 인스턴스의 값을 다룰 연산자를 정의하라.

- MusicInfo.java
    - 인스턴스 변수(필드)를 비공개(private)로 전환한다.
    - 값을 설정하고 리턴해주는 세터/게터를 정의한다.
- MusicHandler.java
    - Music 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.

### 작업2) Artist 인스턴스의 값을 다룰 연산자를 정의하라.

- ArtistInfo.java
    - 인스턴스 변수(필드)를 비공개(private)로 전환한다.
    - 값을 설정하고 리턴해주는 세터/게터를 정의한다.
- ArtistHandler.java
    - Artist 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.

### 작업3) Board 인스턴스의 값을 다룰 연산자를 정의하라.

- Board.java
    - 인스턴스 변수(필드)를 비공개(private)로 전환한다.
    - 값을 설정하고 리턴해주는 세터/게터를 정의한다.
- BoardHandler.java
    - Board 인스턴스에 값을 넣고 꺼낼 때 세터/겟터를 사용한다.
