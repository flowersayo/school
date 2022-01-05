
public class ThreadMainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long id =Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority(); //우선순위 기본 디폴트는 5
		Thread.State s = Thread.currentThread().getState(); //스레드 상태
		
		System.out.println(name+' '+id+' '+priority+' '+s);
	}

}
