# GitTutoral

## 설정

### 초기설정
```
git config --global user.name 'name'          // --global로 설정된 값은 처음 한 번만 설정
git config --global user.email 'gthub email'  // 매번 다른 이름과 메일주소를 사용할 것이라면 --global 안써도 됨
```

### 설정확인 / 삭제
```
git config --list     // 현재 git 설정을 출력
git config --unset user.name              // 설정된 user.name 삭제
git config --unset --global user.email    // --global로 설정된 user.email 삭제
```


## 저장소 생성
### 저장소 생성
```
// 먼저 저장소를 만들 위치로 이동
git init
git init --bare 저장소이름   // 수정없이 저장만 할 저장소 생성
```
### remote저장소 생성
```
git remote add origin '저장소주소'              // 해당 주소로 연결되는 origin이라는 이름의 remote저장소 생성
git remote                                     // 현재 프로젝트에 등록된 remote저장소 목록을 보여줌
git remote -v                                  // remote저장소 목록을 ULR과 함께 보여줌
git remote set-url 저장소이름 새로운저장소주소   // remote저장소의 url주소 
```

## status
### 현재 파일들의 상태 출력
```
git status
```
- Untracked file: add되기 전. git의 추적을 받지 않는 파일
- modified: 수정된 것
  + Changes to be commited: commit될 것
  + Changes not staged for commit: commit되지 않을 것

## log
```
git log                               // 현재까지 commit한 내용 출력
git log -p                            // 각 commit사이의 소스코드상의 변경사항을 함께 출력
git log diff commitID1..commitID2     // commitID1과 commitID2사이의 변경사항 출력
git log --branch                      // 모든 브랜치를 표현
git log --graph                       // 그래프로 표현 
git log -1                            // 최근 1개의 log만 표시
```

## diff
```
git diff    // modified 상태가 되며 수정된 요소가 무엇인지 출력
```

## add
### 파일을 add하기
```
git add 'File'
git add *        // 모든 파일을 add
git add -u       // modified & deleted 파일만 add
```
### add 취소하기
```
git reset           // 모든 파일의 add를 취소
git reset 'File'    // 해당 파일을 unstaged상태로 변경
git clean -fdx      // 모든 untracked파일 삭제
```

## rm
```
git rm 'File'           // 파일을 삭제 후 staged상태로 변경(work directory의 파일도 삭제)
git rm --cached 'File'  // 파일을 untracked상태로 변경(work directory의 파일은 그대로 유지)
```

