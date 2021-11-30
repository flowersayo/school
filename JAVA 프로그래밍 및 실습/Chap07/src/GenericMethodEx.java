
public class GenericMethodEx {

	//GStack<T> 를 리턴하는 메소드. <T> 를 한번더 적어줘야함에 유의!
	//GStack을 받아서 내용을 거꾸로 만듬. pop해서 다른 stack 에 push
	public static <T> GStack<T> reverse(GStack<T> a){
		GStack<T> s = new GStack<>();
		while(true) {
			
			T tmp;
			tmp =a.pop();
			if(tmp ==null)
				break;
			else
				s.push(tmp);
		}
		
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GStack<Double> gs=new GStack<Double>();
		
		for (int i=0;i<5;i++) {
			gs.push(new Double(i));
			
		}
		
		gs=reverse(gs);
		for (int i=0;i<5;i++) {
			System.out.println(gs.pop() );
		}
	}

}
