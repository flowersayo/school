# DOM

### Finding HTML Elements
: 모든 요소들은 " "안에 적기.
- `document.getElementById(id)` : 단 하나의 요소만 반환
- `document.getElementsTagName(tag)` : 이때 tag는 h1,div,p와 같은 실제 태그들. 배열요소를 반환하므로 인덱스를 사용하여 접근해야함
- `document.getElementsByClassName(class)` : 배열요소를 반환하므로 인덱스를 사용하여 접근해야함
- `document.querySelectorAll(selector)` : selector에는 기본태그명, .클래스명, #아이디명 or 기본태그명.클래스명 과같이 응용가능. 마찬가지로 인덱스를 사용하여 접근.
ex) `document.querySelectorAll("p.intro")` : p태그이면서 클래스 intro를 가지는 모든 element 반환.



### Changing HTML Elements

- `element.속성=값` : 태그 기본 속성 바꾸기. 속성에는 innerHTML,value,id,class,onclick 등 다양한 값이 들어갈 수 있음.
- `element.style.property=값` : css바꾸기. 이때 property는 backgroundColor와 같이 - 대신 대문자 시작을 활용한다.
- `element.setAttribute(속성,값)` : 속성을 값으로 setting한다.
ex) `element.setAttribute("style", "background-color: red;");` // 속성과 값의 구분은 =기준.
-  `element.attributes` : element요소에 저장된 모든 속성값. 인덱스를 통해 접근한다.


### Adding and Deleting Elements


- `document.createElement(element)` : HTML element를 만든다.

- `Node.removeChild(element)` : Node에서 element라는 자식노드를 삭제한다.
- `Node.appendChild(element)` :  Node의 자식 요소를 추가한다.
- `Node.replaceChild (new,old)` : Node의 자식요소중 old를 new로 대체한다.
- `document.write(text)` : HTML output stream 으로 text를 작성한다.

🔹동적으로 버튼생성하여 body에 추가하기.

```
var btn = document.createElement("button");          //h1태그 element생성
btnText = document.createTextNode("click");          //click이라는 텍스트 노드 생성
btn.appendChild(btnText);                            //텍스트를 버튼에 부착. (버튼의 자식노드로 텍스트 노드를 삽입함)
document.body.appendChild(btn);                      // 완성된 버튼을 body의 자식요소로 넣음.
 var btnText2= document.createTextNode("new click"); //새로운 버튼 텍스트 생성
 btn.replaceChild(btnText2,btnText1);                //text1->text2로 대체
btn.parentNode.removeChild(btn);                     // 버튼의 부모노드에서 자식노드를 삭제함 (=본인 삭제)
```

🔹특정 태그 삭제하기
```
//To remove a specified element without having to specify its parent node.
let node = document.getElementById("newid"); 
            if (node.parentNode) { 
                node.parentNode.removeChild(node); 
                    }

```
## Finding HTML Objects with HTML Object collection

: s가 붙는것들은 값이 여러개 이므로 index를 통해 접근해주면 된다.

- `document.anchors` : name속성을 지닌 모든 `<a>` elements ,index로 접근
            
 ex) `document.anchors[3].innerHTML="3th <a> tag";` //세번째 a태그의 내용 변경
- `document.body` : `<body>` element
- `document.cookie` : document's cookie
- `document.domain` : domain_name of document server
- `document.forms` : name속성을 지닌 모든 `<form>` elements
ex) `document.forms["form_name"]["input_name"].value` // form n

- `document.images` : 모든 `<img>` 태그
            
ex ) `document.images[0].src="https:~~"` // 첫번째 이미지의 주소 변경. figure태그에 둘러싸여 있지 않아도 인식됨.            
ex ) `document.images.length;` //문서내의 이미지의 개수                        
- `document.links` : href 속성을 지닌 모든 `<a>`와 `<area>` 요소
- `document.referrer`: 링크를 통해 현재 페이지로 이동 시킨, 전 페이지의 URI 정보를 반환.
- `document.title` : `<title>` element 반환
- `document.URL` : complete URL 반환          
           

🔹form 태그를 가져오는 세가지 방법

1. `document.forms["form_name"]`
2. `document.forms[i]`
3. `document.form_name` 
 
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

✨Capturing 과 Bubbling 

▶Capturing : 이벤트가 발생한 target element의 최상위부모 -> target까지 순차적으로 내려오면서 이벤트 전달(TopDown)

▶Bubbling : 이벤트가 발생한 target element부터 최상위 부모까지 순차적으로 올라가면서 이벤트가 전달되는 방식(BottomUp)

[🔍Capturing 과 Bubbling ](https://dimdim.tistory.com/entry/javascript%EC%97%90%EC%84%9C-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%B2%98%EB%A6%AC%EB%A5%BC-%EC%9C%84%ED%95%9C-addEventListener-%ED%95%A8%EC%88%98-%EC%84%A4%EB%AA%85)
[ 이벤트타입목록1](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=qbxlvnf11&logNo=220877806711)
[ 이벤트타입목록2](https://jenny-daru.tistory.com/17)

## HTML function 

`setInterval(func_name,time)` : time간격마다 func을 실행한다. 1000=1초
`clearInterval(elment)` :  현재 진행되고 있는 함수의 진행을 멈추는데 쓰인다.
`Date(): 현재시간을 string으로 반환`


```
var id=setInterval(func,500); //0.5초마다 func 실행
clearInterval(id); // 실행을 멈춘다.
```


