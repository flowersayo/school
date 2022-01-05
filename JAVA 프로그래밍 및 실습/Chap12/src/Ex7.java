

import java.util.Scanner;


public class Ex7 implements Runnable{ //Runable 인터페이스를 이용해서 개발
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		//실행 되자 마자 1에서 10까지 콘솔창에 출력한 후 종료
			for(int i=1;i<=10;i++) {
				
				System.out.print(i+" ");
			}
			System.out.println("\n스레드 종료");
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("아무키나 입력>>");
		Scanner s =new Scanner(System.in);
		String str=s.next();
		
		System.out.println("스레드 실행 시작");
		
		
		Thread ex7 = new Thread(new Ex7()); //스레드 객체 생성
		
		ex7.start(); //스레드 실행
		
		
		

		
	}
}

		
