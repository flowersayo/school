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
echo $(((5**2)*3)) //75
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
🔊{}와 {}가 붙어있으면 같은 덩어리로 분류되지만 떨어져있으면 각자 출력된다.

## 🔔매개변수확장(Parameter Expansion)

```
echo $USER : 유저의 이름 출력
printenv | head n -6 : 환경변수목록을 앞에서부터 6번째 줄까지 출력
```
🔍리눅스에서 환경변수를 설정하는 방법
http://daplus.net/linux-%EB%A6%AC%EB%88%85%EC%8A%A4%EC%97%90%EC%84%9C-%ED%99%98%EA%B2%BD-%EB%B3%80%EC%88%98-ld_library_path%EB%A5%BC-%EC%84%A4%EC%A0%95%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95/

##  ⭐명령어 치환(Command Substitution)

- 한 명령어의 output을 다른 문장(명령어)의 input으로 연결해준다.
- `|` (pipeline)과 반대효과.
- 
```
ls -l $(which cp) // cp명령어가 위치한 곳에서 ls -l 커맨드 실행
type $(ls /usr/bin/* | grep zip) //  1. /usr/bin폴더의 모든 파일의 목록이 grep명령어의 input으로 쓰인다. 2.grep결과가 type명령어의 input으로 쓰인다.
```

## 쌍따옴표(Double Quotes)
- `""`안에 들어간 어떤 내용이던 특별한 의미를 잃고 문자로서 취급된다.
- 단, `$`,`\`,``` 는 예외이다.

```
echo hello world             123 // hellow world 123
echo "hello world             123" // hellow world           123
echo $(cal)  //캘린더 출력 (나열)
echo "$(cal)" // 캘린더 출력 (가지런히 정렬된채로)

```
- 
|Operator|Description|
|------|---|
|+|addition|
|테스트1|테스트2|
|테스트1|테스트2|


ex) `cd /usr/bin/; ls; cd -`  : `/usr/bin/` 으로 이동해서 파일목록을 출력하고 다시 원래있던 디렉토리로 돌아와라.

- `alias` 를 이용하면 사용자가 정의한 커맨드를 만들 수 있다. 
- 단, 단순 alias로 정의한 command는 일회용이다. 터미널을 종료하면 다음번 실행시에 초기화된다.

기본 값으로 만들어두고 싶다면 환경설정에서 바꾸어야한다. 

```
alias 커맨드명='작업내용' : 작업내용을 시행하는 커맨드 만들기
ex ) alias getBin='cd /usr/bin/; ls; cd -'
unalias 커맨드명 : 커맨드해제
```

🗳📦🗃
🔱⚜☢〽♻🔰💠Ⓜ🆗▶➰✔💲💱🟠🟢🔵🟤🔴🟠🟨🔸🔹✨🔊
## ⭐Redirection 

- I/O : Standard Input, Output, Error 
- `I/O redirection` : 어디서 input을 받아들이고 어디로 output을 보낼 것인지 정할 수 있다.
- `>` 연산자는 데이터의 흐름을 말함. output을 -> 으로 보내겠다는 것.
- `>` 는 기본적으로 Output만을 이동시키며, Error는 똑같이 화면상에 출력됨. 
- Error까지 이동시키고자 할때에는 `2>` 활용.
- `/dev/null` 는 휴지통 비슷한 개념. 원하지 않는 ouput을 버리고 싶을때 활용.
- `cat` : 하나 이상의 Input(ex.파일, 사용자 입력)을 읽어 그대로 Standard Output에 복사한다. --> 종료는 `ctrl + d` or `ctrl + c`


```
[활용]
- `커맨드 > 파일` : 커맨드의 output을 파일에 저장한다. (overwrite)
- `커맨드 >> 파일` : 커맨드의 output을 덧붙여 저장한다. (ammend)
- `커맨드 < 파일` :  파일을 커맨드의 input으로 사용한다.
- `커맨드 > /dev/null` :  커맨드의 output을 버린다.
- `커맨드 2> 파일` : 에러메시지만 파일에 저장
- `
```

## 🗒grep 
: 파일에서 텍스트패턴을 찾을때 유용.

```
grep str 파일명 : 파일에서 str을 찾는다. str이 포함된 모든 구문을 OUTPUT으로 출력한다.
```


📍📌 🔍🔎📚
