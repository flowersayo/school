

# Chap1. Data Communications, Data Networks, and Internet

What is a 5-layer protocol stack used in the Internet? 
: (L5) Application layer - (L4) Transport layer - (L3) Network layer - (L2) Data link layer - (L1) Physical layer

##  What are top 10 technology trends during CES2022? 
: Data Analytics, Cloud, IoT, 5G, Sensor, AI

## Type of network traffic

- loss-sensitive : filesharing(p2p), voD streaming, Email 
- Bandwidth or latency-sensitive : Voice over IP(VoIP), video conferencing,online gaming, real-time streaming 

What applications generate real-time traffic in the Internet? 
: VoIP, Video conferencing, on-line gaming, real-time streaming

+ 인터넷 뱅킹은 Loss sensitive

Email service which is the very first Internet application is a real-time service? 
: No, it is a non-real time and loss-sensitive service.

 
인터넷 가입자의 단말기에서 운용되는 응용은 지연(latency)에 민감하거나, 오류(loss)에 민감한 트래픽을 생성하게 된다. 따라서 망으로 유입되는 트래픽이 통신망 운용자에게 요구하는 서비스품질, 즉 **QoS(Quality of Service) 요구 사항이 응용 마다 다를 수 있다**

## 5G
- Good : cost , current
- Not Good : coverage, capacity

5G는 coverage와 network capacity, cost, 그리고 운영 시 필요한 파워 측면에서, 소형 IoT 단말기로 제공되는 서비스에 적합한 통신기술로 사용되고 있다. 

## LPWA ( Low Power Wide Area)
- celluar LPWA (e.g. NBIOT)
- non-cellular LPWA (e.g. LORA: Long Range Radio)
-> LoRA는 베터리로 운영되는 단말기를 이용한 IoT 서비스의 통신을 지원하기 위해 등장한 Low power wide area (LPWA) 기술

## 2022 Global Networking Trends by Cisco; NaaS( Network as a Service)
- `NaaS` : a complete service package for operating networking without owning physical infrastructure. <br/>
    - eliminates hardware costs. 설치과정/유지보수 X 
    - cloud model that enables users to easily operate the network and achieve the outcomes.
- `SASE` : an architecture for connecting users to applications and data from the office and the home on the go.



## Attributes of a transmission line(link)

    - Capacity represented as "bandwidth (bits/second)"

    - reliability represented as an error rate

    - distance without attenuation

    - cost
    
## 용어

- `Maximum - latenct(Delay)` : 지연 상한치 .  이 이상 딜레이 발생시 서비스를 할 수 없다고 생각하는 수치.
- `Minimum - through post(bandwidth)` : 최소한 이정도 data는 지나갈 수 있어야 한다하는 bandwidth 의 크기 

## End system technology for better communication

Transmission Services 
    - Multiplexing(공유) : The ability of a number of devices to share a transmission facility.  한사람이 link를 오래 독점하지 않도록 조절하는게 중요. 
    
    - Compression(압축) :squeezing the data down so that a lower-capacity cheaper transmission facility can be used. 
    ex. 2G TDMA

## Internet Service Provider (ISP)
- KT , U+, SKT
- ATMT , T mobile, Contest
- china mobile
- Orange
- NTT 

## Two WAN technologies
- Circuit Switching (C.S.)
- Packet Switching (P.S.);

https://swalloow.tistory.com/55


## Circuit Switching 
: dedicated communication path ex. telephone 
-  connection-set up delay(routing) before data delivery 
-  no sharing during delivery 
-  data 를 내려보내기 시작한 이후로 부터는 no delay
-  no buffer, no header, no processing 


## Packet Switching 
: packets are **independently** passed from node to node between src and dest 

- routing during delivery 
- no path set up before delivery 
- waiting ,transmission delay, buffer queing delay 
- store and forward
- 
Packet switching (PS)은 각 사용자가 링크를 사용할 수 있는 고정된 시간이 정해져 있지 않으므로 링크 대역폭(transmission rate 혹은 bandwidth)에 여유(available)가 있는 경우 어느 사용자나 사용할 수 있다. 따라서 인터넷과 같이 PS를 사용하는 네트워크에서는 한 명의 사용자가 링크 대역폭의 full rate를 사용하는 것이 가능하다

## statistics TDM vs synchronous TDM
TDM : Time Division Multiplexing 

- statistics TDM : slots are allotted dynamically
- synchronous TDM : can not use full rate of link

📌the advantages of splitting a message into multiple packets
(1) efficient media access control: multiple users can share a link in an efficient way and thus the** maximum latency can be reduced**
(2) efficient error control: the bit overhead used to restore the end-to-end errors during data delivery can be reduced
(3) various data rate supported: end hosts which generate data at various rate can be connected when using packet switching

## FR ( Frame Relay)
: break one message into multiple frames 
- variable frame size 
- higher data rates and low err rate


## ATM (Asynchronous Transger Mode)
: cell relay
- fixed-length packers called cells
- little overhead for err control
- allow multiple virtual channels with the data rate on each channel dynamically set on demand

FR 의 데이터 전송단위인 frame의 크기는 ATM 의 cell 보다 더 크기 때문에 같은 크기의 메시지를 FR를 이용해 전송할 경우 전송되는 frame 의 개수는 ATM의 cell 숫자 보다 더 적다. Header는 각 frame 혹은 cell 마다 추가되므로 포함되는 header 숫자도 frame의 경우 더 적다.

📌Virtual Circuit(VC)
c.s : preplanned route. -> fixed route during data delivery
p.s : data can be delayed or dropped at output buffers 


