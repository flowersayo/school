
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

//깜빡 거리는 레이블을 생성하는 클래스 
class FlickingLabel extends JLabel implements Runnable{

	long delay;
	
	public FlickingLabel(String text,long delay) {
		// TODO Auto-generated constructor stub
		
		super(text); //Jlabel 에 text설정
		this.delay=delay; //딜레이 설정
		setOpaque(true); //배경색 변경이 가능하도록
		
		
		Thread th =new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int n=0; //카운트 숫자
		
		while(true) {
			if(n==0)
				{ setBackground(Color.YELLOW);
				   n=1;
				
				}
			else
				{setBackground(Color.GREEN);
						n=0;
				}
			
			try {
				Thread.sleep(delay); // delay만큼 쉬기.
				
			} catch (InterruptedException e) { //스레드 예외처리 InterruptedException
				// TODO: handle exception
				return;
			}
			
			
		}
	}
	
	
	
	
}
public class FlickingLabelEx  extends JFrame {

	public FlickingLabelEx() {
		
		setTitle("깜빡거리는 글씨 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		
		//깜박거리는 레이블
		FlickingLabel fLabel= new FlickingLabel("깜빡(500)", 500);
		
		//깜박거리지 않는 레이블
		JLabel label = new JLabel("안깜빡");

		
		//깜박거리는 레이블
		FlickingLabel fLabel2= new FlickingLabel("여기도 깜빡(300)", 300);
		
		
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);
		
		
		setSize(300,150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlickingLabelEx();
	}

}
