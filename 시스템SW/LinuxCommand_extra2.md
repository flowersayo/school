# ➕LinuxCommand_extra2
`부가적인 리눅스 커맨드 모음2`

## 📢확장(Expansion)
: 우리가 커맨드를 입력하고 엔터키를 누를때마다, bash가 우리의 명령어를 실행하기 이전에 텍스트에서 몇가지 대체를 수행하는것.


## 경로명 확장 (Pathname Expansion)
### 💲echo 
\# ehco 아니다😓 \#따라쟁이
- shell builtin 커맨드
- standard output 형태로 텍스트를 출력해준다. 


```
echo * : 현재 경로에있는 모든 파일들을 출력한다. (Pathname expansion)
echo 문자(열)* : 문자(열)로 시작하는 디렉토리만 출력한다. 
echo *문자(열) : 문자(열)로 끝나는 디렉토리만 출력한다.
echo ~ : 사용자의 홈 디렉토리를 출력한다. ex ) /c/Users/flowe (Tilde expansion)
```

🔍더 자세한 ehco 사용법
https://jjeongil.tistory.com/997

## 💠산술확장 (Arithmatic Expansion) 

- shell은 수학공식이 expansion에 의해 수행될 수 있도록 한다.
- shell prompt를 계산기로서 이용가능하게 해준다.
- 기본 형태 : `$((expression))` 

```
echo $((2+2)) //4
echo $(((5**2)*3)) //5<sup>2</sup> *3 = 75
echo $((5/2)) //2 -> support only integer arithmetic
```

## {} 괄호확장 (Brace Expansion)

- 특정 패턴하에 반복적으로 string을 생성할 수 있다.

```
echo {Z..A} // Z Y X W ..... C B A
echo {A..C} {A,B,D,E} // A B C A B D E
echo {A..C}-{A,B,D,E} // A-A A-B A-D A-E B-A B-B B-D .... C-E
mkdir test- {1..3} // test1,test2,test3 디렉토리 생성
```
🔊 {}와 {}가 붙어있으면 같은 덩어리로 분류되지만 떨어져있으면 각자 출력된다.

## 🔔매개변수확장(Parameter Expansion)

```
echo $USER // 유저의 이름 출력
printenv | head n -6 // 환경변수목록을 앞에서부터 6번째 줄까지 출력
```
🔍리눅스에서 환경변수를 설정하는 방법
http://daplus.net/linux-%EB%A6%AC%EB%88%85%EC%8A%A4%EC%97%90%EC%84%9C-%ED%99%98%EA%B2%BD-%EB%B3%80%EC%88%98-ld_library_path%EB%A5%BC-%EC%84%A4%EC%A0%95%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95/

##  ⭐명령어 치환(Command Substitution)

- 한 명령어의 output을 다른 문장(명령어)의 input으로 사용할 수 있도록 해준다.
- `|` (pipeline)의 반대효과.

```
ls -l $(which cp) // cp명령어가 위치한 곳에서 ls -l 커맨드 실행
type $(ls /usr/bin/* | grep zip) //  1. /usr/bin폴더의 모든 파일의 목록이 grep명령어의 input으로 쓰인다. 2.grep결과가 type명령어의 input으로 쓰인다.
```

## 💬따옴표
- 쌍따옴표(Double Quotes): `" "`안에 들어간 내용은 문자로서 취급된다. 단, `$`,`\`,``` 는 예외이다.
- 홑따옴표(Single Quotes): `' '`안에 들어간 모든 확장(expansion)을 억제한다.  어떤 내용이던 특별한 의미를 잃고 문자로서 취급된다.
- Escaping Characters :'\'를 통해 선택적으로  expansion을 억제할 수 있다. ex) `$`,`\`,``` 와 같은 기호를 출력하고 싶다면 `\` 다음에 써준다. 
```
echo hello world             123                        // hellow world 123
echo "hello world             123"                   // hellow world           123
echo $(cal)                                          //캘린더 출력 (나열)
echo "$(cal)"                                         // 캘린더 출력 (가지런히 정렬된채로)
echo text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER    // text /home/ubuntu/*.txt a b foo 4 ubuntu
echo "text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER"  // text~*.txt {a,b} foo  4 ubuntu
echo 'text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER' // text~*.txt {a,b} $(echo foo) $((2+2)) $USER 
echo "the price is \$5.00 "                           // the price is $5.00 
```


## 🖱️커서이동 

