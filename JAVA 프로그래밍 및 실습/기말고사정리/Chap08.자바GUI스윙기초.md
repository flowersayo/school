# Chap08. 자바 GUL 스윙 기초


## 1. 이벤트 기반 GUI 프로그래밍 이해

### GUI
: 그래픽 이용, 사용자에게 이해하기 쉬운 모야으로 정보 제공
- AWT - `java.awt` 패키지, 중량컴포넌트
- Swing = `javax.swing` 패키지, 경량 컴포넌트, 순수 자바언어로 만들어진 라이브러리, J자로 시작하는 클래스

### GUI 라이브러리 계층구조
![KakaoTalk_20211208_104902222](https://user-images.githubusercontent.com/86418674/145134060-e9f05083-13bf-4c37-857c-003b5501c154.jpg)


### Swing 클래스의 특징

- 클래스 이름이 `J`로 시작
- 스윙 컴포넌트는 두가지 유형
1. JComponent를 상속받는 클래스 : 대부분의 swing 컴포넌트들
2. AWT의 Contiainer를 상속받는 몇개의 클래스 : `JApplet` , `JDialog` , `JFrame` 등
- JComponent : 스윙 컴포넌트의 공통 속성을 구현한 추상클래스. 인스턴스 생성 불가. AWT의 Componenet를 상속받는다.


### 컨테이너와 컴포넌트
- 컨테이너 
-- 다른 GUI 컴포넌트를 포함할 수 있는 컴포넌트

## 2. 자바 GUI 패키지 이해


## 3. 스윙으로 GUI 프로그램 작성


## 4. 컨테이너와 컴포넌트, 배치


## 5. 배치관리자 활용

###  FlowLayout


### BorderLayout


### GridLayout

## 6. 배치관리자 없는 컨테이너 만들기
