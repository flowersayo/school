import java.util.Vector;

public class IteratorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Vector<Integer> v =new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2,100);
		
		// 5 4 100 -1
		
		
		//iterator를 활용한 베터 순회
		var it =v.iterator();
		
		int sum=0;
		while (it.hasNext()) {
			
			int n=it.next();
			sum+=n;
			System.out.println(n);
			
		}
		
		System.out.println("벡터에있는 정수 합 :" +sum);
	}

}
