# Chap4.Transmission media


## Transmission media 
: means a physical path between a transmitter and a receiver to delivery data represented as electrimagnatic signals (bit streams).
The transmission media **can be split into multiple channels** in order for each signal to be transmitted without interference. 
In other words, a channel is a logical path between a transmitter and a receiver.

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
- CrossTalk : interfence. Twisted Pair에서 AA
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
