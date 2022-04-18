# Chap4.Transmission media


Transmission media means a physical path between a transmitter and a receiver to delivery data represented as electrimagnatic signals (bit streams).
The transmission media can be split into multiple channels in order for each signal to be transmitted without interference. In other words, a channel is a logical path between a transmitter and a receiver.
A channel bandwidth (CBW) is a range of frequency spectrum defined in the channel. However, its effective bandwidth (EBW) is determined considering channel noise. 
A signal is composed of multiple frequencies and a signal bandwidth equals a range of the frequencies in a frequency spectrum. ex) In case a signal is made of 3 frequencies such as 10GHz, 20GHz, and 30GHz --> its bandwidth is 20GHz.
Data rate cannot be more than (channel/signal) bandwidth and is affected by attenuation, distortion, noise and interference. Thus, if a channel A has more bandwidth than a channel B then it is "possible" for A to carry more data than B. But we should consider characteristics of the channels together to correctly answer the question.
Bandwidth can be represented as Hz or bps, e.g., 10GHz bandwidth means 10Gbps.
High frequency communication can provide more bandwidth and shorter coverage than low frequency one. For example, 5GHz wi-fi can support up to 1300Mbps bandwidth while 2.4GHz, up to 540 Mbps.
Define "attenuation", "delay distortion" and "noise".
Digital signal is more susceptible to attenuation than analog signal, thus may need more repeaters in a given distance. In addition, digital signal is more susceptible to interference (crosstalk), delay distortion, impulse noise than analog signal.
Attenuation is proportional to "media length" and "frequency".
Repeater eliminates noise after amplifying power, while amplifier does not care noise.
In theory, higher frequency means (lower wavelength, higher BW/data rate, higher attenuation)
Guided media transmission's data rate is affected by characteristics of the media itself. Meanwhile, Performance of wireless media is mainly determined by the Bandwidth (BW) of signal.
Transmission capacity = Data rate (~1Mbps) < Signal bandwidth (1MHz)
    - Data rate depends on "distance" and "way of communication (p2p, mp)"
    - More receivers attached on the media -> more attenuation involved during transmission.
Overall data rate can be affected by attenuation, delay/attenuation distortion, (impulse) noise, interference (or crosstalk), distance, number of attached receivers to the shared medium as well as a signal bandwidth of the media itself through which the data goes.
Three wired media : Twisted Pair (TP), Coaxial cable (coax), Optical fiber
   - Frequency: TP < coax < Optical fiber (higher)
   - BW: TP < coax < Optical fiber (more)
   - Attenuation: TP > coax > Optical (lower)   
