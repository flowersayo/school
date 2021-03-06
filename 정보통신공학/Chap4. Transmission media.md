# Chap4.Transmission media


## Transmission media 
: means a physical path between a transmitter and a receiver to delivery data represented as electrimagnatic signals (bit streams).
The transmission media **can be split into multiple channels** in order for each signal to be transmitted without interference. 
In other words, a channel is a logical path between a transmitter and a receiver.

๐Bit๋ฅผ signal๋ก ๋ณํํ๋๋ฐ ์์๋๋ ์๊ฐ์  transmission delay  ์ด๋ผ๊ณ  ํ๊ณ , 1bit๊ฐ transmitter๋ฅผ ์ถ๋ฐํ์ฌ receiver์ ๋๋ฌํ๋๋ฐ ๊ฑธ๋ฆฌ๋ ์๊ฐ์  propagation delay ๋ผ๊ณ  ํ๋ค.

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
Hz : ์ด๋น ๋ชํ cycle์ด ์กด์ฌํ๋์ง 
bps (bit/s) : ์ด๋น ๋ช bit๋ฅผ ์ ์กํ๋์ง 
-> ํ๋์ Cycle์ ๋๋๋ง๋ค ํ๋์ bit๋ฅผ ์ ์กํ๊ฒ ๋๋ฏ๋ก ๊ฒฐ๊ตญ ๊ฐ์ ์๋ฏธ!

**High frequency** communication can provide **more bandwidth** and **shorter coverage** than low frequency one. 
For example, 5GHz wi-fi can support up to 1300Mbps bandwidth while 2.4GHz, up to 540 Mbps.
In theory, higher frequency means (lower wavelength, higher BW/data rate, higher attenuation)

## Transmission Impairments

: ์ ํธ๊ฐ ์ ์ก๋๋ ์ค ๊ฑฐ๋ฆฌ์ ๋ฐ๋ผ ํน์ ์ ์ก ๋ฏธ๋์์ ์ฑ์ง์ ๋ฐ๋ผ ์ ํธ ์ธ๊ธฐ๊ฐ ์ฝํด์ง๋ ํ์์   attenuation  ์ด๋ผ๊ณ  ํ๋ฉฐ,  delay distortion ๋ signal์ด receiver ๋์ฐฉํ์ ๋, signal์ ๊ตฌ์ฑํ๋ ์ฃผํ์๋ค์ ์ ํ์๋๊ฐ ๋ฌ๋ผ ๋ฐ์ํ๋ ์๊ทธ๋  ์๊ณก(out-of-phase)ํ์์ ๋งํ๋ค. ๋ํ, ์ ํธ ์ ์ก ์ค ๋ฐ์ํ๋ ๋ค์ํ noise๋ค ์ค  CrossTalk(Interfenrence) ๋ twisted Pair์์ ์ฃผ๋ก ๋ฐ์ํ๋ noise๋ก ๋ ๊ตฌ๋ฆฌ์ ์์ ์ ์ก๋๋ ์ ํธ๊ฐ ์๋ก ๊ฒฐํฉํ๋ ํ์์ ๋งํ๋ฉฐ,  Intermodulation  ์ ๊ฐ์ ๋งํฌ์์ ์ ์ก๋๋ ์ฌ๋ฌ ๊ฐ์ ์ ํธ๋ค ์ค ๋ ๊ฐ ์ฃผํ์์ ํฉ ํน์ ์ฐจ์ ํด๋นํ๋ ์ฃผํ์๊ฐ ์์ฑ๋์ด ๋์ผํ ๊ฐ์ ์ฃผํ์๋ฅผ ์ฌ์ฉํ๋ ๋ ๋ค๋ฅธ ์ ํธ๊ฐ ์๋ ๊ฒฝ์ฐ ๊ทธ ์ ํธ ์ ๋ฌ์ ๋ฐฉํดํ๋ ํ์์ ๋งํ๋ค

**1. attenuation **
: signal strength falls . proportional to "media length" and "frequency".

Q. ๊ณ ์ฃผํ์์ ๋น๋กํ๋ ์ด์ ? 
A. ์ด๋น ๋ ๋ง์ด ์ง๋ -> ์ด AA๋ฐ์. Power Voltage ๊ฐ์

**2. delay distortion **
- Only in guided(wire) media, propagation velocity varies with frequency -> differen arrive time -> phase shifts

**3. noise**
: Additional Signal 

