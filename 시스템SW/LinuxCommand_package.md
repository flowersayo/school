# LinuxCommand_package



#debian 
- Low : dpkg
- High : apt, apt-get


```
apt -get uadate; apt-get upgrade        //패키지 목록 업데이트
apt -cache search 패키지명 // 해당 패키지가 존재하는지 설치 가능한 리스트 목록 출력.
apt -get install 패키지명   // 패키지 설치 -high
dpkg -i 패키지명            // 패키지 설치 -low
apt -get remove 패키지명    // 패키지 삭제
dpkg -l                     // 설치된 패키지 목록
dpkg -s 패키지명             // 특정 패키지가 설치되어잇는지 확인
apt -cache show 패키지명       // 설치된 패키지에 대한 정보 출력 ->버전 정보 확인시에 유용
wget 링크                    // HTTP이용해 소스코드 다운로드
tar xvf tar파일명            // 압축해제
./configure --prefix =/home/ubuntu/         //설치경로 설정
make                       // 소스코드 컴파일
make install                       // exe파일 설치










```
