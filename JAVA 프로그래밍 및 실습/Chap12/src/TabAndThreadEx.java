
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyLabel extends JLabel{
	int barSize=0; //현재게이지
	int maxBarSize; // 최대게이지
	
	public MyLabel(int maxBarsize) {
		this.maxBarSize=maxBarsize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.MAGENTA);
		int width =(int)(((double) this.getWidth()/maxBarSize*barSize ));
		
		if(width==0)
			return;
		g.fillRect(0, 0, width, this.getHeight()); 
		
	}
	
	synchronized void fill() {
		if(barSize==maxBarSize)
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}
		
		System.out.println("fill");
		barSize++; //꽉찬게 아니라면 barSize늘림
		repaint();//다시그림
		notify(); //대기중인 스레드 깨움.
	}
	
	synchronized void consume() {
		if(barSize ==0)
			try {
				wait(); 
				System.out.println("consume 대기상태");
			} catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}
		barSize--;
		repaint();
		System.out.println("consume");
		notify(); //wait상태에 놓인 스레드 하나를 깨운다. 
		
	}
}

// bar의 게이지를 감소시키는 스레드
class ConsumerThread extends Thread{
	MyLabel bar;
	
	public ConsumerThread(MyLabel bar){
		this.bar=bar;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				sleep(1000);
				bar.consume();
			}
			catch(InterruptedException e) {
				return;
			}
		}
		//super.run(); //이문장 없어도됨
	}
}
public class TabAndThreadEx extends JFrame {

	
	MyLabel bar = new MyLabel(100); //커스텀 라벨 클래스 객체
	public TabAndThreadEx() {
		
		setTitle("Tab으로 게이지 채우기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c= getContentPane();
		c.setLayout(null);
		
		bar.setBackground(Color.ORANGE);  //기본 배경색
		bar.setOpaque(true);
		bar.setSize(300,20);
		bar.setLocation(20,50);
		c.add(bar);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				 bar.fill();
			}
		});
		
		
		setSize(350,200);
		setVisible(true);
				
		c.setFocusable(true);
		c.requestFocus();
		ConsumerThread th = new ConsumerThread (bar);
		th.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TabAndThreadEx();
	}

}
