# Chap6. Error Detection and Correction


## Serial communication 
: one bit after another over a single channel,

##  `Asynchronous` transmission 


## `Synchronous` transmission 
 
  (1) sending a separate clock signal -> good for short distance, but impairments for long distance. <br/>
  (2) Embed the clocking info in data signal : *Manchester encoding <br/>


*Manchester encoding : 디지털 인코딩의 한 형태로, 송신측은 비트 중간에 전압변이를 만들어 전송하고 수신측은 전압변이 감지로 전달된 신호를 파악하여 전송 속도를 알아낼 수 있게 된다. 
아래 두가지 방식이 있으며, 송/수신 사이 동기화가 간단하고 오류율이 적으나 대신 동일한 데이터 전송시 추가 대역폭이 필요하다.
  - G.E. Thomas Convention (수업시간에 보여준 방식) : a bit value of “1” is a transition from high to low (하향천이) and a bit value of “0” is a transition from low to high (상향천이) 

  - IEEE 802.3 Convention : a bit value of “1” is a transition from low to high (상향천이) and a bit value of “0” is a transition from high to low (하향천이).  The encoding of the data can be done using XOR between the data and the clock signal.

  (3) framing : bit(byte)- use preamble(머릿말) and postamble(끝말) bit patterns <br/>
  
## Synchronous Transmisstion Efficiency

- Block of data is trasmitted in a steady stream without start and stop bits ex) HDLC,LAN
- Higher efficient & lower overhead than asynchronous for large blocks of data ex) HDLC scheme uses a total of 48 bits for per frame 
 - overhead 48/(8000+48) =0.6
 - efficiency = 8000/(8000+48) =99.4
 
 
## Asynchronous transmission 
: 1 start-bit, 1or2 stop bits, 1 parity bit (option) for sending upto a 8bit-character
, Data are transmitted one char at a time. not sending long and uninterrrupted streams of bits.

  - each char 의 시작에서 start bit(binary 0) 존재
  - each char 는 5~8 bits
  - 마지막에는 even or odd parity bit 
  - last bit is stop bit(binary 1) with the length og 1,1.5 or 2 ordinary bits
-> Receiver samples each bit in the char and wait in idle state (binary 1) -> Receuver has a new opportunity to reynchronizes at the beginging of each char

📌How to compute overhead (additional bits except data payload that is a layer 3 PDU) and efficiency


📌Can you tell pros and Cons of asynchronous and synchronous communication?

**asynchronous**

- slower transmission, due to the extra bits and the gaps
- overhead of 2 or 3 bits per char (20% or more) ex. lower bandwidth efficiency
- cheap and easy (no clock sharing)
- simpler
-  good for data with large gaps (keyboard) ex. when data is sent sporadically via RS232C or modems (computer - to - telephone line) for many dial-up internet access application
- timing errors do not accmulate from char to char

**synchronous**

- Fast transmission
- Higher bandwidth efficiency & lower overhead 
- Hardware is more costly; needs a common clock signal, or some way of sharing it
- slightly more complicated
- cumulative timing error due to large block of bits.
- used in most data network protocols such as Ethernet, ATM




📌What is principle of error detection in data communication system?
: additional bits (error -detecting code or check bits) are added by transmitter. the code is recalclated and checked by receiver.

There are parity check and CRC at L2 and Internet checksum at L3 (IPv4) and L4(TCP/UDP);
TCP/UDP checksum perform the end-to-end error detection since an intermediate node in the network may not implement error detection algorithm at L2 or L3.
