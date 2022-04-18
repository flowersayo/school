 
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
    L5) Application L:  HTTP(web), SMTP(email), FTP(file) / DNS, HTTP ...

    L4) Transport L :           TCP          /        UDP ..     

    L3) Network L  :                       IP ..  
    
    L2.5) : MPLS

    L2) Data Link L :   ATM, FR , Ethernet, WiFi, LLC -    ARP                

                                MAC -   IEEE 802.x  

    L1) Pysical L  : Twisted Pair (TP, Coaxial cable, Optical Fiber, / radio, satellite ....

# Role and addressing at each layer

    L4) Transport L : **process-to-process** comm. using **port** number

    L3) Network L  : **host-to-host** comm (routing to destination host) using **IP** address

    L2) Data Link L :  **1-hop delivery** using network dependent layer2 address e.g., **MAC **address

#PDU
: message at L5, segment at L4, packet at L3, frame at L2


# History of the Internet and TCP 
: ARPANET (NCP) à NSFnet (original TCP/IP) -> à Internet (Updated TCP/IP, and security issues)

If a protocol defines the **large header**, then it means  the protocol
    contains **more control information**, provides more services (functions) and may take more time
    than the protocol which has a small size header.
    
    
Q. 호스트와 프로세스의 차이
% 인터넷에 연결된 특정 process에게 데이터를 전달하기 위해 그 process가 실행되고 있는 호스트가 인터넷에 연결된 NIC 카드에 설정된 **IP address**와 그 process가 사용하는 **port number**, 이 두 가지를 알아야합니다.  이때 IP address 와 port number를 각각 집주소와 수취인에 비유하는데, 이는 인터넷에서의 통신과 우체국을 이용한 편지통신이 유사하기 때문입니다. 즉, IP address를 이용해서 중간 라우터들이 destination host를 찾아주게 되므로 **IP 주소를 집주소**에 비유하며, destination host에 도달한 후 port number를 이용해서 해당 process에게 데이터를 전달하므로 **port number를 수취인**에 비유하게 됩니다. 
