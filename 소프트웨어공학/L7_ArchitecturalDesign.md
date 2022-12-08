# Architectural Design

## Design process
![image](https://user-images.githubusercontent.com/86418674/206383486-6266e3eb-e1e9-40aa-b1e4-e6e5b2bb3ad7.png)

- 아키텍쳐 설계 : 시스템의 전체 구조,주요 구성 요소(하위 시스템 혹은 모듈) 이들의 관계 및 배포방법을 식별하는 단계
- 인터페이스 설계 : 시스템 컴포넌트들 사이의 인터페이스를 정의
- 컴포넌트 설계 : 각 시스템 구성 요소의 작동 방식 설계
- 데이터베이스 설계 : 시스템의 데이터 구조를 설계하고 데이터베이스에서 어떻게 표현할 지 결정



ex) architecture of packing robot control system 

## Advantages of explicit architecture 

- Stakeholder communication : 시스템 이해관계자 간 논의의 주제
- System analysis : 비기능적 요구사항을 충족할 수 있는지 여부 분석
- Large-scale reuse : 대규모 재사용. 
* Product-line : **정해진 방법**으로 개발된, 관리되고 있는 공통 기능들을 공유하는 SW 집합 시스템의 모음


## Architectural patterns
: 아키텍쳐 요소와 요소간의 관계를 패턴으로 표현한 것  ( = 디자인 패턴)


- Layered 
- Repository
- Client - Server
-  Pipe and filter 
-  Model - View - Controller 

## Layered architecture

