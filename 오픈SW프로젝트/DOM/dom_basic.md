# DOM

### Finding HTML Elements
: 모든 요소들은 " "안에 적기.
- `document.getElementById(id)` : 단 하나의 요소만 반환
- `document.getElementByTagName(tag)` : 이때 tag는 h1,div,p와 같은 실제 태그들. 배열요소를 반환하므로 인덱스를 사용하여 접근해야함
- `document.getElementsByClassName(class)` : 배열요소를 반환하므로 인덱스를 사용하여 접근해야함
- `document.querySelectorAll(selector)` : selector에는 기본태그명, .클래스명, #아이디명 or 기본태그명.클래스명 과같이 응용가능
-
📗꿀팁
- Date(): 현재시간을 string으로 반환
- 
### Adding and Deleting Elements


- `document.createElement(element)` : HTML element를 만든다.
- `Node.removeChild(element)` : HTML element를 삭제한다. 
- `Node.appendChild` : HTML element를 추가한다. 선택한 요소 안에 자식 요소를 추가
- `Node.replaceChild (new,old)` : HTML element를 대체한다
- `document.write(text)` : HTML output stream 으로 text를 작성한다.

🔹특정 태그 삭제하기
```
//To remove a specified element without having to specify its parent node.
let node = document.getElementById("newid"); 
            if (node.parentNode) { 
                node.parentNode.removeChild(node); 
                    }

```

🔹동적으로 버튼생성하여 body에 추가하기.
```
 var btn=document.createElement("button"); //버튼 요소 생성
       btnText=document.createTextNode("click"); //click이라는 텍스트생성
       btn.appendChild(btnText); //만든 텍스트를 버튼에 부가.
       document.body.appendChild(btn);// 버튼을 body의 자식요소로 넣는다.
```

📂자주하는실수
-함수이름이 키워드면x

## EventListener

1. html 태그에 직접적으로 onclick속성을 추가하는방법(inline)
```
<button type="button" id="btn" onclick="alert_click ()">button</button> //함수 구현과 호출 분리

<script>function alert_click (){ 
   alert("click"); 
}</script>
```
-> 하나의 이벤트(onclick)에 대해 여러개의 이벤트를 추가할수 X

2. event를 추가하고자 하는 html 태그를 가져와 attribute를 추가하는방법
```
//함수 구현+ 호출 동시에
<button type="button" id="btn">button</button>

<script>document.getElementById("btn").onclick=function alert_click (){
   alert("click"); 
}
```
```
//함수 구현+ 호출 따로
 document.getElementById("btn").onclick=alert_click; // 이때는 " "과 ()를 붙이지 않음.
    
    function alert_click (){
       alert("click"); 
    }
```
-> 만일 함수의 파라미터가 있다면 element.addEventListener( 'change',  function(){함수명(인자)} ); 과 같이
함수를 호출함으로서 그 안에있는 함수를 호출해주는 방식을 취해야한다.


3. ✨EventListener활용✨
`element.addEventListener(type,listener[,useCapture]);`
- type : "이벤트타입" ex) blur,drag,drop
- listener\[ : 이벤트를 수신하여 처리할 객체. 주로 단순한 자바스크립트 함수
- useCapture] : true를 주면 capturing 방식으로 이벤트가 전달되고, false이면 bubling방식으로 이벤트가 전달된다.
기본값은 false이다.
✨Capturing 과 Bubbling 
▶Capturing : 이벤트가 발생한 target element의 최상위부모 -> target까지 순차적으로 내려오면서 이벤트 전달(TopDown)
▶Bubbling : 이벤트가 발생한 target element부터 최상위 부모까지 순차적으로 올라가면서 이벤트가 전달되는 방식(BottomUp)
[🔍Capturing 과 Bubbling ](https://dimdim.tistory.com/entry/javascript%EC%97%90%EC%84%9C-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC%EB%A5%BC-%EC%9C%84%ED%95%9C-addEventListener-%ED%95%A8%EC%88%98-%EC%84%A4%EB%AA%85)




```
//함수 구현+ 호출 동시에
document.getElementById("btn").addEventListener("click",function alert_click (){
        alert("click");}); 
```
```
  //함수 구현+ 호출 따로
    document.getElementById("btn").addEventListener("click",alert_click); //함수명으로 함수호출 
    
    function alert_click (){
       alert("click"); 
    }
```
[ 이벤트타입목록1](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=qbxlvnf11&logNo=220877806711)
[ 이벤트타입목록2](https://jenny-daru.tistory.com/17)

# Document Object
🔹
- `document.
- `document.
- `document.
- `document.
- `document.
- `document.



