
public class SynchronizedEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SharedPrinter p =new SharedPrinter();
		String [] engText= {"adfds","dfsasdf","asdfsadg","Ggdsa","gyhdfdf","SDggfd"};
		String [] korText= {"ㄱㅇㅁㄹㄴ","ㄴㅇㄻㄴㅇ","ㅇㄴㄻㄴㅇ","ㄴㅇㄻㅎ","ㄴㅁㅇㅎㅁ","ㅁㄴㅇㅎㅁ"};
		
		Thread th1 = new WorkThread(p,engText);
		Thread th2 = new WorkThread(p,korText);
		
		th1.start();
		th2.start();
	}

}

class SharedPrinter{
	
synchronized void print(String text) {
		
		
		for(int i=0;i<text.length();i++) {
			System.out.print(text.charAt(i)); //i번째 문자 출력
		}
		System.out.println();
	}
}


// SharedPrinter p , String [] text 를 전달해주면 p의 print함수를 통해 문자열을 하나씩 호출해주는 스레드
class WorkThread extends Thread {
	
	SharedPrinter p;
	String [] text;
	
	public WorkThread(SharedPrinter p, String [] text) {
		this.p=p;
		this.text=text;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<text.length;i++) {
			p.print(text[i]); //공유 프린터 이용해서 i번째줄 출력.
			
		}

	}
}