# ➕LinuxCommand_extra4
`부가적인 리눅스 커맨드 모음 4`

## 📢프로세스 (process)
: 컴퓨터에서 연속적으로 실행되고 있는 컴퓨터 프로그램. 


- parent process :  one that creates a child process.
- process ID : 각각의 프로세스가 부여받게되는 숫자


### ♒Linux kernal 
: Linux 운영 체제(OS)의 주요 구성 요소이며 컴퓨터 하드웨어와 프로세스를 잇는 핵심 인터페이스.
프로그램이 시작하면 kernal이 몇몇 작업을 프로세스로서 초기화하고 init이라는 프로그램을 런치한다. 
init은 init scripts라고 불리는 연속된 shell script를 실행시킴으로써 모든 시스템 서비스를 시작시킨다.

[역할]

메모리 관리: 메모리가 어디에서 무엇을 저장하는 데 얼마나 사용되는지를 추적

프로세스 관리: 어느 프로세스가 중앙 처리 장치(CPU)를 언제 얼마나 오랫동안 사용할지를 결정

장치 드라이버: 하드웨어와 프로세스 사이에서 중재자/인터프리터의 역할을 수행

시스템 호출 및 보안: 프로세스의 서비스 요청을 수신

## 🔱 Viewing Processes

### `$ps [옵션]` (process status)
: 본인 터미널 기준으로 프로세스를 출력.

