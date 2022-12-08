# Verification, Validation, and Test : Fundamentals of SW Test



##  Verification, Validation, Review, Test
![image](https://user-images.githubusercontent.com/86418674/206501301-d91ca2f4-c2f9-48a9-93e7-e2d1576bd801.png)


## V Model 
![image](https://user-images.githubusercontent.com/86418674/206504679-c4bc18f6-410d-4241-b266-fe0f96fb669b.png)


## Error, Fault, Failure

![image](https://user-images.githubusercontent.com/86418674/206505906-24fcbc64-5cac-40b2-8204-23252d6e2be0.png)

- Error  : "mistake" . 개발자가 실수해서
- Fault : "bug", " defect" 프로그램 실행해서 Error 가 실행되었을때. 
  - SW fault : 잘못된 스펙, SW 디자인, 코딩 
  - HW fault 
     - permanent fault : 영구적 경함. damage, fatique, improper manufacturing(휴대폰 배터리 성능감소)
     - Transient faults : 일시적 결함. voltage fluctuations, electromagnetic inference, radiation (휴대폰 발열)
- Failure : 잘못된 결과. 시스템 충돌, fault가 실행되었을때


## Testing and Debugging 

- Testing : find failure
- Debugging : identifies the root cause of a bug. repair code. checks defect is fixed correctly
- Confirmation testing : ensure the fix resolves the observed failure
- Tester : test
- Programmers : debug

![image](https://user-images.githubusercontent.com/86418674/206510334-8082477c-afdd-491f-a36b-04a8dc8958b0.png)

# Test Process


## V - Model

![image](https://user-images.githubusercontent.com/86418674/206513791-884ed742-4d8a-4283-9867-20541134673b.png)


## 단위 테스트
: 개발자가 직접 구현한 모듈을 테스트 
- White-box 테스트
- 드라이버, 스터브 
![image](https://user-images.githubusercontent.com/86418674/206513102-1de52b32-f904-411c-a754-155d99fe8373.png)
![image](https://user-images.githubusercontent.com/86418674/206513245-561d2fff-c902-4fd8-8459-6351d0ba8fc2.png)


##  통합 테스트
: 제3자 테스터가 단위테스트를 통과한 SW모듈에 대해 컴포넌트 사이의 인터페이스 및 상호 연동하는 동작을 테스트

## 시스템 테스트
: 성능검증, 기능테스트와 비 기능 테스트 

## 인수 테스트
: 완성된 시스템이 얼마나 사용자의 요구사항을 만족하였지 테스트

# Principle of Test


- Testing shows presence of defects
- Exhasutive Testing is impossible 
- Pesticide paradox : 버그를 발견해서 수정을 했지만 모든 bugs 에 효과적이지 않음. 모든 bug에 효과가 있지는 않음.
  - 기능 테스트는 성능 버그를 찾을 수 없음.
- Absence of errors fallacy : 많은 버그를 고친 것이 유저의 만족도를 보장할 수 X. (특정 지역에서만 down 희소한 버그만 남아도 만족할 수 없는 상황 )
- Context dependent : Testing is done differently in different contexts. 어떤 채를 통해서 걸러내는지. 목적에 따라 다르게 테스트
- Defect clustering : small number of modules contain most of defects. 특정한 부분에서만 유독 결함이 많이 발생. 
- Early testing : 빠르게 결함을 찾아낼수록 비용 절감



# Testing Capability Level 
:테스트 성숙도 레벨

## 레벨 1. Performed 

: 디버깅을 테스트로 인식하는 단계 

- SW 가 작동하는 것을 보여줄 분, sw 품질 보증과는 무관
- 테스팅이 디버깅과 구분되지 않음


## 레벨 2. Managed 

: 디버깅과 테스트가 구분


 테스트 전략
  - 테스트 계획이 늦게 세워짐
  - 레벨 별 테스트 수행 직전에 테스트 케이스 설계, 기능성 중심
  - 독립적인 테스트 조직은 없지만, 테스트를 연구하는 기술 그룹의 도움으로 간단한 테스트 기법과 도구등이 활용

----제대로 동작 ---- 
## 레벨 3. Defined

: SW 개발 생명주기와 통합된 표준 테스트 프로세스가 정의되는 단계

테스트 전략 
  - 테스트 계획은 요구사항 단계에서부터 시작되며 V-model의 체계를 갖춤
  - SW 개발 생명주기의 **단계별 검증과 확인** 수행
  - 테스트 레벨 별 테스트 케이스가 관련된 생명 주기 단계에서 계획되고 설계
  - 독립적인 **테스트 전문가 그룹** 구성 

## 레벨 4. Quantitiatively Managed
: 단계별로 진행되는 V&V 작업을 통한 측정 데이터 수집으로 품질이 측정되는 단계

테스트 전략
  - **품질 보증 위원회**를 구성하여 테스트 측정 프로그램을 개발하고, 수집된 측정 데이터를 정량적으로 분석하여** sw 품질을 평가**

## 레벨 5. Optimizing 

테스트 전략
  - 지속적으로 개선 활동을 계획하고 추진
  - 결함 예방과  제어가 수행됨
  - 독립적인 **테스트 프로세스 개선 그룹**의 지원으로 개선 활동을 계획하고 추진


