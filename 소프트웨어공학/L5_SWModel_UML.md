# Software & System Modeling UML


## 소프트웨어 모델링

- 소프트웨어 모델 : 수행해야 하는 기능의 관점에서 소프트웨어를 표현

- 모델링 3요소
  - 규약 : 모델링에 사용되는 요소의 정의
  - 표현 : 규약을 이용하여 모델링 한 결과
  - 명세 : 표현된 모델에 대한 상세 내용을 서술하는 것



## UML(Unified Modeling Language) 

: 객체 지향 설계를 설명하기 위한 다양한 표기법


## Views of UML


1. Use-case view : 외부 액터의 관점에서 시스템의 기능적인 측면을 바라보는 뷰
ex) use-case diagram

2. Logical view : 시스템의 기능들이 내부적으로 어떻게 설계될 수 있는지를 보여주는 뷰
ex) package diagram,class diagram, state diagram, sequence diagram,communicatoin diagram,activity diagram

3. Component view : 컴포넌트와 컴포넌트의 관계를 보여주는 뷰
ex) component diagram

4. Concurrency view : 시스템 요소들 간의 동기/비동기, 상호작용에 대한 사항, 시스템 요소들에 대한 처리 방식을 보여주는 뷰,
프로세스와 프로세서의 할당, 효과적인 리소스의 사용, 병령 수행, 주변 환경에서의 이벤트에 대한 처리, 동기화 상호통신을 나타냄.
개발자와 시스템 통합자를 위한 것 
ex) dynamic diagram(state,sequence,communication(collaboration) digrams), Implementation diagrams(component, deployment diagrams)

5. Deployment view : 컴퓨터와 주변 장치로 구성된 시스템의 실제 배치를 보여주는 뷰
ex) deployement diagram

## Relationships 


- 의존 관계 : 어떤 spec에서의 한 변화가 다른 것에 영향을 주는 관계 (역은 성립할 필요 x)
- 연관 관계 : 한 사물의 객체가 다른 객체와 연결되어 있음을 명시하는 구조적 관계 ex) binary association, n-ary
- 일반화 : parent 와 child의 관계
- 집합(Aggregation) : whole과 part의 관계
- 집합(Composition) : 강한 집합


## 다이어그램 종류 및 개념

### Use-case diagram 
: 시스템이 제공하는 기능을 나타내며, Actor에 의해 바라보는 관점으로 표현

1) usecase Scenario  
  - 이름
  - 유스케이스를 시작하는 행위자
  - 목표
  - 선행조건
  - 정상 시나리오
  - 예외 시나리오
  - 동시 발생 가능한 내용
  - 종료조건
2) Relationship : include(포함관계), Extend(확장), Generalization(일반화) 

![image](https://user-images.githubusercontent.com/86418674/206125404-b5b98e3e-4da7-48a4-97a2-69460e9c6b10.png)
![image](https://user-images.githubusercontent.com/86418674/206125320-f04b5484-496c-4ca3-b5e6-bc49b76bf804.png)
![image](https://user-images.githubusercontent.com/86418674/206125377-e9c4ad16-6a71-4ab9-8feb-f1ff87f50757.png)


### Class diagram
: 클래스들과 그들의 관계를 표시. 클래스 = 속성 + 메소드

1) Relationship
- Assocication(연관) 
  - Multiplicity : 연관 되어 있는 두 클래스 사이에서 한 클래스 객체와 관계를 가질 수 있는 다른 클래스의 객체 개수 
  - rolename : 각 클래스 마다의 역할 
  ![image](https://user-images.githubusercontent.com/86418674/206128190-44611df8-59ce-4636-8080-c94af143bd9b.png)
  - **`Qualifier` : 일대 다의 다중성 연관관계에서 한 객체가 특정한 객체를 가려내어야하는 상황에서 식별정보 지정 **
  => 일대 다 다중성 연관관계를 일대일 다중성으로 줄이는 효과 
  ![image](https://user-images.githubusercontent.com/86418674/206128930-055e45fe-0961-4fc3-a25f-daf401e0c947.png)
- Inheritance : Generalization(일반화)
![image](https://user-images.githubusercontent.com/86418674/206130671-3e200842-7e98-4e85-b1ba-f3c572e16134.png)

- Aggregation : 약한 집합연관. 별도로 존재가능 
- Composition : 강한 집합연관. 함께 소멸
- Dependency : 한 클래스가 다른 클래스를 사용하는 관계 
? [차이](https://luran.me/101)

2) Interface and Realization 
- 인터페이스 : 클래스의 일정한 행동(같은 signature)을 나타내는 operation의 집합

3) Abstact Class : 객체를 생성하지 않는 클래스 


### Pacakage Diagram 
- 패키지 : 연관된 클래스들의 집합


### Sequence & Communicatoin(Collaboration) Diagrams 구분 

1) Sequence Diagram : 시간 경과에 따라 객체 상호간 교류 과정을 표현 
2) Communication Diagram : 객체간의 상호 관계 

차이점 : **시퀀스 다이어그램은 시간순으로 시나리오를, 콜라보레이션 다이어그램은 클래스들의 관계파악이 용이하다 **

### Activity Diagram
: 업무 과정의 활동 흐름을 표현하거나, 오퍼레이션의 알고리즘을 나타내는데 사용 

* Swimline : 역할을 표시함으로써 각 활동의 책임이 누구에게 있는지 나타낼 수 있다.
![image](https://user-images.githubusercontent.com/86418674/206136869-47a78862-ebf4-4826-a8af-0564b4518385.png)


## 기타 다이어그램
- State Chart Diagram : 사건이나 시간에 따라 시스템 객체의 `상태 변화`를 표현. 단일 객체의 상태를 나타냄. `시스템의 변화`를 잡아내기 위해서 사용
![image](https://user-images.githubusercontent.com/86418674/206137377-d75e91c6-c4f6-4e61-974f-fae985de75d6.png)

- Component & Deployment Diagram : 개발환경 내에서 실제적인 소프트웨어 모듈에 대한 구성으로 패키지와 관련된 구성요소. 
![image](https://user-images.githubusercontent.com/86418674/206137334-b25840de-d746-41fb-9704-abce86476aba.png)

- Deployment Diagram : 전체 시스템 구성 요소들의 실제 하드웨어적인 배치와 연결 상태를 표현.
![image](https://user-images.githubusercontent.com/86418674/206137965-1daccf1f-75e4-4841-9e31-e55869d94352.png)

## UML 확장

: `스테레오타입(Stereotypes)`을 사용하여 사용자 정의 타입이나 아이템을 생성하여 UML을 확장
=> 관계(연관(associations),상속(inheritance)), 클래스, 그리고 컴포넌트를 확장하기 위하여 사용

• 예
– 클래스 스테레오타입: boundary, control, entity, utility, exception
– 상속 스테레오타입 : uses, extends
– 컴포넌트 스테레오타입 : subsystem
