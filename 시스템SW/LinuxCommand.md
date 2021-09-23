# LinuxCommand

 참고링크 : https://coding-factory.tistory.com/501
 
 
### 기본

```
pwd                   // display current working directory 
ls                    // list files and directories in current working directory 
ls -l                 //  파일 자세히 보기 (long format)
ls -lh                // " in more recognizable form 
cd 경로명 (상대,절대) // change working directory
ls 경로명             // list files and directories in 경로명
file 파일명          // file 타입 및 여러 정보를 알려줌
less 파일명          // 읽을 수 있는 텍스트를 보여줌 (읽기전용) -> q를 통해 읽기종료
mkdir 디렉토리명     // 폴더만들기
cp 파일1 파일2       // 파일복사
mv 파일1 파일2      // 파일 옮기기 or 파일 재이름짓기
rm 아이템          // file이나 directory를 지움
```   

#### Link 

- `ln 파일명 링크명` : hard link 생성
- `ln -s 파일명 링크명` : Symblic link 생성 
; 하드 링크의 한계를 극복. 바로가기를 생성하는 것. 바로가기로 연결된 원본파일이 지워질경우 broken.



#### Long format 
![KakaoTalk_20210924_014605485](https://user-images.githubusercontent.com/86418674/134549691-e9086736-2cce-4e4a-a24f-fda7da1621cf.jpg)

같은 디렉토리에 있을경우 파일1을 파일2로 재이름짓기. 다른 디렉토리에 있다면파일 옮기

./ 기준은 상대
/home 부터는 절대
