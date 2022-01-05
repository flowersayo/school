
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class VibratingFrame  extends JFrame implements Runnable { //JFrame이면서 동시에 스레드역할

	Thread th; // 프레임을 진동시키는 쓰레드
	public VibratingFrame () {
		
		setTitle("진동하는 스레드 종료시키기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(250,200);
		setVisible(true);
		setLocation(500,500);
		

		Container c= getContentPane();
		c.addMouseListener(new MouseAdapter() { //Adapter도 Listener를 통해 설정해야함.
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!th.isAlive())  //스레드가 살아있지않으면 
					return;
				
				th.interrupt(); // 스레드가 살아있으면 종료
				
			}
		});
		
		th = new Thread (this); //진동하는 스레드 객체 생성
		th.start();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VibratingFrame();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r= new Random();
		
		while(true) {
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}
			
			
			//진동범위는 현재 좌표에서 +=5
			int x=getX()+r.nextInt()%5;
			int y=getY()+r.nextInt()%5;
			setLocation(x,y); 
			
		}
	}

}
