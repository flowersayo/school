# Chap7 Data Link Control Protocols

## Sliding window Flow control

How it works? TX can send more than one frame in limitation of a window size denoted as W without waiting for an ACK from RX.

Need a (k-bit) sequence number which is sent in each frame

(ex) with k=3, frames can be numbered 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, .... -> max window size = 2^k-1 (given k bit)

W can be 8 when k is 3 WHY?

More efficient than Stop-and-wait protocol since **sliding window can send additional frames** while waiting an ACK from RX.

Utilization depending on a window size W
(case 1) W >= (T_trans + 2 x T_prop) / T_trans  --> Utilization is 100% -> link 가 계속 일함.
(case 2) W < (T_trans + 2 x T_prop) / T_trans    --> Utilization = ( W x T_trans ) / (T_trans + 2 x T_prop) x 100  < 100%


## two ACKs used used for Sliding window Flow control

- RR5 means RX received well up to Frame4, denoted as F4 and is ready for F5
- RNR5 means RX received well up to Frame4, i.e., F4 but is **not ready** for F5 <-- Flow control only

## Piggybacking 
: Sending user data and ACK together and saving bandwidth in full-duplex connection

(case 1) sending (user DATA + new ACK) using I-frame of HDLC
(case 2) sending only (ACK) using S-frame of HDLC
(case 3) sending (user DATA + repeated ACK) using I-frame of HDLC

## “Framing” 이란 ? 
: 송신지(sender)에서는 상위계층 (L3)에서 내려온 데이터를 frame으로 만드는 작업을 말하며, 
수신지(receiver)에서는 transmission media를 통해서 전달받은 bit들을 의미있는 하나의 단위, 즉 프레임으로 구별하는 작업을 말함

## Automatic Repeat Request (ARQ) 
: Backward Error Correction (BEC) i.e., retransmission by TX.

- stop and wait ARQ
- sliding window ARQ
  - Go back N ARQ
  - Selective reject(repeat) ARQ
  
❓ How to detect "lost frames" : timeout at TX , out-of-order at RX (only when using sliding window)
What does "reliable transmission" mean? : No loss and in-order data transfer
 
## Stop-and-wait ARQ: positive ACK (ACK0/ACK1), no negative ACK

Q.  Why we need alternative ACKs like ACK0/ACK1? 
A. In order to distinguish the duplicate frame sent by TX when ACK from RX is lost.

Go-back-N ARQ: RR, REJ, receive widow size = 1 

REJ : Negative ACK. Transmitter retransmit  that frame in err and all subsequent
RR : Receive Ready

Q. What does REJ5 means? : Please retx from F5 and subsequent frames, i.e. go back to F5), Only **one timer attached to the oldest frame** in its sending buffer.

## Selective reject ARQ
: RR, SREJ, requires more buffer space at RX, more complicated window management, but less retransmission overhead 

--> **Good for long propagation connection like satellite communication**, Timers attached at individual frames in its sending buffer

## High-level Data Link Control (HDLC) 
HDLC is used for a point-to-point link in WAN

Q.What is bit-stuffing in HDLC and why is it required?
A. bit-stuffing is to avoid confusion with data containing start, end flag. 
ex. data부분에 시작, 끝 flag와 중복되는 패턴이 나오는 걸 막으려고 1이 다섯개 나오면 0을 붙이도록함.

- NRM(Normal Response Mode) : Primary - Second
- ABM(Asynchronous Balanced Mode): Combined - Combined

Q. Which one between NRM and ABM is more appropriate for **full-duplex p2p link**? 

A. **ABM** since both stations work as primary/secondary and thus no polling overhead for data transfer.

HDLC defines three types of frames : Information frame (**I-frame**), Supervisory frame (**S-frame**) and Unnumbered frame (**U-frame**)

HDLC operation consists of Link setup using U-frames data, transfer using I- and S-frames, link disconnect using U-frames

What frames have Information field in HDLC? I-frame and U-frame