![KakaoTalk_20211029_164645061](https://user-images.githubusercontent.com/86418674/139396742-eab57761-0a0b-4eb9-8694-22cf357dce79.jpg)



## 📑 내용 수정

![KakaoTalk_20211029_165242438](https://user-images.githubusercontent.com/86418674/139397021-7115d658-1b7f-4ed3-bd8c-71d88d84e3b2.jpg)

## 🆗자동완성
:문자열을 입력후 `<Tab>`키를 누르면 그 문자열로 시작하는 파일이나 디렉토리의 나머지 글자가 자동 완성된다. 
  단 , 첫 문자가 같은 디렉토리나 파일이 여러개인 경우 `<Tab>` 키 한번만 누르면 아무 변화도 없지만 `<Tab>` 키 두번 연속으로 누르면 동일하게 시작하는 모든 디렉토리나 파일을 출력해 준다. 또한 명령어타이핑 도중에 `<Tab>`키를 눌러 명령어를 자동완성시킬수도 있다.

## 🛬히스토리 (History) 
- `$history` 를 통하여 내가 과거에 작성했던 커맨드 목록을 시간 순서대로 볼 수 있다.
- .bash_history 폴더에 히스토리내역이 저장되어있다.
- 커맨드에는 특정 번호가 붙는데 `!number` 와 같이 명령함으로서 그 번호가 붙어있는 명령어를 그대로 실행시킬 수 있다.
- History Expansion
  
![KakaoTalk_20211029_173513829](https://user-images.githubusercontent.com/86418674/139403589-a5ab7bad-ad7d-4cc5-a33a-0633ce100414.jpg)


## 🔰접근권한 (Permission)
- 어떤파일이든 user, group, other 에 대해 각각 권한을 주게 된다.
- drwxr-xrw- 는 네구간으로 분할할 수 있다. d rwx r-x rw-
- 맨 첫글자(d)는 파일의 유형을 의미한다.
![KakaoTalk_20211029_175155898](https://user-images.githubusercontent.com/86418674/139406155-f135250c-5463-4b22-b975-e852bc2de73d.jpg)

- 그 다음 첫 'rwx'는 파일의 소유자(user)에 대한 접근 권한
- 중간 'r-x'는 소유 group에 대한 접근 권한
- 마지막 'rw-'는 모든사람(world)에 대한 접근권한

- 속성 (r,w,x)
각각 read,write,execution 권한을 의미한다. 대상이 파일인지 디렉토리인지에 따라 실질적인 의미가 다르다.

|attribute|file|directory|
|---|---|---|
|r|open and read|allow directory's contents to be listed|
|w|write and truncate|allow files within a directory to be created, deleted and renamed|
|x|symbolic link|allow a directory to be entered ex)cd directory|

-> directory에서의 r,w는 x가 선행되어야한다.

### 🔸접근 권한 부여하기
 `chmod (abc)<sub>8</sub> 파일명`
:오직 파일의 소유자나 root만이 해당 파일or디렉토리의 접근권한을 변경할 수 있다. 

- 8진수로 접근권한 표현하기

![KakaoTalk_20211029_180821200](https://user-images.githubusercontent.com/86418674/139409061-4e52720b-5768-4595-a41f-a99e1e83a595.jpg)

### 🔸파일 소유자와 그룹 바꾸기
`chown 소유자:그룹명 파일명` 
: root권한을 필요로한다.

ex) `chown root:root f1.txt`


☑️`tip` `id` 커맨드를 통해 자신의 접근권한(identity)를 확인할 수 있다.

## Execute a Command as Another User
- `sudo [옵션] [사용자명]` : 일반유저가 일시적으로 다른 유저로서 명령어를 실행할 수 있도록 하는 명령어 (-u 옵션으로 인자를 설정하지 않으면 default 사용자는 root)
- `su [옵션] [사용자명]` : 계정전환

🤞 `su` 와  `sudo`의 차이?
:sudo는 root의 권한을 잠시 빌려서 명령어를 수행하는 것인반면, su는 유저를 직접 switch 한다는 차이점이 있다.

```
sudo -u flowe cat def1.c          // 유저 flowe의 권한을 잠시 빌려 cat명령어를 실행한다.
su - flowe                        // flowe 로 계정전환 
su                                //root로 계정전환
sudo apt update                  //apt update라는 명령어를 root로서 (즉, root의 권한으로) 실행
sudo chown ubuntu:ubuntu f1.txt // f1.txt파일의 owner를 ubuntu,group을 ubuntu로 변경.
```


🗳📦🗃🔱⚜☢〽♻🔰💠Ⓜ▶➰✔💲💱🟠🟢🔵🟤🔴🟠🟨🔸🔹✨🔊📍📌 🔍🔎📚
