
public class GStack <T>{
	
	int tos;
	Object [] stack; //배열 레퍼런스 생성
	
	public GStack() {
		tos = 0;
		stack = new Object[10]; //실제 배열 내용 생성
		
	}
	
	public void push(T item) {
		if(tos==10)
			return;
			stack[tos++]=item;
		
	}
	
	public T pop () {
		if(tos==0)
			return null;
		return (T)stack[--tos];
		
	}
	
	
}