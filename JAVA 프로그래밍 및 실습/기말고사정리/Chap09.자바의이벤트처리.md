# Chap09.자바의 이벤트 처리 및 이벤트 기반 프로그래밍  - 11주차

## 1. 이벤트 종류

- 사용자의 입력 : 마우스 드래그, 마우스 클릭, 키보드 누르 등
- 다른 응용 프로그램이나 다른 스레드로부터의 메시지

## 2. 원리

- 이벤트의 발생에 의해 프로그램 흐름이 결정되는 방식
- 이벤트가 발생하면 이벤트를 처리하는 루틴(이벤트 리스너) 실행
- 프로그램 내의 어떤 코드가 언제 실행될 지 이벤트 발생에 의해 전적으로 결정

## 3. 이벤트 처리 순서

1. 이벤트 발생
2. 이벤트 객체 생성 : 현재 발생한 이벤트에 대한 정보를 가진 객체
3. 이벤트 리스너 (이벤트를 처리하도록 만들어진 코드) 찾기
4. 이벤트 리스너 호출 : 이벤트 객체가 리스너에 전달됨
5. 이벤트 리스너 실행 


## 4. 이벤트 관련 용어

- 이벤트 소스 : 이벤트를 발생시킨 GUI 컴포넌트
- 이벤트 객체 : 발생한 이벤트에 대한 정보 ex) 이벤트 종류, 이벤트 소스, 화면 좌표, 마우스 버튼 종류, 눌러진 키
- 이벤트 리스너 : 이벤트를 처리하는 코드. ✨컴포넌트에 등록되어야 작동가능.✨
- 이벤트 분배 스레드 : 무한루프를 실행하는 스레드
 - 동작 
   - 자바 가상 기계로부터 이벤트의 발생을 통지 받음
   - 이벤트 소스와 이벤트 종류 결정
   - 적절한 이벤트 객체 생성, 이벤트 리스너를 찾아 호출
   
 ## 5. 이벤트 객체
 : 이벤트가 발생할때, 발생한 이벤트에 관한 정보를 가진객체로서 이벤트 리스너에 전달된다. 
 
 ![KakaoTalk_20211208_122812521](https://user-images.githubusercontent.com/86418674/145143652-8b13fcf1-7cbb-418d-9cc7-83b05d6c2fc6.jpg)

 
 ### 이벤트 객체에 포함된 정보
 
 - 이벤트 종류
 - 이벤트 소스
 - 이벤트가 발생한 화면 좌표
 - 버튼이나 메뉴 아이템에 이벤트가 발생한 경우 아이템의 문자열
 - `ActionEvent`의 경우 해당 이벤트를 `identifying` 하는 문자열
 - 이벤트 소스 알아내기 : ` Object EventObject.getSource()` -> 발생한 이벤트의 소스 컴포넌트 리턴. Object 타입으로 리턴하므로 캐스팅하여 사용. 모든 이벤트 객체에 대해 적용
 
### 이벤트 객체의 메소드

![KakaoTalk_20211208_124140209](https://user-images.githubusercontent.com/86418674/145144488-3e194f99-bea5-4dab-85a7-01e75aa20952.jpg)


### 이벤트 객체와 이벤트 소스
![KakaoTalk_20211208_124403734](https://user-images.githubusercontent.com/86418674/145144622-48ad853a-2906-47ee-a5c3-6eea3bc068f5.jpg)

## 6. 이벤트 리스너
: 이벤트를 처리하는 코드,클래스로 작성

- JDK 에 이벤트 리스너 작성을 위한 인터페이스 제공 -> 추상 메소드 모두 구현해서 사용
- 이벤트가 발생하면 자바 플랫폼은 리스너 인터페이스의 추상메소드 호출

### 리스너 인터페이스와 메소드

![KakaoTalk_20211208_124709612](https://user-images.githubusercontent.com/86418674/145144870-9d0c8073-fee4-426a-b3ee-17c65091f0d5.jpg)

## 7. 어댑터(Adapter) 클래스
: 이벤트 리스너 작성시 추상 메소드들을 모두 구현해야하는 부담 존재. 마우스 리스너에서 마우스가 눌러지는 경우(mousePressed())만 처리하고자 하는 경우에도 나머지 4개의 메소드를 모두 구현해야함.
- Adapter클래스는 리스너의 모든 메소드가 단순 리턴하도록 구현해놓은 클래스.
- 추상 메소드가 하나뿐인 리스너는 어댑터 클래스 존재 X ex) `ActionAdapter`, `ItemAdapter` 는 존재 X


### JDK 에서 제공하는 어댑터 클래스

![KakaoTalk_20211208_125546600](https://user-images.githubusercontent.com/86418674/145145648-bbfdb06f-e625-4f3e-b857-c8bd130ce8d2.jpg)


## 8. Key이벤트로 키입력받기

### key이벤트와 포커스
- 포커스 : 컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
```
component.setFocusable(true); // component가 포커스를 받을 수 있도록 설정
component.requestFocus(); // component에 포커스 강제 지정
```


### KeyListener 의 메소드와 키 

- 3개의 메소드 : keyPressed -> keyReleased -> keyTyped

- 키의 종류
  - 유니코드 키
    - A-Z,a~z,0~9,!,@,& 등 문자들에 대해서만 유니코드 정의
  - 유니코드 아닌키
    - 문자 키가 아닌 키들 (제어키) ex) <Home> ,<Up> ,<Shift> , <F5> 등
    - 키마다 키 코드 값(가상 키 코드 값)이 정의되어 있음.
    - 유니코드 키가 아닌 경우  keyPressed -> keyReleased 만 호출되고 keyTyped은 호출되지 않음
  - 가상키 
 : 모든 키에 정의되어있는 자바의 가상 키 코드
 
 
### 가상키
 : 가상 키 코드는 KeyEvent 클래스에 상수로 선언.
 
 ![KakaoTalk_20211208_130718171](https://user-images.githubusercontent.com/86418674/145146644-38f50b5d-359a-4f44-ba12-c33888ebfe31.jpg)
 
 
 ### ✨ 입력된 키 판별 ✨
 : 키가 입력되면 키 정보를 가진 이벤트 객체(KeyEvent) 생성 및 리스너에 전달 
 
 1. 키의 문자코드(유니코드) 알아내기
 ### `char KeyEvent.getKeyChar()` 
 : 눌러진 키에 해당하는 문자코드(유니코드) 리턴. 눌러진 키가 문자 키인 경우에만 작동. ex) 'a','b','5' 
 
 2. 입력된 키의 가상 키 값 알아내기 
 ### `int KeyEvent.getKeyCode()` 
 : 모든 키에 대해 작동. 입력된 키를 판별하기 위해 가상키값과 비교. 가상 키 값은 KeyEvent 클래스의 상수로 정의됨.
 
 3. 키 이름 문자열 리턴 
 ### `String KeyEvent.getKeyText(int keyCode) 
 : Static 메소드, 매개변수 keyCode의 코드값(가상키)에 해당하는 키의 이름 문자열 리턴. 
 F1의 경우 "F1", Shift의 경우 "Shift"
 

## 9. Mouse이벤트로 마우스 동작 인식

 ### 마우스 이벤트와 마우스 관련 리스너 
 - 8가지 경우 : mousePressed() =>mouseDragged - mouseDragged -mouseDragged ... => mouseReleased() => mouseClicked()  등
 - MouseMotionListener의 이벤트 `mouseDragged`, `mouseMoved`도 함께 처리하고자하는 경우 마우스 모션 리스너에도 등록 필요 
 -> `component.addMouseMotionListener(myMouseMotionListener);`
 
 ### 마우스와 마우스 모션 이벤트 활용 p.19
 
 ### `MouseWheelEvent` 와  `MouseWheelEventListener` p.21
 
 
 
