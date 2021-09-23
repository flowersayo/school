# ➕LinuxCommand_extra
`부가적인 리눅스 커맨드 모음`

## 커맨드 관련
```
type  커맨드명 : 명령어의 타입 확인. 지정된 명령어가 쉘에 내장된 명령어(builtin)인지, 외부명령어인지, 앨리어스 명령어인지 등
which 커맨드명 : 특정명령어의 위치
help 커맨드명 : 명령어에 관련한 설명 (shell builtin func)
커맨드명 --help : 지원하는 syntax와 option 설명
man 커맨드명 : 명령어의 사용법
whatis 커맨드명 : 특정 명령어가 무슨역할을 하는지 간단하게 한줄로 설명 
info 커맨드명 : 명령어 정보
```
🔎man매뉴얼 사용법 정리 
https://withcoding.com/90

## 🌟사용자 설정 command 만들기 

- `;` 으로 하나의 커맨드라인에서 여러개의 명령어를 순차적으로 실행하도록 할 수 있다.

ex) `cd /usr/bin/; ls; cd -`  : `/usr/bin/` 으로 이동해서 파일목록을 출력하고 다시 원래있던 디렉토리로 돌아와라.

- `alias` 를 이용하면 사용자가 정의한 커맨드를 만들 수 있다. 
- 단, 단순 alias로 정의한 command는 일회용이다. 터미널을 종료하면 다음번 실행시에 초기화된다.

기본 값으로 만들어두고 싶다면 환경설정에서 바꾸어야한다. 

```
alias 커맨드명='작업내용' : 작업내용을 시행하는 커맨드 만들기
ex ) alias getBin='cd /usr/bin/; ls; cd -'
unalias 커맨드명 : 커맨드해제
```

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


## ✨PipeLine

` $command1 | command2 `

:한 커맨드의 Standard Output을 다음 커맨드의 Standard Input 으로 활용하고자 할때 유용.

[활용]
`ls -l /usr/bin/ | grep zip`  : ls의 결과를 grep의 input으로 사용.

❔`>` 와 `|` 의 차이❔
: `>` 는 output을 보내는 경로를 지정하는것이고,`|` 은  이전 output이 이번 input으로 쓰일수 있게끔 연결하는것!

`$command1 > file1` ⭕ 

`$command1 | command1` ⭕

`$command1 > command2` ❌  : 만일 command 2가 input을 필요로 하지 않는 명령어라면?


## 📡기타 여러가지 커맨드

```
wc(word count) 파일명  : 특정 파일의 줄수, 글자수, byte크기
head -n N 파일명 : 파일앞에서 N번째 줄까지만 출력.
tail -n N 파일명 : 파일뒤에서 N번째 줄까지만 출력.

```