![image](https://user-images.githubusercontent.com/86418674/206387262-5ea697a6-eff9-468a-944c-369076367f73.png)
![image](https://user-images.githubusercontent.com/86418674/206386841-e9f350d8-af8f-4854-bbad-8cd62720e91a.png)

- 서브 시스템의 인터페이스를 모델링 
- 시스템을 일련의 서비스를 제공하는 계층 집합으로 구성
- 다양한 계층에서 서브 시스템의 증분 개발을 지원. 계층 인터페이스가 변경되면 **인접한 계층만 영향**을 받음 -> 수정용이
- 기존 시스템 위에 새로운 설비를 구축할 때 사용

- 장점 
  - 인터페이스가 유지되는 동안은 **전체 계층 교체**가 가능
  - 중복 기능(예: 인증)을 각 계층에 
- 단점 
  - 실제로 **계층간의 명확한 분리를 제공하는 것은 어려운** 경우가 많으며, 상위 계층은 바로 아래의 계층을 통하지 않고 **하위 계층과 직접 상호작용** 해야할 수도 있음
  - 서비스 요청이 각 계층에서 처리될 때, 여러 계층에서의 해석으로 인해 **성능 문제**가 생길 수 있음

## Repository architecture


![image](https://user-images.githubusercontent.com/86418674/206389808-7730c1ec-a457-40a9-bad6-500cd27a9f8f.png)

![image](https://user-images.githubusercontent.com/86418674/206389679-3b301dad-1080-448d-8bcb-0a994a332798.png)


- 서브 시스템들은 데이터를 교환해야함.
- 공유 데이터는 중앙 데이터베이스 또는 저장소에 보관되며 모든 서브 시스템에서 접근이 가능 
- 각각의 서브 시스템이 자체 데이터를 유지 관리하고, 다른 서브 시스템에 명시적으로 데이터를 전달
- **많은 양의 데이터를 공유해야 하는 경우, 공유를 위한 저장소 모델**이 가장 일반적으로 사용되며 이는 효율적인 데이터 공유 매커니즘임
- 장기간 저장해야하는 대량의 정보가 생성되는 시스템이 있을 때

- 장점
  - 컴포넌트가 **독립적**일 수 있음. 각 컴포넌트는 다른 컴포넌트의 존재를 알 필요가 없다.
  - 한 컴포넌트의 변경사항을 모든 컴포넌트에 전파할 수 있다.
  - 모든 데이터가 한 곳에 있어 **일관적으로 관리**할 수 있음 (예 : 동시에 백업 수행)
- 단점
  - **저장소에 실패가 발생하면 전체 시스템에 영향**을 미침
  - 저장소를 통해 모든 커뮤니케이션을 구성하는 것이 비효율적일 수 있음
  - **여러 컴퓨터에 저장소를 배포하는 것은 어려움 **


## Client - Server architecture

![image](https://user-images.githubusercontent.com/86418674/206394569-03f3be8f-ad9a-478d-90fa-30969e6379e0.png)
- 데이터 및 처리가 다양한 컴포넌트에 분산되는 방식을 보여주는 분산 시스템 모델 
- 인쇄, 데이터 관리 등과 같은 특정 서비스를 제공하는 **독립 실행형 서버** 집합 + 이러한 **서비스를 호출하는 클라이언트**의 집합
- 네트워크를 통해 클라이언트가 서버에 접근할 수 있도록 함
- 공유 데이터 베이스의 데이터를 다양한 위치에서 접근해야할 때 사용됨

- 장점
  - 서버는 네트워크를 통해 분산될 수 있음,
  - 일반 기능 (예 : 인쇄 서비스)은 모든 클라이언트에서 사용될 수 있으며 모든 서비스에서 구현될 필요는 없음
- 단점
  - 각 서비스는 단일 장애 지점이므로 서비스 거부 공격이나 서버 장애에 취약함
  - 성능은 시스템뿐만 아니라 네트워크에 다라 달라지기 때문에 예측할 수 없음 (네트워크 고장시..)
  - 다른 조직에서 서버를 소유한 경우 관리 문제 발생 가능성

## Pipe and filter architecture 
![image](https://user-images.githubusercontent.com/86418674/206408404-7e77eb35-d99b-4678-b7e7-65ea8bc69d22.png)

- 기능 변환은 입력을 처리하여 출력을 생성
- UNIX 쉘과 같은 파이프 & 필터 모델
- 이 접근 방식의 변형은 매우 일반적. 변환이 순차적인 경우, 데이터 처리 시스템에서 광범위하게 사용되는 배치 순차모델
- Interactive 시스템에는 적합하지 않음 
- 일반적으로 입력이 관련 출력을 생성하기 위해 별도의 단계에서 처리되는 데이터 처리 어플리케이션(일괄처리 및 트랜잭션 기반)에서 사용 

- 장점
  - 워크플로 스타일은 많은 비즈니스 프로세스의 구조와 일치
  - 순차 또는 동시 시스템으로 구현할 수 있음

- 단점
  - **데이터 전송 포맷**은 변환을 위한 통신 사이에 합의되어야 함
  - **각 변환은 입력을 해석하여 처리한 후, 출력을 생성할 때 합의된 형식으로 출력**. 이러한 과정은 시스템 오버헤드를 증가시키고 **호환되지 않는 데이터 구조**를 사용하는 기능 변환에는 재사용이 불가함을 의미함


## Model-View-Controller (MVC) architecture
- 시스템 데이터로부터 presentaion와 interaction을 분리
- 세가지 logical component 
  - Model :  시스템 데이터 및 해당 데이터와 관련된 작업
  - View : 데이터가 사용자에게 표시되는 방식 
  - Controller : 상호작용(예 : key press,mouse click)을 관리, 이러한 상호작용을 뷰 및 모델 컴포넌트에 전달
  - mutilple ways to view and interact data 일때, interaction과 presentatino of data에 관한 향후 요구사항을 알 수 없을 때


- 장점
   - **데이터가 representation과 독립적으로 변경**되거나 그 반대로 변경될 수 있음.
   - **동일한 data를 다양한 방식으로 표시**할 수 있도록 지원
 - 단점
  - data model과 interaction이 단순한 경우에는, 추가적인 코드 및 코드 복잡성을 수반함.


## Control styles 

- 중앙 집중식 제어 : 하나의 서브 시스템이 다른 서브 시스템들을 시작/정지/제어 하는 전반적인 책임을 가짐
  - Call-return model : 순차 시스템 
  ![image](https://user-images.githubusercontent.com/86418674/206424360-8106110a-854d-4d25-a9cb-b4df0ffd4f50.png)
  : 메인 프로그램에서 호출된 프로그램이 끝나면 다음 함수. 트리구조. 순차 실행 

  - Manager model : 동시 시스템
  ![image](https://user-images.githubusercontent.com/86418674/206424574-277ca6a2-21ce-47ee-8a7d-a18dd749fd30.png)


- 이벤트 기반 제어 : 각 서브 시스템들은 다른 서브시스템이나 시스템 환경으로부터 외부에서 생성된 이벤트에 응답할 수 있음
  - 브로드캐스트 모델 : 이벤트가 모든 서브시스템으로 전달됨
  ![image](https://user-images.githubusercontent.com/86418674/206425102-5ef8504c-1ec8-4a6b-b0ed-60429d0a6521.png)
  - 인터럽트 기반 모델 : 인터럽트가 인터럽트 핸들러에 의해 감지되면, 처리를 위해 특정 컴포넌트로 전달되는 실시간 시스템에서 사용
  ![image](https://user-images.githubusercontent.com/86418674/206425072-f319c682-c213-4d46-9786-26acce8edf32.png)


