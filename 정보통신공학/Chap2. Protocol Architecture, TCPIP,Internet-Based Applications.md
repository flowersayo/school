 
# Chap2. Protocol Architecture, TCPIP,Internet-Based Application

## definition of a communication protocol(통신 프로토콜 또는 통신 규약)
- set of rules, convention that allow peer layers to communicate. 
- define format and order of message and action
- key features of a protocol 
    - syntax : format of data blocks
    - semantics : control informaion for coordigaion and err handling
    - Timing : speed matching and sequencing
    

Using a layered protocol stack, communication function is broken down into sub-functions implemented at each layer. 
And a protocol at a layer n in a device **communicate with the same protocol at the same layer** n in another device by exchanging messages. 
Application (L5) and transport(L4) layers exist only at end-hosts. (router에는 존재 X)
Only 3 layers such as network (L3) and data link (L2) and physical (L1) layers are needed for delivering user data via routers or switches.

# 5 layer Internet (TCP/IP) protocol stack                                                          
![KakaoTalk_20220418_231536555](https://user-images.githubusercontent.com/86418674/163821308-839d7505-39b3-42d3-9e94-7255d13ac7a1.jpg)

-  3,4계층에 해당하는 TCP, UDP, IP 프로토콜들은 OS(Operating system)에 포함되어 있다.
- 동일한 subnet에 연결된 디바이스는 동일한 2계층 프로토콜을 운용하고있다. (2-#14 설명)
- 2계층 프로토콜은 NIC(Network Interface Card)에 포함되어있다.
-  서로 다른 subnet 사이의 데이터 통신을 위해서는 반드시 라우터가 필요하다.
-  어떤 5계층 프로토콜이 TCP를 이용하여 여러 데이터를 동일한 destination host. D로 전송할 경우 (예를 들어 1, 2, 3번 데이터를 순서대로 전송한 경우) D 호스트의 동일한 5계층 프로토콜이 source host에서 전송한 순서대로 데이터를 받게된다. 이러한 in-order delivery는 UDP를 이용할 경우 구현되지 않는다.
- OSPF, RIP, BGP는 라우터에서 실행되는 라우팅 프로토콜들이다. - >**호스트(host)에서는 RIP, OSPF,BGP 와 같은 라우팅 프로토콜들은 동작하지 않는다**
- Network layer의 대표적인 프로토콜인 IP 는 congestion control을 한다. 
- FTP, SSH 는 loss-sensitive 서비스를 지원하는 5계층 프로토콜이므로 아래 4계층 프로토콜로 TCP를 사용한다.
- ICMP 는 IP 패킷 delivery 중에 발생한 에러를 해당 패킷을 보낸 송신지(source)에게 알려주려는 목적으로 개발된 프로토콜이다.
- DNS, RIP는 간단한 메시지를 주고받는 프로토콜이므로 4계층 프로토콜로 UDP를 사용한다.


**TCP와 UDP**

- UDP가 Internet checksum을 이용하여 error detection은 하나 error correction 즉 에러 복구는 하지 않는다. 
- 반면 TCP는 에러가 발생한 데이터를 다시 전송(retransmission) 하는 방식으로 error correction을 수행한다.

# Role and addressing at each layer

    L4) Transport L : **process-to-process** comm. using **port** number

    L3) Network L  : **host-to-host** comm (routing to destination host) using **IP** address

    L2) Data Link L :  **1-hop delivery** using network dependent layer2 address e.g., **MAC **address

Q. 호스트와 프로세스의 차이
% 인터넷에 연결된 특정 process에게 데이터를 전달하기 위해 그 process가 실행되고 있는 호스트가 인터넷에 연결된 NIC 카드에 설정된 **IP address**와 그 process가 사용하는 **port number**, 이 두 가지를 알아야합니다.  이때 IP address 와 port number를 각각 집주소와 수취인에 비유하는데, 이는 인터넷에서의 통신과 우체국을 이용한 편지통신이 유사하기 때문입니다. 즉, IP address를 이용해서 중간 라우터들이 destination host를 찾아주게 되므로 **IP 주소를 집주소**에 비유하며, destination host에 도달한 후 port number를 이용해서 해당 process에게 데이터를 전달하므로 **port number를 수취인**에 비유하게 됩니다. 

Q. 하나의 호스트에는 한 개의 IP 주소만?
IP 주소는 NIC(Network Interface Card)에 설정되는 값으로 만일 네트워크 노드가 여러 개의 NIC 카드를 장착하여 서로 다른 subnet에 연결되어 있다면 해당 호스트는 서로 다른 IP 주소를 각 NIC 카드에 설정하고 운용하게 된다.
대표적인 예가 라우터임. 라우터는 여러개의 subnet과 연결되어있으며, 서로 다른 subnet과 연결된 각 포트 마다 IP 주소가 설정되어 있음.
또한, 서버 호스트의 경우에도 서비스 지연을 줄이기 위해 둘 이상의 NIC 카드를 장착하고 각 다른 subnet에 연결시킬 수 있다. 이때 각 NIC에는 다른 IP 주소가 설정되어 운용됨.


# 계층 인터넷 프로토콜 스택
: 각 계층 별 서비스 기능(role), protocol data unit (PDU) 이름 및 사용하는 대표적인주소(address)

![20220418231356](https://user-images.githubusercontent.com/86418674/163820799-16dc6bbc-3306-42ca-84b3-6be512677748.png)



# History of the Internet and TCP 
: ARPANET (NCP) à NSFnet (original TCP/IP) -> à Internet (Updated TCP/IP, and security issues)

If a protocol defines the **large header**, then it means  the protocol
    contains **more control information**, provides more services (functions) and may take more time
    than the protocol which has a small size header.
    
    
# IPv6 VS  IPv4
: IPv4 (32bit) provides four times bigger IP addresses than IPv6 (64 bit) .
Key design factors of **IPv6 are fast** packet delivery in the core network and QoS. However, QoS tried in IPv6 has NOT been successfully implemented.


# Service Access Point (SAP)
: a logical position, where **two adjacent layers** in one entity communicate with each other by **calling function**, i.e., **primitives (request/indication/response/confirm).**
 
    