## commit
[좋은 커밋 메세지 작성법](https://meetup.toast.com/posts/106)
### commit하기
```
git commit
git commit -a                    // modified & deleted 파일을 자동으로 add하고 commit
git commit -m 'commit message'   // 에디터를 거치지않고 바로 commit메세지 작성
```
### commit 취소 하기
```
git reset 버전아이디 --hard   // 작성한 commit아이디 상태로 돌아가고 그 이후의 버전은 버림
git reset --hard HEAD^       // 마지막 커밋 바로 이전으로 돌아가고 마지막 커밋은 버림
git reset HEAD^              // 마지막 커밋을 취소하고 내용은 남김채 unstaged 상태로 만들기
git reset --soft HEAD^       // 마지막 커밋을 취소하고 내용은 남김채 staged 상태로 만들기
git revert 버전아이디         // 버전아이디 커밋을 취소한 내용을 새로운 버전으로 만듦
* 반드시 push전에 할 것
```
### 마지막 commit 수정하기
```
git commit --amend      // 편집기에서 새로운 커밋메세지 작성 후 반영
                        // 파일 수정 후 add하여 실행할 시 해당 파일의 수정사항을 마지막 커밋에 추가
git commit --amend --no-edit    // 커밋 메세지 수정없이 커밋 내용 반영
git commit --amend -m '새로운 메세지'   // 바로 직전의 commit 메세지를 변경
git push -f // 수정 한 메세지 push하기
* 다른 사람과 협업중인 공간에 push한 후 commit 수정은 권장하지 않음(충돌 위험 매우 큼)
```

## checkout
### 브랜치 이동
```
git checkout HEAD~1             // 현재 위치에서 1단계 전 commit으로 돌아가기
git checkout 'name of branch'   // 해당 브랜치로 이동
```
### modified전 상태로 되돌리기
```
git checkout .            // (위치: repository_root_dir) 프로젝트 내 모든 파일을 modified되기 전 상태로 되돌리기
git checkout 'dir'        // 해당 폴대 내 모든 파일을 modified되기 전 상태로 되돌리기
git checkout -- 'file'    // 해당 파일이 modified되기 전 상태로 되돌리기
```

## push
### Github에 작업물 push
1. Github에 repository생성
2. 작업 후 commit
3. Github에 생성한 ropository주소로 remote저장소 생성
```
git remote add origin 'repository주소'
git remote      // 확인
```
4. 작업물 push
```
git push -u origin master     // local저장소의 브랜치와 원격저장소의 master브랜치 연결
                              // 다음부터 git push만 하면 됨
```

## pull
```
git pull    // update내용을 local로 가져오기
```

## stash
```
git stash         // 새로운 stash 생성
git stash save    // 새로운 stash 생성
git stash list    // stash 목록 확인하기
git stash apply                 // stash 적용하기
git stash apply --index         // Staged상태로 stash 적용하기
git stash apply 'stash name'    // stash 적용하기
git stash drop                  // 가장 최근의 stash 
git stash drop 'stash name'     // 해당 stash 제거
git stash show -p | git apply -R                // stash 되돌리기
git stash show -p 'stash name'| git apply -R    // 해당 stash 되돌리기
```

## branch
```
git branch      // 현재 브랜치목록을 보여줌
git branch -r   // 원격 저장소의 브랜치목록을 보여줌
git branch -a   // 로컬, 원격 저장소의 브랜치 목록을 보여줌
```
  
### branch 생성, 전환, 삭제
```
git branch nameOfBranch
git checkout master            // master브랜치로 이동
git branch -d nameOfBranch     // 현재 위치가 삭제할 브랜치여서는 안됨
git branch -D nameOfBranch     // 병합하지 않은 브랜치를 강제 삭제
git push origin --delete nameOfbranch   // 리모트 저장소의 브랜치 삭제
git checkout -b nameOfBranch   // 새로운 브랜치를 생성하고 생성 브랜치로 전환
git branch -m oldName newName  // local에서 브랜치 이름 변경
```
### cherry-pick
- 다른 branch에 있는 commit을 선별적으로 현재 branch에 반영
- 가져올 commit과 같은 commit을 만들어 현재 branch에 덧붙임
```
git cherry-pick commitID
```
### merge branch
- commit ID가 보존됨
```
git checkout branch1          // branch1으로 이동
git merge branch2             // branch2를 branch1(현재 위치한 브랜치)에 merge
git merge --no-ff branch2     // 3-Way Merge 수행
git merge --squash branch2    // branch2의 커밋을 하나로 합쳐서 merge
                              // 이후 Staging Area에 올라온 파일을 커밋해줘야 함
```
### rebase branch
- 여러개의 commit을 다룰 수 있음
- 새로운 commit이 생성되므로 commit ID가 변경됨
```
git rebase nameOfBranch   // 현재 branch와 대상 branch의 공통 조상부터 대상 branch의 최신 커밋까지
                          // 순서대로 하나씩 가져와 현재 branch에 붙임
                          
git rebase -i HEAD~3      // 현재 branch의 HEAD로 부터 3개의 commit을 편집
```
### branch 충돌 해결
1. CONFLICT 에러 발생
2. git status로 충돌이 일어난 파일 확인
3. 충돌이 일어난 파일 수정
```
<<<<<<< HEAD     // 현재 브랜치
내용1
=======
내용2
>>>>>>> branch   // merge하려던 브랜치
```
4. git add '충돌파일명'
  
### 원격 저장소의 branch 로컬로 가져오기
```
git branch -r                    // 원격저장소의 브랜치목록 보기
  > origin/branch1               // '저장소명'/'브랜치명'
git checkout -t origin/branch1   // 로컬에 'branch1'를 만들고 이동
git checkout -b 'new-branch-name' 'origin/branch1'    // 새로운 이름으로 브랜치 가져오기
```

## etc
```
pwd                // 현재 나의 위치
mkdir 폴더명        // 현재 위치에 새로운 폴더 생성
cp file1 file2     // file1과 같은 내용의 fil12를 생성(확장자 쓰기)
git                // 사용할 수 있는 명령어 표시
ls -al             // 현재 디렉토리의 파일 목록 출력
cat 파일명.확장자   // 선택한 파일의 내용을 출력
명령어 --help      // 해당 명령어에 대한 메뉴얼을 보여줌

---
## Fork한 repository 최신으로 동기화
1. 원본 repository를 remote저장소로 추가
```
git remote add upstream '원본 저장소 주소'
git remote -v      // 확인
```
2. upstream으로부터 최신 업데이트 가져오기
```
git fetch upstream
```
3. upstream의 master branch로부터 나의 local master branch로 merge
```
git checkout master          // local master branch로 이동
git merge upstream/master
```
4. push하여 origin remote repository에 적용
```
git push origin master
```
