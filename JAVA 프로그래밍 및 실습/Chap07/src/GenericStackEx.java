
public class GenericStackEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GStack <String> stack = new GStack <String>();
		
		stack.push("서울");
		stack.push("부산");
		stack.push("LA");
		
		for (int i=0;i<3;i++) {
			System.out.println(stack.pop());
		}
		
		var inStack = new GStack <Integer>();
		
		inStack.push(4);
		inStack.push(2);
		inStack.push(3);
		
		for (int i=0;i<3;i++) {
			System.out.println(inStack.pop());
		}
	}

}
