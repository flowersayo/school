Which features of FR and ATM belong to C.S. or P.S.?
Can you tell why ATM is a packet switching technology, not a circuit switching?
What are the differences between FR and ATM?
Can you tell the differences between LAN and WAN?
ISPs can be connected to each other via IXP or peering.
(Point of Presence) PoP is a set of network devices of a provider ISP where consumer ISPs can connect to the provider ISP.
What institute standardizes the media access control at layer 2? : IEEE
What institute standardizes protocols such as IP, TCP, HTTP, etc at layer 3,4, and 5?  IETF
What is the standard document issued by IETF called?  RFC
--
Can you explain the definition of a communication protocol?
Using a layered protocol stack, communication function is broken down into sub-functions implemented at each layer. And a protocol at a layer n in a device communicate with the same protocol at the same layer n in another device by exchanging messages. 
Application (L5) and transport(L4) layers exist only at end-hosts.
Only 3 layers such as network (L3) and data link (L2) and physical (L1) layers are needed for delivering user data via routers or switches.
5 layer Internet (TCP/IP) protocol stack                                                          
    L5) Application L:  HTTP, SMTP, FTP / DNS, HTTP ...

    L4) Transport L :           TCP          /        UDP ..     

    L3) Network L  :                       IP ..             

    L2) Data Link L :  LLC -    ARP, MPLS (2.5 layer) ..                  

                                MAC -   IEEE 802.x   / ATM, FR ..

    L1) Pysical L  : Twisted Pair (TP, Coaxial cable, Optical Fiber, / radio, satellite ....

Role and addressing at each layer
    L4) Transport L : process-to-process comm. using port number

    L3) Network L  : host-to-host comm (routing to destination host) using IP address

    L2) Data Link L :  1-hop delivery using network dependent layer2 address e.g., MAC address

PDU : message at L5, segment at L4, packet at L3, frame at L2
History of the Internet and TCP : ARPANET (NCP) à NSFnet (original TCP/IP) à Internet (Updated TCP/IP, and security issues)
If a protocol defines the large header, then it means  the protocol
    contains more control information, provides more services (functions) and may take more time
    than the protocol which has a small size header
