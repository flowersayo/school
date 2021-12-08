# Chap08. 자바 GUI 스윙 기초


## 1. 이벤트 기반 GUI 프로그래밍 이해

### GUI
: 그래픽 이용, 사용자에게 이해하기 쉬운 모야으로 정보 제공
- AWT - `java.awt` 패키지, 중량컴포넌트
- Swing = `javax.swing` 패키지, 경량 컴포넌트, 순수 자바언어로 만들어진 라이브러리, J자로 시작하는 클래스

## 2. 자바 GUI 패키지 이해

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
  - 다른 GUI 컴포넌트를 포함할 수 있는 컴포넌트 
  - 다른 컨테이너에 포함될 수 있음
    - AWT 컨테이너 : `Panel`, `Frame` 등..
    - Swing 컨테이너 : `JPanel`, `JFrame` 등.. 
    
- 최상위 컨테이너
  - 다른 컨테이너에 속하지 않고 독립적으로 화면에 출력 가능한 컨테이너
  - `JFrame`,`JDialog` 등..
  - 모든 컴포넌트는 컨테이너에 포함되어야 화면에 출력가능.

- 컴포넌트
  - 컨테이너에 포함되어야 화면에 출력될 수 있는 순수 컴포넌트
  - 모든 컴포넌트는 java.awt.Componenet를 상속방음.
  - 모든 스윙 컴포넌트는 javax.swing.JComponent를 상속받음.
## 3. 스윙으로 GUI 프로그램 작성


### 스윙 GUI 프로그램 만들기

1. 스윙 프레임 작성
2. main() 메소드 작성
3. 프레임에 스윙 컴포넌트 붙이기


### 스윙 프레임
: 모든 스윙 컴포넌트를 담는 최상위 GUI 컨테이너

- JFrame을 상속받아 구현.
- 컴포넌트가 화면에 보이려면 스윙 프레임 내에 부착되어야함.
- 프레임을 닫으면 프레임 내의 모든 컴포넌트가 보이지 않게 됨.
- 스윙 프레임 기본 구성 : 프레임, 메뉴바, 컨텐트팬


### 스윙 응용프로그램의 종료

### `System.exit(0);`
: 응용 프로그램 내에서 스스로 종료

Q. 프레임 종료 버튼(X) 이 클릭되면? 
: 프레임을 종료하여 프레임 윈도우가 닫힌다. 프레임이 보이지 않게되고 응용프로그램이 사라지나, 종료한것은 아니다. 다시 setVisible(true)를 호출하면 보이게 되고 이전처럼 작동한다.
즉, 완전히 종료하기 위해서는 `frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);` 을 추가하여 프레임 종료버튼이 클릭될때 프레임을 닫고 응용프로그램이 종료되도록 한다.

Q. main() 종료 뒤에도 프레임이 살아 있는 이유?
: 메인 스레드가 종료되어도 이벤트 분배 스레드가 살아 있어 프레임 화면을 그리고 마우스나 키 입력을 받기 때문.

## 4. 컨테이너와 컴포넌트, 배치

1. 컨테이너마다 하나의 배치관리자가 존재. 삽입되는 모든 컴포넌트의 위치와 크기를 결정하고 적절히 배치한다.
2. 컨테이너으 ㅣ크기가 변하면 내부 컴포넌트들의 위치와 크기를 모두 재조정하고 재배치한다.


### 배치관리자 대표 유형 4가지

`FlowLayout BorderLayout GridLayout CardLayout`

## 5. 배치관리자 활용

### 컨테이너와 배치관리자
### `Container.setLayout(LayoutManager lm);` 
: lm 을 새로운 배치관리자로 설정.


###  FlowLayout

: 왼쪽에서 오른쪽으로 배치. 행이 꽉차면 위에서 아래로 순서대로 컴포넌트 배치

![KakaoTalk_20211208_113636843](https://user-images.githubusercontent.com/86418674/145138951-ea5f54e4-d1e7-4d9a-a456-2a3c6af402b8.jpg)


### BorderLayout

:  컨테이너 공간을 동,서,남,북,중앙 의 5구역으로 분할 및 배치

![KakaoTalk_20211208_114119195](https://user-images.githubusercontent.com/86418674/145138973-59378057-a35a-469b-b56a-1553aedc29bb.jpg)


### GridLayout

: 컨테이너 공간을 동일한 사각형 격자(그리드)로 분할하고 각 셀에 하나의 컴포넌트 배치 

- 격자 구성은 생성자에 행수와 열수 지정
- 셀의 왼쪽에서 오른쪽으로, 다시 위에서 아래로 순서대로 배치.

![KakaoTalk_20211208_113847138](https://user-images.githubusercontent.com/86418674/145138963-deb2b89f-714c-4da9-ab2a-fdd07ea9860f.jpg)


```

grid.setVgap(5); //수직 간격 설정


```
## 6. 배치관리자 없는 컨테이너 만들기

- 배치관리자가 없는 컨테이너란?
: 응용 프로그램에서 컴포넌트의 절대 크기와 절대 위치 결정

- 컨테이너의 배치 관리자 제거 방법
### `Container.setLayout(null);`

- 컴포넌트의 절대 크기와 절대 위치 설정
: 프로그램 내에서 이루어져야함
  - 컴포넌트 크기 설정 : component.setSize(int width,int height);
  - 컴포넌트 위치 설정 : component.setLocation(int x,int y);
  - 컴포넌트 위치와 크기 동시에 설정 : component.setBounds(int x,int y,int width,int height);
