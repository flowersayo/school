 
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
    than the protocol which has a small size header