- Thermal
- Intermodulation : Produce signals thar are sum,difference or multiples of original frequencies 
- CrossTalk : Interfenrence. Twisted Pair์์ AA
- Impulse : short duration, irrequlat pulses



Overall data rate can be affected by attenuation, delay/attenuation distortion, (impulse) noise, interference (or crosstalk), distance, number of attached receivers to the shared medium as well as a signal bandwidth of the media itself through which the data goes.

**Repeater eliminates noise** after amplifying power, while** amplifier does not care noise**.

**Digital signal is more susceptible to attenuation** than analog signal, thus may need more repeaters in a given distance. 
In addition, **digital signal is more susceptible to interference (crosstalk), delay distortion, impulse noise** than analog signal.

Q. digital signal ์ด analog signal๋ณด๋ค noise์ ๋ ์ํฅ๋ฐ๋๋ค๊ณ  ๊ฐ์์๋ฃ์ ๋์์๋๋ฐ..




**Guided media transmission's data rate is affected by characteristics of the media** itself. Meanwhile, **Performance of wireless media is mainly determined by the Bandwidth (BW) of signal**.

Transmission capacity = Data rate (~1Mbps) < Signal bandwidth (1MHz)
    - Data rate depends on "distance" and "way of communication (p2p, mp)"
    - More receivers attached on the media -> more attenuation involved during transmission.



# Three wired media 
: Twisted Pair (TP), Coaxial cable (coax), Optical fiber

   - Frequency: TP < coax < Optical fiber (higher)
   - BW: TP < coax < Optical fiber (more)
   - Attenuation: TP > coax > Optical (lower)   

์ด๋ก ์ Network link์ ๊ธธ์ด๊ฐ ๊ธธ์๋ก receiver์ ๋๋ฌํ ์ ํธ์ attenuation์ด ๋ ํฌ๋ค. ๋ํ attenuation์ ๊ณ ์ฃผํ์ ์ ํธ์์ ๋ ๋ง์ด ๋ฐ์ํ๋ค. ๊ทธ๋ฌ๋, ๋ค์ํ ๊ธฐ์ ๋ก attenuation์ ๋ฎ์ถ๊ฑฐ๋ ์ ๊ฑฐํ  ์ ์๊ธฐ ๋๋ฌธ์ ๊ณ ์ฃผํ์ ์ ํธ๋ฅผ ๊ตฌํํ๋ ๋งํฌ(transmission medium) ๋ผ๊ณ  ํด์ ๋ฐ๋์ attenuation ์ด ๋ ํฌ๊ฒ ๋ฐ์ํ๋ค๊ณ  ํ  ์๋ ์๋ค.

Applications
   - TP: Telephone line, Ethernet / coax: HFC / optical Fiber: FTTP, long-distance telephone service,

# Signal power relations in TP (Twisted Pair)
: P_t - ์์์ง์์์ ์ ํธ , P_r - ๋์ฐฉ์ง์์์ ์ ํธ, P_c - crosstalk

    - `Insertion loss` (A = P_t/P_r) : **amount of attenuation**, lower is better . 

    - `NEXT loss` (= P_t/P_c) : capability of **rejecting crosstalk** (P_c), higher is better. 

    - `ACR` = how much larger the received signal strength (P_r) is compared to crosstalk (P_c).  Ideally NEXT > A,
            i.e., P_r should be larger than P_c, otherwise,crosstalk cancellation is required.

-> Better communication means lower insertion loss(A_dB) and higher Next loss(NextdB).
-> Crosstalk cancellation may be required if received signal power(P_r) is less than crosstalk signal power(P_c).



# Antenna
   - Omnidirection antenna : radiates "uniformly in **all direction** in one plane (ํ ํ๋ฉด์์๋ง ๊ท ๋ฑ)"  <br/>
     ex) radio broadcasting antennas, and antennas for cell phones, FM radios, walkie-talkies, wireless computer networks, cordless phones, GPS

   - Directional antenna : radiate greater power in **specific directions**.  ex) Parabolic antenna, Helical antenna, Horn antenna...

# Three wireless propagation operations
  (a) (~ 2 MHz) : Ground wave propagation - long distance, ex) AM

  (b) (2~30MHz) : Sky wave propagation - multi-hop between curvature of the Earth and ionosphere, ex) Military comm., Amature radio

  (c) (30MHz ~ ) : Line-of-Sight (LoS) propagation, ex) Microwave comm.(FM, UHF TV), Satellite communication,..

      - Radio LoS can support longer distance than Optical LoS. 
      
      