## Can you tell why ATM is a packet switching technology, not a circuit switching?(p.26)
![KakaoTalk_20220417_020422630](https://user-images.githubusercontent.com/86418674/163684508-a8c986e0-081d-4131-a8ff-3dbd15ad5309.jpg)



**Which features of FR and ATM belong to C.S. or P.S.?**
공통 
- Layer 2 (Data Link) technology
- Less overhead for err control : packet으로 짤라서 보내므로 err 관리 용이
- p.s 적 특성 
    - one message -> multiple chynks (frame/cells)
    - support dynamic bandwidth usage and efficient err recovery
    - no resource guaranteed -> delayed or dropped at router 
- c.s 적 특성
    - connection-oriented protocol : fixed router(VC) before delivery -> same path used for multiple chnks -> in-order delivery 

**What are the differences between FR and ATM?**

| FR | ATM |
| :--- | :---: | 
| **Large frame**,variable size | **small cell**, Fixed size|
| **Less overhead** per data (**Better link utilization**) | **higher speed **(lower delay) |
|SW oriented | HW oriented | 



# the differences between LAN and WAN?

- LAN은 주로 하나의 기관에 속한 지역에 설치되어 해당 기관이 소유/관리한다면, WAN은 공공지역 설치되고 소유주도 여러명 일수있다.
-  WAN은 소유주가 다른 다양한 네트워크들이 연결되어 있으므로, LAN 에서 보다 WAN에서 congestion (혼잡) 이 더 자주 발생하게 된다.
- 일반적으로 WAN을 구성하기위해 설치되는 링크의 용량(transmission rate)은 LAN에 사용되는 링크의 용량보다 크다. 
- Client가 on-premises 서버에 연결할 때 보다, off-premises 서버에 접속할 때 평균적으로 느끼는 지연(latency)이 더 길다.
- LAN은 하나의 기관에서 관리하고 그 범위가 WAN에 비해 크지 않으므로 LAN에서 발생하는 트래픽 양과 패턴은 WAN 의 경우보다 예측이 쉽다.

WAN에 설치되는 링크의 절대적인 용량(bandwidth)은 LAN 보다크다. 단지 client end host 가 WAN을 사용할 때 느끼는 available bandwidth가 더 작다는 것입니다. 이것은 Client가 on-premises 서버에 연결할 때 보다, off-premises 서버에 접속할 때 평균적으로 느끼는 지연(latency)이 더 긴 것과 같은 이유이다.

![KakaoTalk_20220417_022957251](https://user-images.githubusercontent.com/86418674/163685352-c4cea42b-98e5-4c6f-afb1-f10bd7520ef0.jpg)

- ISPs can be connected to each other via IXP or peering.
- (Point of Presence) PoP is a set of network devices of a provider ISP where consumer ISPs can connect to the provider ISP.

인터넷 코아 네트워크는 계층적인 구조를 이루고 있으며, 두 네트워크들을 연결하는 기술은 다양하다. 우선, customer ISP가 provider ISP에 연결될 수 있는데 이때 **provider ISP의 router들이 모여있는 지점**을  Point of Presence  라고 한다. 또한, **상위계층 ISP와 연결하는 대신 같은 계층의 ISP들간에 직접 연결하는 방식**을  Peering  이라 하며, 이는 비용절감의 효과가 있다. 더불어, 다중의 ISP들이 제3의 회사가 제공하는  **IXP **를 통해서 연결될 수도 있다.

## standard making organization

- ISO : ASCII
- ITU : ATM, FR
- ANSI : SQL
- IEEE : MAC , media access control at layer 2
- IETF : protocols such as IP, TCP, HTTP, etc at layer 3,4, and 5 , RFC (tandard document issued by IETF)
- 
## Quiz

- 데이터를 전송하는 source host에서 데이터를 수신하는 destination host 사이의 경로를 설정(routing)하는 기능은 5계층 중 응답
**network layer에서 실행**된다. 따라서, 이 계층의 가장 기본적인 service model은 **host-to-host delivery** 서비스를 제공하는 것이다.

- Data communication의 transmission efficiency를 높이기 위해 등장한 대표적인 소프트웨어 기술 중 **multiplexing** 은 하나의 링크를 이용하여 다수의 사용자가 동시에 데이터를 전송할 수 있는 기술이며, **compression**은 고품질, 고용량의 사용자 데이터를 저용량 링크를 이용해서도 전송할 수 있는 기술이다. 


-고속 WAN의 확산을 촉진시킨 요인 (p.12)
    a. Cloud-computing 기술의 발전
    b. 팬데믹으로 인한 재택근무 확산
    c. off-premises(회사 외부 Cloud) server 확대 
    d. 고품질의 영상을 생성하는 이동 인터넷 단말기 등장
    e. Client-Server 구조에 기반한 응용 개발의 확대
 
  ❗ On-premise 서버는 특정 기관이 소유하고 있는 LAN 내부에 연결된 서버를 의미하므로 만일 on-premise 서버를 확장하여 작업하는 기관의 경우 WAN으로 나가는 트래픽은 줄어들게 된다.
  
-인터넷이 동작하는  5개의 계층

layer 5 : application
layer 4 : transport
layer 3 :  network
layer 2 : data link
layer 1 : physical

-아래 나열된 프로토콜 혹은 기술을 표준화한 기구
 FR (Frame Relay) → ITU, ATM (Asynchronous Transfer Mode)  → ITU, HTTP (HyperText Transfer Protocol) → IETF,
IP (Internet Protocol) → IETF,
Ethernet (CSMA/CD) → IEEE, Wi-Fi (CSMA/CA) → IEEE, ASCII(American Standard Code for Information Interchange) → ISO, TCP (Transmission Control Protocol) → IETF