![20211030172347](https://user-images.githubusercontent.com/86418674/139525856-3b6fbf81-11fc-48f4-856e-b45f3c19ddf4.png)

- PID : 프로세스의 식별 번호
- TTY : 프로세스와 연결된 터미널
- TIME : 총 CPU 사용시간


### `ps aux` 
: 시스템에 동작중인 모든 프로세스를 소유자 정보와 함께 출력

![20211030173914](https://user-images.githubusercontent.com/86418674/139526272-98e950c1-e128-417d-b27b-65c899044f08.png)

- USER : User ID ex)root
- %CPU : CPU 사용량
- %MEM : 메모리 사용량
- VSZ : 가상 메모리 사용량
- RSS : (=Resident Set Size) 프로세스가 사용하고 있는 실제 메모리(RAM)의 크기
- START : 프로세스를 시작한 시간. 24시간을 넘어가면 날짜까지 출력된다.

### `top`
: ps 명령어는 명령어가 실행된 그 순간에 실행되고 있는 프로세스를 정적으로 보여준다면, top을 통해 실시간으로 변화하는 프로세스를 볼 수 있다.

- htop : 기존 top보다 업그레이드 된 실시간 비쥬얼 모니터링 툴. 따로 패키지 설치를 요함.


## 프로세스 관리

### 📍interrupting a Process
 - `ctrl + c` : 특정 프로세스 강제종료
 - `ctrl + z` : foreground 프로세스를 일시정지하고 background로 보낸다.
 - 
```
while true; do sleep 1; done // do sleep을 무한반복해라
^C   //프로세스 종료
```

### ☢Putting a Process in the Background
:리눅스의 모든 프로세스는 전면부라고 하는 포그라운드(foreground) 작업, 후면부라고 하는 백그라운드(background) 작업 중 하나의 상태로 실행된다. 
우리가 일반적으로 실행시키는 거의 모든 명령어는 포그라운드로 실행되지만, 명령어 뒤에 `&` 문자를 붙이게 될경우 백그라운드로 실행된다.


```
alias forever='while true; do sleep 1; done' //foever라는 사용자 설정 명령어 만들기
forever & //background에서 실행 
```
### Returning a Process to the Foreground and stopping a Process
```
jobs     // 로그인후 사용자가 실행한 프로세스에 대해서 확인
bg %PID  // PID에 해당하는 프로세스를 백그라운드모드로 전환하기
bg %PID  // PID에 해당하는 프로세스를 포그라운드모드로 전환하기
```

## 💌Sending Signal
### `$kill [-signal] %PID`
: 프로세스에 시그널(signal)을 보내는 명령어. 어떤 시그널을 보낼 지 지정하지 않으면 default값으로 TERM 시그널을 보내게 되어 프로그램을 종료하는 기본 동작을 수행한다.

![KakaoTalk_20211030_183033222](https://user-images.githubusercontent.com/86418674/139527833-9eb5c323-d6ee-43eb-9b0b-de4053151991.jpg)

[signal 종류]

|Number|Name|Meaning|
|---|---|---|
|2|INT|실행중지. Ctrl+c 입력시에 보내지는 시그널|
|9|KILL|프로세스 강제종료|
|15|TERM|terminate. 프로세스 정상종료.|
|18|CONT|continue. 중단된 프로세스를 복원한다.|
|19|STOP|프로세스 중단|

🔎 더 자세한 시그널 목록 
: https://jhnyang.tistory.com/143


### `killall [-u user][signal] 이름 `
: 특정이름을 가진 프로세스들을 한꺼번에 죽이는 명령어

```
kill -KILL %PID or kill -9 %PID  // 프로세스 강제종료
killall -u ubuntu // ubuntu 유저가 생성한 모든 프로세스를 죽인다.
```

## 💥Shut down the system

```
sudo reboot // reboot system
sudo shutdown -h [now/시간]  // 지금 or 특정 시간후에 종료시킨다.
sudo shutdown -h [now/시간] // reboot system
```

## Environment
: * shell은 sesstion의 정보를 environment를 통해 유지한다.
* shell : 윈도우의 터미널처럼 명령어를 입력하는 환경을 의미. 커널(kernal)과 사용자간 다리역할.bash는 리눅스의 표준 shell

- `환경변수 (environment variable)`
- `셸변수 (Shell variable)` : bash에 의해 만들어진 데이터
이와 더불어 몇몇 정보는 `aliases` 와 `shell function` 에도 저장된다. 

### How is the environment Established
: 로그인시, bash프로그램은 `startup files` 라고 불리는 몇몇 설정 스크립트를 읽는다.
보통 shell세션은 두가지 방법으로 시작되는데
1. login shell session : prompt에 username,password를 입력하고 로그인하는 방식. 보통 virtual console session(ssh)에서 이렇게 시작된다. (대부분의 서버)

2. non login shell session : gui에서 터미널 세션을 열때.

### `.bashrc File`
: bash에서 작업할때마다 수행되는 파일. 
- 숨겨져있으므로 ls를 사용해서 볼때는  `-a` 옵션 필요

🔎 더 자세한 bashrc개념 : https://dohk.tistory.com/191
 ```
 printenv | less //
 
 ```
 
 ### 💫변수
 
- HOME : 사용자의 홈 디렉토리
- LANG : character set 과 언어 설정
- OLDPWD : 이전에 작업한 디렉토리
- PATH : shell 은 명령어를 입력받고 실행파일(exe)을 찾는 위치
- PWD : 현재 작업중인 디렉토리
- USER : 유저명

## 🖋vi
: 가볍고 빠른 text editor 

- `:q` : 나가기
- `:q!` : 저장하지 않고 강제종료
- `:wq` : 저장하고 종료
- `i` : insert모드 진입
- `ESC` : command모드 진입
- `:w` :
```
vi 파일명  //파일에 들어간다. 만일 존재하지 않는 다면 파일을 생성하여 들어간다.

### 🖱Moving Cursor

![KakaoTalk_20211031_001916402](https://user-images.githubusercontent.com/86418674/139539372-2a56bb39-76c0-4c11-953c-be2a0c1d0a8a.jpg)

```
### Basic Editing

![KakaoTalk_20211031_002619077](https://user-images.githubusercontent.com/86418674/139539422-cc57aed8-0443-4979-a785-b77de6dea1e2.jpg)

### Cutting, Copying, and Pastring Text 
- `:p` : 커서 이후에 붙여넣기
- `:P` : 커서 이전에 붙여넣기
- `:J` : 라인을 하나로 합친다.
![KakaoTalk_20211031_002913387](https://user-images.githubusercontent.com/86418674/139539679-727a293a-1ee0-4b1b-9b37-3b50203a6720.jpg)

### Searching the Entire File
- `:f문자` : line에서 문자를 찾아서 커서를 이동시킨다.
- `/단어` : 현재 커서로부터 뒤에서 단어가 처음 나타나는곳으로 커서를 옮김
- `?단어` : 현재 커서로부터 앞에서 단어가 처음 나타나는곳으로 커서를 옮김
- `n` : `/단어`, `?단어` 와 세트로 쓰이며 해당되는 단어가 여러개일경우 다음 단어로 커서를 움직임.
- 

### Global Search and Replace 


- `:` : ex command 시작
- `%` : 첫줄 ~마지막줄
- `s` : substitution 임을 명시한다. 
- `/pattern/replace/` : 서치패턴과 대체할 문구
- `g` : global. searchand replace가 모든 라인에서 이루어진다. g를 빠뜨릴경우 search string의 첫번째 instance만 대체가 수행된다.

[ex command]
```
:%s/SearchPattern/ReplacemnetText/g   // Pattern을 특정 text로 대체하여 준다.
:%s/SearchPattern/ReplacemnetText/gc  // Pattern을 특정 text로 대체할것인지 하나씩 확인한다.

![KakaoTalk_20211031_010136224](https://user-images.githubusercontent.com/86418674/139540544-95becfe3-a5c1-4e4d-b9dd-450bc081b667.jpg)


```


🗳📦🗃🔱⚜☢〽♻🔰💠Ⓜ▶➰✔💲💱🟠🟢🔵🟤🔴🟠🟨🔸🔹✨🔊📍📌 🔍🔎📚
