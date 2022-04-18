# Chap4.Transmission media


## Transmission media 
: means a physical path between a transmitter and a receiver to delivery data represented as electrimagnatic signals (bit streams).
The transmission media **can be split into multiple channels** in order for each signal to be transmitted without interference. 
In other words, a channel is a logical path between a transmitter and a receiver.

📌Bit를 signal로 변환하는데 소요되는 시간을  transmission delay  이라고 하고, 1bit가 transmitter를 출발하여 receiver에 도달하는데 걸리는 시간을  propagation delay 라고 한다.

## A channel bandwidth (CBW) 
: a range of frequency spectrum defined in the channel. However, its effective bandwidth (EBW) is determined considering channel noise. 

## signal
A signal is composed of multiple frequencies and a signal bandwidth equals a range of the frequencies in a frequency spectrum. 

ex) In case a signal is made of 3 frequencies such as 10GHz, 20GHz, and 30GHz --> its bandwidth is 20GHz.
**(signal) bandwidth : highest freq - lowest freq**

Data rate cannot be more than (channel/signal) bandwidth and is affected by attenuation, distortion, noise and interference. 
Thus, if a channel A has more bandwidth than a channel B then it is "possible" for A to carry more data than B. But we should consider characteristics of the channels together to correctly answer the question.

## Bandwidth
Bandwidth can be represented as **Hz** or **bps**, e.g., **10GHz** bandwidth means **10Gbps**.
Hz : 초당 몇회 cycle이 존재하는지 
bps (bit/s) : 초당 몇 bit를 전송하는지 
-> 하나의 Cycle을 돌때마다 하나의 bit를 전송하게 되므로 결국 같은 의미!

**High frequency** communication can provide **more bandwidth** and **shorter coverage** than low frequency one. 
For example, 5GHz wi-fi can support up to 1300Mbps bandwidth while 2.4GHz, up to 540 Mbps.
In theory, higher frequency means (lower wavelength, higher BW/data rate, higher attenuation)

## Transmission Impairments

: 신호가 전송되는 중 거리에 따라 혹은 전송 미디엄의 성질에 따라 신호 세기가 약해지는 현상을   attenuation  이라고 하며,  delay distortion 는 signal이 receiver 도착했을 때, signal을 구성하는 주파수들의 전파속도가 달라 발생하는 시그날 왜곡(out-of-phase)현상을 말한다. 또한, 신호 전송 중 발생하는 다양한 noise들 중  CrossTalk(Interfenrence) 는 twisted Pair에서 주로 발생하는 noise로 두 구리선에서 전송되는 신호가 서로 결합하는 현상을 말하며,  Intermodulation  은 같은 링크에서 전송되는 여러 개의 신호들 중 두 개 주파수의 합 혹은 차에 해당하는 주파수가 생성되어 동일한 값의 주파수를 사용하는 또 다른 신호가 있는 경우 그 신호 전달을 방해하는 현상을 말한다

**1. attenuation **
: signal strength falls . proportional to "media length" and "frequency".

Q. 고주파수에 비례하는 이유? 
A. 초당 더 많이 진동 -> 열 AA발생. Power Voltage 감소

**2. delay distortion **
- Only in guided(wire) media, propagation velocity varies with frequency -> differen arrive time -> phase shifts

**3. noise**
: Additional Signal 

- Thermal
- Intermodulation : Produce signals thar are sum,difference or multiples of original frequencies 
- CrossTalk : Interfenrence. Twisted Pair에서 AA
- Impulse : short duration, irrequlat pulses



Overall data rate can be affected by attenuation, delay/attenuation distortion, (impulse) noise, interference (or crosstalk), distance, number of attached receivers to the shared medium as well as a signal bandwidth of the media itself through which the data goes.

**Repeater eliminates noise** after amplifying power, while** amplifier does not care noise**.

**Digital signal is more susceptible to attenuation** than analog signal, thus may need more repeaters in a given distance. 
In addition, **digital signal is more susceptible to interference (crosstalk), delay distortion, impulse noise** than analog signal.

Q. digital signal 이 analog signal보다 noise에 덜 영향받는다고 강의자료에 나와있는데..




**Guided media transmission's data rate is affected by characteristics of the media** itself. Meanwhile, **Performance of wireless media is mainly determined by the Bandwidth (BW) of signal**.

Transmission capacity = Data rate (~1Mbps) < Signal bandwidth (1MHz)
    - Data rate depends on "distance" and "way of communication (p2p, mp)"
    - More receivers attached on the media -> more attenuation involved during transmission.



# Three wired media 
: Twisted Pair (TP), Coaxial cable (coax), Optical fiber

   - Frequency: TP < coax < Optical fiber (higher)
   - BW: TP < coax < Optical fiber (more)
   - Attenuation: TP > coax > Optical (lower)   

이론상 Network link의 길이가 길수록 receiver에 도달한 신호의 attenuation이 더 크다. 또한 attenuation은 고주파수 신호에서 더 많이 발생한다. 그러나, 다양한 기술로 attenuation을 낮추거나 제거할 수 있기 때문에 고주파수 신호를 구현하는 링크(transmission medium) 라고 해서 반드시 attenuation 이 더 크게 발생한다고 할 수는 없다.

Signal power relations in TP
    - Insertion loss (A = P_t/P_r) : amount of attenuation, lower is better

    - NEXT loss (= P_t/P_c) : capability of rejecting crosstalk (P_c), higher is better

    - ACR = how much larger the received signal strength (P_r) is compared to crosstalk (P_c).  Ideally NEXT > A, i.e., P_r should be larger than P_c, otherwise,crosstalk cancellation is required.

    - Better communication means lower insertion loss(A_dB) and higher Next loss(NextdB).

    - Crosstalk cancellation may be required if received signal power(P_r) is less than crosstalk signal power(P_c).

Applications
   - TP: Telephone line, Ethernet / coax: HFC / optical Fiber: FTTP, long-distance telephone service,

Antenna
   - Omnidirection antenna : radiates "uniformly in all direction in one plane (한 평면에서만 균등)"   ex) radio broadcasting antennas, and antennas for cell phones, FM radios, walkie-talkies, wireless computer networks, cordless phones, GPS

   - Directional antenna : radiate greater power in specific directions.  ex) Parabolic antenna, Helical antenna, Horn antenna...

Three wireless propagation operations
  (a) (~ 2 MHz) : Ground wave propagation - long distance, ex) AM

  (b) (2~30MHz) : Sky wave propagation - multi-hop between curvature of the Earth and ionosphere, ex) Military comm., Amature radio

  (c) (30MHz ~ ) : Line-of-Sight (LoS) propagation, ex) Microwave comm.(FM, UHF TV), Satellite communication,..

      - Radio LoS can support longer distance than Optical LoS.
