# 🔊LinuxCommand

 참고링크 : https://coding-factory.tistory.com/501
 
## 기본 명명 규칙
- 디렉토리명 : `dir` , `dir/` `/dir` 은 불가능!
- 파일명 : 파일명.확장자

## 기본

```
pwd                   // 현재 작업중인 디렉토리 출력.
mkdir 디렉토리명     // 폴더만들기
file 파일명.확장자   // 파일에 관한정보제공  (ASCII 인지 UNICODE인지 등)
less 파일명          // 읽을 수 있는 텍스트를 보여줌 (읽기전용) -> q를 통해 읽기종료
``` 

## mkdir
:디렉토리 생성
```
mkdir -p dir1/dir2       // 하위디렉토리(dir1)로 이동한 곳에 dir2라는 이름의 폴더 생성
rmdir                     // 비어있는 디렉토리 삭제
rmdir dir1/               // 디렉토리 dir1을 삭제
rmdir dir1/ dir2/ ...        // 여러개의 디렉토리(dir1,dir2...) 삭제
rmdir -p dir1/dir2          // 상위디렉토리(dir1)도 함께 삭제
```


## ls 
:디렉토리, 파일 목록

```
ls                  //  list files and directories in current working directory 
ls -l                 //  파일 자세히 보기 (in long format)
ls -al                //  숨겨진파일까지 자세히 보기 
ls -lh                //  K,M,G 단위를 사용하여 사람이 보기좋게 표시
ls -a                // 숨겨진 파일이나 디렉토리까지 보여준다.
ls -S                // 파일크기순으로 정렬하여 출력
ls -r                // 파일목록을 거꾸로 출력 (기본은 알파벳 순서)
ls -al 경로명         // 경로명에 있는 파일목록 출력 
ls -al h* .o          // 'h'로 시작하고 'o'로 끝나는 디렉토리 목록 출력 
ls > 파일명.확장자      // 디렉토리 내용을 파일에 저장
````

✨다양한 조합으로 ls 사용하기

ls -alSrh ->  a(숨겨진파일까지 포함), S(파일크기순), r(알파벳역순), h(보기좋게) 출력.

#### 🔎Long format ?
:퍼미션(권한),포함된 파일수, 소유자, 그룹, 파일크기, 수정일자, 파일이름 등 ..
![KakaoTalk_20210924_014605485](https://user-images.githubusercontent.com/86418674/134549691-e9086736-2cce-4e4a-a24f-fda7da1621cf.jpg)

## cp 
> cp [파일1 or 디렉토리1] [파일2 or 디렉토리2]
:파일 복사 및 덮어쓰기. 인자값을 어떻게 주느냐에 따라 사용법이 다르다. 파일을 디렉토리로 복사할수도 있고 디렉토리끼리 복사할수도 있고 파일끼리 덮어쓸수도 있다.

```
cp file1 file2                //file1을 복사하여 file2 파일을 새로 생성한다.
cp file1 dir1/                //file1을 디렉토리(dir1) 안에 복사한다.  
cp file1 file2 dir1/          //한번에 여러개의 파일을 디렉토리에 복사
cp -r dir1/ dir_new/         //디렉토리 전체를 복사 (dir1을 dir_new/라는 이름으로 recursive하게)

```

🔱Tip \[`tree` 명령어를 사용하면 디렉토리 구조를 트리형식으로 확인할 수 있다.\]


## mv (move)
> mv [파일1 or 디렉토리1] [파일2 or 디렉토리2]
: 디렉토리(파일)이동, 디렉토리(파일)명 변경

```
mv file1 file2              // file1을 file2 파일로 이름변경
mv file1 dir1/              // file1을 dir1로 이동
mv file1 file2 ... dir1/    // 여러개의 파일(file1,file2..)을 dir1으로 한번에 이동
mv dir1/ dir2/              // dir1을 dir2로 이름변경
```

## rm (remove)
> 파일, 디렉토리 삭제

```
rm 파일명.확장자          // 파일삭제
rm *.확장자               // 확장자로 끝나는 파일을 모두 삭제
rm *                     // 모든 파일을 삭제
rm -r dir1/              // dir1 디렉토리를 삭제 
rm -rf dir1/             // 경고없이 강제로 dir1을 삭제한다. -> 위험한 명령어이니 조심해서 사용
rm -ri dir1/             // 디렉토리에 있는 내용을 하나하나 확인하면서 삭제
```

📌rm -ri
: 파일, 폴더 하나하나씩 삭제할건지 여부를 물어봄.

[예시]
```
rm: descend into directory 'new/'? y

rm: remove regular empty file 'new/hello.txt'? y

rm: remove regular file 'new/pra2.txt'? y

rm: remove directory 'new/'? y
```
📌rmdir VS rm -r 

: rmdir로 비어있지 않은 폴더를 삭제하게 된다면 다음과 같은 실패메시지가 뜬다.

🚫rmdir: failed to remove 'new': Directory not empty🚫

즉, `rmdir`은 비어있는 디렉토리만 삭제할 수 있는 반면, `rm -r`은 파일이 들어있는 디렉토리도 삭제한다.



## cd 
:디렉토리 이동.  절대경로와 상대경로를 지정할 수 있다.
- 절대경로 : home에서 부터 시작한 경로
 
ex) `/c/Users/flowe`
- 상대경로 : 현재 경로에서 이동하고자 하는 곳 

ex) working directory가`/c/Users/flowe` 인데 `cd linux`라는 명령을 주면 `/c/Users/flowe/linux` 로 이동.

```
cd 경로                     //경로 로 이동
cd | cd$HOME |  cd ~        // home directory로 이동. ex) /c/Users/flowe
cd -                        // 바로 이전에 작업하던 directory로 이동
cd ~유저이름               // 입력한 유저의 home directory로 이동 
cd ..                      // 한 단계 상위 디렉토리로
cd /                      // 최상위 디렉토리로  (home 디렉토리 넘어서 위로)
cd .                      // 현재 디렉토리 
```


## touch 
:파일생성 

```
touch 파일명.확장자       // 파일생성
```

## Link 
: 링크생성 (바로가기)
- Symbolic (Soft) Link : 하나의 파일을 여러이름으로 가리키게 하는것. 원본파일 포인터를 가리키고 있어 원본파일을 연결하는 효과를 지닌다.
소프트링크는 원본파일이 삭제되면 broken 되어 제 구실을 못한다.
- Hard Link : 동일한 파일을 디스크의 다른곳에 배치(복사)한다. 하드링크는 원본파일이 삭제되어도 데이터 손실이 일어나지 않는다.


🔎 심볼릭 , 하드링크 https://jhnyang.tistory.com/269

- `ln 파일명 링크명` : hard link 생성
- `ln -s 파일명 링크명` : Symblic link 생성 
; 하드 링크의 한계를 극복. 바로가기를 생성하는 것. 바로가기로 연결된 원본파일이 지워질경우 broken.


📍📌 🔍🔎📚
## vi
:파일 수정
`vi 파일명.확장자` : i를 누르면 insert모드로 진입. 
파일 수정후에는 ESC를 눌러 command라인으로 이동 -> :wq를 입력하여 저장(w)하고 나갈수있음(q)


## cat,less
: 파일 읽기

```
cat 파일명.확장자  //파일보기 

```

⛔⛔⛔⛔⛔ 여기서 부턴 조금 minor한 것들 ⛔⛔⛔⛔⛔

